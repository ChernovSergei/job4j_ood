package products;

import java.util.*;

public class ControlQuality {
    LinkedList<Store> stores = new LinkedList<>();

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addFood(Food food) {
        for (Store store : stores) {
            store.addToStore(food);
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.removeFromStore());
        }
        for (Food food : foods) {
            stores.forEach(s -> s.addToStore(food));
        }
    }
}
