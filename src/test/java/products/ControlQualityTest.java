package products;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenAddFoodIsTrash() {
        Food mandarin = new Food("Mandarin",
                new GregorianCalendar(2024, Calendar.JUNE, 1, 17, 17),
                new GregorianCalendar(2024, Calendar.MAY, 1, 17, 17),
                100,
                10);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality quality = new ControlQuality();
        quality.addStore(shop);
        quality.addStore(trash);
        quality.addStore(warehouse);
        quality.addFood(mandarin);
        assertThat(trash.getAllProducts().containsKey(mandarin.getName())).isTrue();
    }

    @Test
    void whenAddFoodIsInShopWithDiscount() {
        Food banana = new Food("Banana",
                new GregorianCalendar(2024, Calendar.JULY, 1, 17, 17),
                new GregorianCalendar(2024, Calendar.APRIL, 1, 17, 17),
                100,
                10);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality quality = new ControlQuality();
        quality.addStore(shop);
        quality.addStore(trash);
        quality.addStore(warehouse);
        quality.addFood(banana);
        assertThat(shop.getAllProducts().containsKey(banana.getName())).isTrue();
        assertThat(banana.getPrice()).isEqualTo(90);
    }

    @Test
    void whenAddFoodIsInShopWithoutDiscount() {
        Food banana = new Food("Banana",
                new GregorianCalendar(2024, Calendar.JULY, 1, 17, 17),
                new GregorianCalendar(2024, Calendar.JUNE, 1, 17, 17),
                100,
                10);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality quality = new ControlQuality();
        quality.addStore(shop);
        quality.addStore(trash);
        quality.addStore(warehouse);
        quality.addFood(banana);
        assertThat(shop.getAllProducts().containsKey(banana.getName())).isTrue();
        assertThat(banana.getPrice()).isEqualTo(100);
    }

    @Test
    void whenAddFoodIsInWarehouse() {
        Food cucumber = new Food("Cucumber",
                new GregorianCalendar(2024, Calendar.JULY, 20, 17, 17),
                new GregorianCalendar(2024, Calendar.JUNE, 20, 17, 17),
                100,
                10);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality quality = new ControlQuality();
        quality.addStore(shop);
        quality.addStore(trash);
        quality.addStore(warehouse);
        quality.addFood(cucumber);
        assertThat(warehouse.getAllProducts().containsKey(cucumber.getName())).isTrue();
    }
}