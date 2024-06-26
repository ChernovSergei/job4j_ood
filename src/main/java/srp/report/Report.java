package srp.report;

import srp.model.Employee;
import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
