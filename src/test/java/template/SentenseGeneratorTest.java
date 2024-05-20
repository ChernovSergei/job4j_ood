package template;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SentenseGeneratorTest {

    @Test
    void whenTemplateHasExtraKey() {
        Map<String, String> personnel = new HashMap<>();
        String template = "Name - ${name}, Position - ${position}, Married - ${extra_key}.";
        personnel.put("Vasiliy", "Engineer");
        personnel.put("Natalia", "Accountant");
        personnel.put("Yulia", "Lower");
        personnel.put("Nikita", "Software Engineer");
        Generator sentenseGenerator = new SentenseGenerator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sentenseGenerator.produce(template, personnel);
        });
        assertThat(exception.getMessage()).isEqualTo("ERROR: Template has to have only two keys");
    }

    @Test
    void whenMapHasKeyNull() {
        Map<String, String> personnel = new HashMap<>();
        String template = "Name - ${name}, Position - ${position}";
        personnel.put("Vasiliy", "Engineer");
        personnel.put("Natalia", "Accountant");
        personnel.put("Yulia", "Lower");
        personnel.put("Nikita", "Software Engineer");
        personnel.put(null, "Software Engineer");
        Generator sentenseGenerator = new SentenseGenerator();
        assertThat(sentenseGenerator.produce(template, personnel)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void whenMapHasExtraKey() {
        Map<String, String> personnel = new HashMap<>();
        String template = "Name - ${name}, Position - ${position}";
        personnel.put("Vasiliy", "Engineer");
        personnel.put("Natalia", "Accountant");
        personnel.put("Yulia", "Lower");
        personnel.put("Nikita", "Software Engineer");
        personnel.put("Vasiliy", "Software Engineer");

        Generator sentenseGenerator = new SentenseGenerator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sentenseGenerator.produce(template, personnel);
        });
        assertThat(exception.getMessage()).isEqualTo("ERROR: Map hax extra key. One key cannot have two values");
    }
}