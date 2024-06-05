package srp.report;

import org.junit.jupiter.api.Test;
import srp.currency.Currency;
import srp.currency.CurrencyConverter;
import srp.currency.InMemoryCurrencyConverter;
import srp.formatter.DateTimeParser;
import srp.formatter.ReportDateTimeParser;
import srp.model.Employee;
import srp.store.MemoryStore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportEngineTest {

    @Test
    void whenOldGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportEngine(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

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

    @Test
    void whenHRGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Nastya", now, now, 50);
        Employee worker3 = new Employee("Nikita", now, now, 150);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HRReport(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")
                .append(worker3.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

    @Test
    void whenSoftwareEngGenerated() throws IOException {
        MemoryStore store = new MemoryStore();
        String absolutePath = "C:/projects/job4j_ood/src/main/resources";
        String fileName = "softwareEng.csv";
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Nastya", now, now, 50);
        Employee worker3 = new Employee("Nikita", now, now, 150);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new SoftwareEngReport(store, parser, absolutePath, fileName);
        engine.generate(employee -> true);
        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(",")
                .append(parser.parse(worker1.getHired())).append(",")
                .append(parser.parse(worker1.getHired())).append(",")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(",")
                .append(parser.parse(worker2.getHired())).append(",")
                .append(parser.parse(worker2.getHired())).append(",")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(",")
                .append(parser.parse(worker3.getHired())).append(",")
                .append(parser.parse(worker3.getHired())).append(",")
                .append(worker3.getSalary())
                .append(System.lineSeparator());
        assertThat(Files.readString(Path.of(absolutePath + "/" + fileName))).isEqualTo(expected.toString());
    }
}