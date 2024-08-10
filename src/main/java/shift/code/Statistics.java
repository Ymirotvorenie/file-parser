package shift.code;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private boolean isShort;
    private boolean isFull;

    private List<Report> reports = new ArrayList<>();

    public Statistics(boolean isShort, boolean isFull) {
        this.isShort = isShort;
        this.isFull = isFull;
    }
}
