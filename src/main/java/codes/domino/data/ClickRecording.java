package codes.domino.data;

import java.io.Serializable;
import java.util.Queue;

public record ClickRecording(Queue<ClickHistory> clickQueue) implements Serializable {

}

