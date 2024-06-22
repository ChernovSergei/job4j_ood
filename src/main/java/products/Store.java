package products;

public interface Store {
    boolean addToStore(Food food);

    void extractFromStore(Food food);
}
