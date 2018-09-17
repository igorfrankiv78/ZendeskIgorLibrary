package zendeskigorlibrary.ie.screens.listoftickets.mvp;

import android.support.annotation.NonNull;
import rx.Observable;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets.IOnCompleteGetTickets;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets.ZendeskServiceImp;
import zendeskigorlibrary.ie.model.MyObservable;
import zendeskigorlibrary.ie.model.TicketsResults;

/*** Created by igor on 03/06/2017.*/

public class ListModel implements IListModel {

   public static final String ERROR_MESSAGE = "No Data!";

    private ZendeskServiceImp mZendeskServiceImp;
    private MyObservable<TicketsResults> mDeleteItemLocationsDBObs;

    public ListModel(ZendeskServiceImp zendeskServiceImp, MyObservable myObservable){
        mZendeskServiceImp = zendeskServiceImp;
        mDeleteItemLocationsDBObs = myObservable;
    }

    public Observable<TicketsResults> getAllTheTickets( ){

        mZendeskServiceImp.getAllTheTickets(new IOnCompleteGetTickets() {

            @Override
            public void onErrorGettingTickets(@NonNull String reason) {
//                mIListView.errorInGettingTickets(reason);//   throw new Exception();
                mDeleteItemLocationsDBObs.add( null );
            }

            @Override
            public void onGettingTickets(@NonNull TicketsResults ticketsResults) {
                mDeleteItemLocationsDBObs.add( ticketsResults );
            }

        });

        return mDeleteItemLocationsDBObs.getObservable();
    }
}