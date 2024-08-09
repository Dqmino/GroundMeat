package codes.domino.recorder;

import java.awt.*;
import java.util.Map;

public interface Recorder<T> {
    int startRecording(Component component);

    T stopRecording(int id);

    T getRecording(int id);

    Map<Integer, T> getRecords();
}
