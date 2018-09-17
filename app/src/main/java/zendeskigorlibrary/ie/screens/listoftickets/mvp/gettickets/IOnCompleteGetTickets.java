package zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets;

import android.support.annotation.NonNull;

import zendeskigorlibrary.ie.model.TicketsResults;

/*** Created by igorfrankiv on 01/05/2018. ***/

public interface IOnCompleteGetTickets {
    void onErrorGettingTickets(@NonNull String reason);
    void onGettingTickets(@NonNull TicketsResults ticketsResults);
}
