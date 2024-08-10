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

    public void addReports(Map<String,List<String>> elements, String prefix) {

        if(isShort) {
            for(var key : elements.keySet()) {
                String fileName = prefix + key + ".txt";
                reports.add(new Report(elements.get(key).size(), fileName));
            }
        }
        if(isFull) {
            for (var key: elements.keySet()) {
                String fileName = prefix + key + ".txt";
                var content = elements.get(key);
                if(!content.isEmpty()) {
                    switch (key) {
                        case "integers": {
                            var report = new IntegerReport(elements.get(key).size(),fileName);
                            report.generate(elements.get(key));
                            reports.add(report);
                            break;
                        }
                        case "floats": {
                            var report = new FloatReport(elements.get(key).size(), fileName);
                            report.generate(elements.get(key));
                            reports.add(report);
                            break;
                        }
                        case "strings": {
                            var report = new StringReport(elements.get(key).size(), fileName);
                            report.generate(elements.get(key));
                            reports.add(report);
                            break;
                        }
                    }
                }
            }
        }
    }

    public String getStatistics() {
        var result = new StringBuilder();
        for(var report : reports) {
            result.append(report);
        }
        return result.toString();
    }
}
