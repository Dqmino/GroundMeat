package codes.domino.data;

import java.io.Serializable;

public record ClickHistory(long whenToClick, int button) implements Serializable {
}
