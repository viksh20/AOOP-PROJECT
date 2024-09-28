package customerSupport.model;

import java.util.Comparator;

public class TicketComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        // Compare by priority, then by date
        if (t1.getPriority() != t2.getPriority()) {
            return Integer.compare(t2.getPriority(), t1.getPriority());
        }
        return t1.getDate().compareTo(t2.getDate());
    }
}
