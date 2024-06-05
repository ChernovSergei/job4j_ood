package srp.report;

import java.util.Calendar;
import java.util.function.Predicate;

import srp.currency.Currency;
import srp.currency.InMemoryCurrencyConverter;
import srp.formatter.DateTimeParser;
import srp.model.Employee;
import srp.store.Store;

public class AccountantReport implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Currency originCurrency;
    private final Currency finalCurrency;

    public AccountantReport(Store store, DateTimeParser<Calendar> dateTimeParser, Currency originCurrency, Currency finalCurrency) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.originCurrency = originCurrency;
        this.finalCurrency = finalCurrency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(originCurrency, employee.getSalary(), finalCurrency))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
