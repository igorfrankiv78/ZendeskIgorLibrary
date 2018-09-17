package zendeskigorlibrary.ie.model;

import android.support.annotation.NonNull;

import java.util.List;

/*** Created by igor on 03/06/2017. */
public final class TicketsResults {

    private final List<Tickets> tickets;

    public TicketsResults (@NonNull List<Tickets> tickets)
    {
       this.tickets = tickets;
    }

    public List<Tickets> getResults() {
        return tickets;
    }
}
