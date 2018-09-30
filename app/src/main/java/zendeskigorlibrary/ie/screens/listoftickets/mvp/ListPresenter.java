package zendeskigorlibrary.ie.screens.listoftickets.mvp;

import rx.Observable;
import rx.Subscription;
import javax.inject.Inject;
import rx.subscriptions.CompositeSubscription;
import com.twistedequations.mvl.rx.AndroidRxSchedulers;
/*** Created by igor on 03/06/2017. ***/

public class ListPresenter
{
    private IListView mIListView;
    private ListModel mListModel;
    private AndroidRxSchedulers schedulers;
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Inject
    public ListPresenter(IListView iListView, ListModel listModel, AndroidRxSchedulers schedulers )
    {
        this.mIListView = iListView;
        this.mListModel = listModel;
        this.schedulers = schedulers;
    }

    public void onCreate() {
        compositeSubscription.add(getAllTickets());
    }

    public void unsubscribe(){
        compositeSubscription.unsubscribe();
    }

    private Subscription getAllTickets(){
        return Observable.just(null) //inital load
                .flatMap(aVoid -> mListModel.getAllTheTickets()) //get the tickets data from API Server
                .doOnError(throwable -> {
                    throwable.printStackTrace(); //Log errors
                    mIListView.errorInGettingTickets(ListModel.ERROR_MESSAGE); // show error dialog on error
                })
                .subscribeOn(schedulers.network())
                .observeOn(schedulers.mainThread())
                .subscribe(this.mIListView::successInGettingTickets); // display data
    }
}


