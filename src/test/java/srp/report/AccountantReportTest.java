package srp.report;

import org.junit.jupiter.api.Test;
import srp.currency.Currency;
import srp.currency.CurrencyConverter;
import srp.currency.InMemoryCurrencyConverter;
import srp.formatter.DateTimeParser;
import srp.formatter.ReportDateTimeParser;
import srp.model.Employee;
import srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class AccountantReportTest {

    @Test
    void whenAccountantGenerated() {
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new AccountantReport(store, parser, Currency.RUB, Currency.USD);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.USD))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}