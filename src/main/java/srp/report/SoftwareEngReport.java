package srp.report;

import srp.formatter.DateTimeParser;
import srp.model.Employee;
import srp.recorders.CSVRecorder;
import srp.recorders.Recorder;
import srp.store.Store;

import java.io.IOException;
import java.util.Calendar;
import java.util.function.Predicate;

public class SoftwareEngReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private String absolutePath;
    private String fileName;

    public SoftwareEngReport(Store store, DateTimeParser<Calendar> dateTimeParser, String absolutePath, String fileName) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.absolutePath = absolutePath;
        this.fileName = fileName;
    }

    private void recordDataToCSV(String absolutePath, String fileName, String data) {
        Recorder recorder = new CSVRecorder(absolutePath, fileName);
        try {
            recorder.recordFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(",")
                    .append(dateTimeParser.parse(employee.getHired())).append(",")
                    .append(dateTimeParser.parse(employee.getFired())).append(",")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        recordDataToCSV(absolutePath, fileName, text.toString());
        return text.toString();
    }
}
