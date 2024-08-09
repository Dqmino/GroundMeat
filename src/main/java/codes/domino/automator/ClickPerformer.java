package codes.domino.automator;

import codes.domino.data.ClickHistory;
import codes.domino.data.ClickRecording;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ClickPerformer {
    private final static ClickPerformer clickPerformer = new ClickPerformer();
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private boolean shouldLoop;
    private boolean shouldClick = true;
    private boolean isDone = true;

    public static ClickPerformer getInstance() {
        return clickPerformer;
    }

    public void startPlaying(ClickRecording recording) throws AWTException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        this.shouldClick = true;
        Robot robot = new Robot();
        Queue<ClickHistory> copyQueue = new ArrayDeque<>(recording.clickQueue());
        while (copyQueue.peek() != null && this.shouldClick) {
            long whenToClick = copyQueue.peek().whenToClick();
            int button = copyQueue.peek().button();
            int btnToClick = InputEvent.class.getField("BUTTON" + button + "_DOWN_MASK").getInt(null);
            robot.mousePress(btnToClick);
            robot.mouseRelease(btnToClick);
            Thread.sleep(whenToClick);
            copyQueue.poll();
            this.isDone = false;
        }
        this.isDone = true;
    }

    public void onRepeat(ClickRecording recording) throws InterruptedException, AWTException {
        CompletableFuture.runAsync(() -> {
            while (this.shouldLoop && this.isDone) {
                try {
                    startPlaying(recording);
                } catch (AWTException | InterruptedException | NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public boolean shouldLoop() {
        return shouldLoop;
    }

    public void setShouldLoop(boolean shouldLoop) {
        this.shouldLoop = shouldLoop;
    }

    public void setShouldClick(boolean shouldClick) {
        this.shouldClick = shouldClick;
    }
}
