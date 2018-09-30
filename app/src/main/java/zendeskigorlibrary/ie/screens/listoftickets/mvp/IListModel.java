package zendeskigorlibrary.ie.screens.listoftickets.mvp;

import retrofit2.Call;
import rx.Observable;
import zendeskigorlibrary.ie.model.Tickets;
import zendeskigorlibrary.ie.model.TicketsResults;

/*** Created by igor on 03/06/2017.*/
public interface IListModel {
     Observable<TicketsResults> getAllTheTickets();
}
