package products;


import java.util.Calendar;

public interface StoreLifeCalc {
    int calcStoreLife(Calendar creation, Calendar expiration, Calendar reference);
}
