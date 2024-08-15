package products;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Trash extends AbstractStore {
    public String name = "Trash";

    @Override
    public boolean addToStore(Food food) {
        if (validate(food)) {
            return super.addToStore(food);
        }
        return false;
    }

    @Override
    public void extractFromStore(Food food) {
        super.extractFromStore(food);
    }

    @Override
    public boolean validate(Food food) {
        boolean result = false;
        EffectiveLifeCalculator calculator = new EffectiveLifeCalculator();
        int lifeTimePercent = calculator.calcStoreLife(food.getCreateDate(), food.getExpiryDate(), Calendar.getInstance());
        if (lifeTimePercent >= 100) {
            result = true;
        }
        return result;
    }

    @Override
    public Map<String, Food> getAllProducts() {
        return super.getAllProducts();
    }

    @Override
    public List<Food> removeFromStore() {
        return super.removeFromStore();
    }
}
