package products;

import java.util.Calendar;

public class EffectiveLifeCalculator implements StoreLifeCalc {
    @Override
    public int calcStoreLife(Calendar creation, Calendar expiration, Calendar reference) {
        long lifeSpan = expiration.getTimeInMillis() - creation.getTimeInMillis();
        long holdingSpan = reference.getTimeInMillis() - creation.getTimeInMillis();
        if (lifeSpan < 0) {
            throw new IllegalArgumentException("Creation date should precede expiration date");
        }
        if (holdingSpan < 0) {
            throw new IllegalArgumentException("Creation date should precede reference date");
        }
        return Math.round((float) holdingSpan * 100 / (float) lifeSpan);
    }
}
