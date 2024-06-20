package srp.report;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import srp.formatter.JsonDateAdapter;
import srp.model.Employee;
import srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {
    private final Store store;

    public JsonReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        builder.registerTypeAdapter(Calendar.class, new JsonDateAdapter());
        builder.registerTypeAdapter(GregorianCalendar.class, new JsonDateAdapter());
        Gson gson = builder.create();
        return gson.toJson(store.findBy(filter));
    }
}
