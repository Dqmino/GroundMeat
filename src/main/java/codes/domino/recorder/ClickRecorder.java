package codes.domino.recorder;

import codes.domino.data.ClickHistory;
import codes.domino.data.ClickRecording;
import codes.domino.gui.MainMenu;
import codes.domino.serializer.ClickRecordsSerializer;
import codes.domino.serializer.MapSerializer;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class ClickRecorder implements Recorder<ClickRecording> {
    private static ClickRecorder instance;
    private final Map<Integer, ClickRecording> recordings = new HashMap<>();

    private int listeningTo;

    private ClickRecorder() {
        MapSerializer<Integer, ClickRecording> serializer = ClickRecordsSerializer.getInstance();
        try {
            Map<Integer, ClickRecording> loadedMap = serializer.load();
            if (loadedMap == null) {
                System.err.println("Failed to load recordings");
                return;
            } else if (loadedMap.isEmpty()) {
                System.err.println("Recording List is empty?");
                return;
            }
            recordings.putAll(loadedMap);
            recordings.forEach((key, ignored) -> MainMenu.getInstance().addRecording(key));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ClickRecorder getInstance() {
        if (instance == null) {
            instance = new ClickRecorder();
        }
        return instance;
    }

    @Override
    public int startRecording(Component component) {

        int id = new Random().nextInt();
        listeningTo = id;
        ClickRecording recording = new ClickRecording(new LinkedList<>());
        final long[] lastClick = {System.currentTimeMillis()};
        component.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int button = e.getButton();
                if (listeningTo != id) {
                    return;
                }
                recording.clickQueue().add(new ClickHistory(System.currentTimeMillis() - lastClick[0], button));
                lastClick[0] = System.currentTimeMillis();
                Random random = new Random();
                if (random.nextBoolean() || random.nextBoolean() || random.nextBoolean() || random.nextBoolean()) {
                    // 0.94 chance
                    recording.clickQueue().add(new ClickHistory(System.currentTimeMillis() + 44 - lastClick[0], button));
                    lastClick[0] = System.currentTimeMillis() + 43;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        recordings.put(id, recording);
        return id;
    }

    @Override
    public ClickRecording stopRecording(int id) {
        listeningTo = 0;

        return getRecording(id);
    }

    @Override
    public ClickRecording getRecording(int id) {
        return recordings.get(id);
    }

    @Override
    public Map<Integer, ClickRecording> getRecords() {
        return recordings;
    }
}
