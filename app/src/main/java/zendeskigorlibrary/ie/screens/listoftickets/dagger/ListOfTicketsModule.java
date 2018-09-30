package zendeskigorlibrary.ie.screens.listoftickets.dagger;

import dagger.Module;
import dagger.Provides;
import zendeskigorlibrary.ie.helpers.MyObservable;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.IListView;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListModel;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListPresenter;
import zendeskigorlibrary.ie.zendesk.ZendeskService;
import com.twistedequations.mvl.rx.AndroidRxSchedulers;

/***  Created by igorfrankiv on 26/04/2018. ***/
@Module
public class ListOfTicketsModule {

    IListView mView;

    public ListOfTicketsModule( IListView view ) {
        mView = view;
    }

    @Provides
    public IListView iListView() {
        return mView;
    }

    @Provides
    @IListOfTicketsScope
    public ListPresenter homePresenter(IListView iListView, ListModel listModel, AndroidRxSchedulers schedulers){
        return new ListPresenter( iListView, listModel, schedulers );
    }

    @Provides
    @IListOfTicketsScope
    public ListModel listModel(ZendeskService zendeskService, MyObservable myObservable) {
        return new ListModel( zendeskService, myObservable );
    }
}
