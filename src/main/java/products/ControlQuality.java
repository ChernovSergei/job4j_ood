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
}
