package customerSupport.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TicketList implements Iterable<Ticket> {
    private List<Ticket> tickets;

    public TicketList() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket getTicket(int index) {
        return tickets.get(index);
    }

    @Override
    public Iterator<Ticket> iterator() {
        return tickets.iterator();
    }

    public void sortTickets() {
        tickets.sort(new TicketComparator());
    }
}
