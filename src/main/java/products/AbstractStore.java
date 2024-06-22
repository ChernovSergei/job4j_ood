package products;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractStore implements Store {
    Map<String, Food> foodStore = new HashMap<>();

    @Override
    public boolean addToStore(Food food) {
        foodStore.put(food.getName(), food);
        return true;
    }

    @Override
    public void extractFromStore(Food food) {
        foodStore.remove(food.getName(), food);
    }

    public Map<String, Food> getAllProducts() {
        return foodStore;
    }

    abstract boolean validate(Food food);
}
