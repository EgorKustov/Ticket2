package TicketManager;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void testSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket Ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket Ticket2 = new Ticket("MSK", "SOCHI", 300, 8, 11);
        Ticket Ticket3 = new Ticket("MSK", "SPB", 150, 13, 17);
        Ticket Ticket4 = new Ticket("KZN", "MSK", 150, 17, 19);
        Ticket Ticket5 = new Ticket("MSK", "SPB", 350, 5, 9);
        Ticket Ticket6 = new Ticket("MSK", "SPB", 250, 20, 22);
        Ticket Ticket7 = new Ticket("KZN", "SOCHI", 400, 10, 15);
        Ticket Ticket8 = new Ticket("NN", "SPB", 150, 11, 13);
        manager.add(Ticket1);
        manager.add(Ticket2);
        manager.add(Ticket3);
        manager.add(Ticket4);
        manager.add(Ticket5);
        manager.add(Ticket6);
        manager.add(Ticket7);
        manager.add(Ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {Ticket3, Ticket1, Ticket6, Ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket Ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket Ticket2 = new Ticket("MSK", "SOCHI", 300, 8, 11);
        Ticket Ticket3 = new Ticket("MSK", "SPB", 150, 13, 17);
        Ticket Ticket4 = new Ticket("KZN", "MSK", 150, 17, 19);
        Ticket Ticket5 = new Ticket("MSK", "SPB", 350, 5, 9);
        Ticket Ticket6 = new Ticket("MSK", "SPB", 250, 20, 22);
        Ticket Ticket7 = new Ticket("KZN", "SOCHI", 400, 10, 15);
        Ticket Ticket8 = new Ticket("NN", "SPB", 150, 11, 13);
        manager.add(Ticket1);
        manager.add(Ticket2);
        manager.add(Ticket3);
        manager.add(Ticket4);
        manager.add(Ticket5);
        manager.add(Ticket6);
        manager.add(Ticket7);
        manager.add(Ticket8);

        Ticket[] actual = manager.search("SOCHI", "NN");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket Ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket Ticket2 = new Ticket("MSK", "SOCHI", 300, 8, 11);
        Ticket Ticket3 = new Ticket("MSK", "SPB", 150, 13, 17);
        Ticket Ticket4 = new Ticket("KZN", "MSK", 150, 17, 19);
        Ticket Ticket5 = new Ticket("MSK", "SPB", 350, 5, 9);
        Ticket Ticket6 = new Ticket("MSK", "SPB", 250, 20, 22);
        Ticket Ticket7 = new Ticket("KZN", "SOCHI", 400, 10, 15);
        Ticket Ticket8 = new Ticket("NN", "SPB", 150, 11, 13);
        manager.add(Ticket1);
        manager.add(Ticket2);
        manager.add(Ticket3);
        manager.add(Ticket4);
        manager.add(Ticket5);
        manager.add(Ticket6);
        manager.add(Ticket7);
        manager.add(Ticket8);

        Ticket[] actual = manager.search("NN", "SPB");
        Ticket[] expected = {Ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket Ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket Ticket2 = new Ticket("MSK", "SOCHI", 300, 8, 11);
        Ticket Ticket3 = new Ticket("MSK", "SPB", 150, 10, 17);
        Ticket Ticket4 = new Ticket("KZN", "MSK", 150, 17, 19);
        Ticket Ticket5 = new Ticket("MSK", "SPB", 350, 5, 9);
        Ticket Ticket6 = new Ticket("MSK", "SPB", 250, 18, 23);
        Ticket Ticket7 = new Ticket("KZN", "SOCHI", 400, 10, 15);
        Ticket Ticket8 = new Ticket("NN", "SPB", 150, 11, 13);
        manager.add(Ticket1);
        manager.add(Ticket2);
        manager.add(Ticket3);
        manager.add(Ticket4);
        manager.add(Ticket5);
        manager.add(Ticket6);
        manager.add(Ticket7);
        manager.add(Ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Ticket[] expected = {Ticket1, Ticket5, Ticket6, Ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket Ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket Ticket2 = new Ticket("MSK", "SOCHI", 300, 8, 11);
        Ticket Ticket3 = new Ticket("MSK", "SPB", 150, 10, 17);
        Ticket Ticket4 = new Ticket("KZN", "MSK", 150, 17, 19);
        Ticket Ticket5 = new Ticket("MSK", "SPB", 350, 5, 9);
        Ticket Ticket6 = new Ticket("MSK", "SPB", 250, 18, 23);
        Ticket Ticket7 = new Ticket("KZN", "SOCHI", 400, 10, 15);
        Ticket Ticket8 = new Ticket("NN", "SPB", 150, 11, 13);
        manager.add(Ticket1);
        manager.add(Ticket2);
        manager.add(Ticket3);
        manager.add(Ticket4);
        manager.add(Ticket5);
        manager.add(Ticket6);
        manager.add(Ticket7);
        manager.add(Ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "NN", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket Ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket Ticket2 = new Ticket("MSK", "SOCHI", 300, 8, 11);
        Ticket Ticket3 = new Ticket("MSK", "SPB", 150, 10, 17);
        Ticket Ticket4 = new Ticket("KZN", "MSK", 150, 17, 19);
        Ticket Ticket5 = new Ticket("MSK", "SPB", 350, 5, 9);
        Ticket Ticket6 = new Ticket("MSK", "SPB", 250, 18, 23);
        Ticket Ticket7 = new Ticket("KZN", "SOCHI", 400, 10, 15);
        Ticket Ticket8 = new Ticket("NN", "SPB", 150, 11, 13);
        manager.add(Ticket1);
        manager.add(Ticket2);
        manager.add(Ticket3);
        manager.add(Ticket4);
        manager.add(Ticket5);
        manager.add(Ticket6);
        manager.add(Ticket7);
        manager.add(Ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("NN", "SPB", comparator);
        Ticket[] expected = {Ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }
}

