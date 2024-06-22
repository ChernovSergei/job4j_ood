package products;

import java.util.Calendar;
import java.util.Map;

public class Warehouse extends AbstractStore {
        public String name = "Warehouse";

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
        if (lifeTimePercent < 25 & lifeTimePercent > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public Map<String, Food> getAllProducts() {
        return super.getAllProducts();
    }
}
