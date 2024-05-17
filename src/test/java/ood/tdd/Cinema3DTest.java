package ood.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Calendar;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class Cinema3DTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Assertions.assertEquals(ticket, new Ticket3D());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenAddTwoTheSameSessionsThenItsQtyIsOne() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        Session sessionTheSame = session;
        cinema.add(session);
        cinema.add(sessionTheSame);
        long numberOfSessions = cinema.find(data -> true).stream().count();
        assertThat(numberOfSessions).isEqualTo(1);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnInvalidColumnThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, 1, -1, date)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyTicketForThePastThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.roll(Calendar.DATE, -1);
        assertThatThrownBy(() -> cinema.buy(account, 1, -1, date)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyTicketWithoutAccountThenGetException() {
        Account account = null;
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.roll(Calendar.DATE, -1);
        assertThatThrownBy(() -> cinema.buy(account, 1, -1, date)).isInstanceOf(IllegalArgumentException.class);
    }
}
