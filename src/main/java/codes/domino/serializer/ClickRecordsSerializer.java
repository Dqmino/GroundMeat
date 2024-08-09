package codes.domino.serializer;

import codes.domino.data.ClickRecording;
import codes.domino.recorder.ClickRecorder;

import java.util.Map;

public class ClickRecordsSerializer extends MapSerializer<Integer, ClickRecording> {
    private static MapSerializer<Integer, ClickRecording> serializer;

    private ClickRecordsSerializer() {
    }

    public static MapSerializer<Integer, ClickRecording> getInstance() {
        if (serializer == null) {
            serializer = new ClickRecordsSerializer();
        }
        return serializer;
    }

    @Override
    Map<Integer, ClickRecording> getMapToSerialize() {
        return ClickRecorder.getInstance().getRecords();
    }

    @Override
    String getDirectoryPath() {
        return System.getenv("APPDATA");
    }
}
