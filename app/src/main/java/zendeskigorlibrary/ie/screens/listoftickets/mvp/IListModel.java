package zendeskigorlibrary.ie.screens.listoftickets.mvp;

import rx.Observable;
import zendeskigorlibrary.ie.model.TicketsResults;

/*** Created by igor on 03/06/2017.*/
public interface IListModel {
     Observable<TicketsResults> getAllTheTickets();
}
