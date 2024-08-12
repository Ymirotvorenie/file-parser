package shift.code;

import lombok.Getter;
import shift.code.report.FloatReport;
import shift.code.report.IntegerReport;
import shift.code.report.Report;
import shift.code.report.StringReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class Statistics {


    private final boolean isShort;

    private final boolean isFull;

    private final List<Report> reports = new ArrayList<>();

    public Statistics(boolean isShort, boolean isFull) {
        this.isShort = isShort;
        this.isFull = isFull;
    }

    public void addReports(Map<String, List<String>> elements, String prefix) {
        for (var key : elements.keySet()) {
            String fileName = prefix + key + Utils.FILE_EXTENSION;
            var content = elements.get(key);
            if (isShort) {
                var report = getReport(Report.EMPTY);
                report.generate(content, fileName);
                reports.add(report);
            }

            if (isFull) {
                if (!content.isEmpty()) {
                    var report = getReport(key);
                    report.generate(content, fileName);
                    reports.add(report);
                }
            }
        }
    }

    public String getStatistics() {
        var result = new StringBuilder();
        for (var report : reports) {
            result.append(report);
        }
        return result.toString();
    }

    private Report getReport(String key) {
        return switch (key) {
            case Report.INTEGERS -> new IntegerReport();
            case Report.FLOATS -> new FloatReport();
            case Report.STRINGS -> new StringReport();
            default -> new Report();
        };
    }
}
