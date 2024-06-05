package srp.report;

import srp.formatter.DateTimeParser;
import srp.model.Employee;
import srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class HRReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public HRReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        store.findBy(filter).stream()
                .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                .peek(e -> text.append(e.getName()).append(" "))
                .peek(e -> text.append(e.getSalary()))
                .forEach(e -> text.append(System.lineSeparator()));
        return text.toString();
    }
}
