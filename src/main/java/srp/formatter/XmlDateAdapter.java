package srp.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class XmlDateAdapter extends XmlAdapter<String, Calendar> {
    private static final SimpleDateFormat CUSTOM_FORMAT_STRING = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String s) {
        return null;
    }

    @Override
    public String marshal(Calendar calendar) {
        return CUSTOM_FORMAT_STRING.format(calendar.getTime());
    }
}
