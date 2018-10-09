package zendeskigorlibrary.ie.screens.listoftickets.mvp;

import rx.Observable;
import zendeskigorlibrary.ie.constants.UserParam;
import zendeskigorlibrary.ie.helpers.CallbackWrapper;
import zendeskigorlibrary.ie.helpers.MyObservable;
import zendeskigorlibrary.ie.model.TicketsResults;
import zendeskigorlibrary.ie.zendesk.ZendeskService;
/*** Created by igor on 03/06/2017.*/

public class ListModel implements IListModel {

    public static final String ERROR_MESSAGE = "No Data!";
    private ZendeskService mZendeskService;
    private MyObservable<TicketsResults> mMyObservable;

    public ListModel(ZendeskService zendeskService, MyObservable myObservable){
        mZendeskService = zendeskService;
        this.mMyObservable = myObservable;
    }

    public Observable<TicketsResults> getAllTheTickets() {

        this.mZendeskService.getTickets( UserParam.URL ).enqueue(new CallbackWrapper<TicketsResults>((throwable, response) -> {
            if (response.isSuccessful())
                mMyObservable.add( response.body() );
            else // response.errorBody(); // ListModelKotlin.ERROR_MESSAGE
                mMyObservable.add( null );

            mMyObservable.add( null ); // throwable.getMessage()
        }));

        return mMyObservable.getObservable();
    }
}