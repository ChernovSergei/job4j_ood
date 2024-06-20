package srp.report;

import srp.model.Employee;
import srp.store.MemoryStore;
import srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {
    private final Store store;

    public XmlReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String result = "";
        try {
            JAXBContext context = JAXBContext.newInstance(MemoryStore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(store, writer);
            result = writer.getBuffer().toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
