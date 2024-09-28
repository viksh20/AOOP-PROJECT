package customerSupport.model;

import java.util.Date;

public class Ticket implements Comparable<Ticket>, Cloneable {
    private int id;
    private String customerName;
    private String issue;
    private Date date;
    private int priority;

    public Ticket(int id, String customerName, String issue, Date date, int priority) {
        this.id = id;
        this.customerName = customerName;
        this.issue = issue;
        this.date = date;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getIssue() {
        return issue;
    }

    public Date getDate() {
        return date;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Ticket other) {
        // Compare by priority, then by date if priority is the same
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority); // Higher priority first
        }
        return this.date.compareTo(other.date); // Older tickets first
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Ticket [ID: " + id + ", Customer: " + customerName + ", Issue: " + issue +
               ", Date: " + date + ", Priority: " + priority + "]";
    }
}
