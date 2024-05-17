package ood.tdd;

import java.util.List;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.Calendar;

public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return new LinkedList<>();
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return new Ticket3D();
    }

    @Override
    public void add(Session session) {
    }
}
