package customerSupport;

import customerSupport.model.Ticket;
import customerSupport.model.TicketList;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TicketList ticketList = new TicketList();
        
        // Create sample tickets
        ticketList.addTicket(new Ticket(1, "John Doe", "Internet issue", new Date(), 3));
        ticketList.addTicket(new Ticket(2, "Jane Smith", "Computer won't start", new Date(), 2));
        ticketList.addTicket(new Ticket(3, "Mary Johnson", "Software installation", new Date(), 5));

        // Clone a ticket
        try {
            Ticket clonedTicket = (Ticket) ticketList.getTicket(0).clone();
            System.out.println("Cloned ticket: " + clonedTicket);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Sort tickets by priority and date
        ticketList.sortTickets();

        // Print sorted tickets
        System.out.println("Sorted tickets:");
        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }
}
