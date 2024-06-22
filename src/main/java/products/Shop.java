package products;

import java.util.Calendar;
import java.util.Map;

public class Shop extends AbstractStore {
    public String name = "Shop";

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
        if (lifeTimePercent > 75 & lifeTimePercent < 100) {
            food.setPrice(getPriceWithDiscount(food.getPrice(), food.getDiscount()));
        }
        if (lifeTimePercent > 25 & lifeTimePercent < 100) {
            result = true;
        }
        return result;
    }

    @Override
    public Map<String, Food> getAllProducts() {
        return super.getAllProducts();
    }

    public double getPriceWithDiscount(double originalPrice, int discount) {
        return originalPrice - (originalPrice * discount / 100);
    }

    public void sellFood(Food food) {
        /**
         * sell the food for a price - discount
         */
    }
}
