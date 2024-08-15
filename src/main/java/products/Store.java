package products;

import java.util.List;

public interface Store {
    boolean addToStore(Food food);

    void extractFromStore(Food food);

    List<Food> removeFromStore();
}
