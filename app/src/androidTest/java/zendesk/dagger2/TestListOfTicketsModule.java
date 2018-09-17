package zendesk.dagger2;

import com.twistedequations.mvl.rx.AndroidRxSchedulers;

import org.mockito.Mockito;

import zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets.ZendeskServiceImp;
import zendeskigorlibrary.ie.model.MyObservable;
import zendeskigorlibrary.ie.screens.listoftickets.dagger.ListOfTicketsModule;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.IListView;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListModel;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListPresenter;

/*** Created by igorfrankiv on 03/05/2018. */

public class TestListOfTicketsModule extends ListOfTicketsModule {

    IListView mView;

    public TestListOfTicketsModule( IListView view ) {
        super(view);
        mView = view;
    }

    @Override
    public IListView iListView() {
        return mView;
    }

    @Override
    public ListPresenter homePresenter(IListView iListView, ListModel listModel, AndroidRxSchedulers schedulers){
        return Mockito.mock( ListPresenter.class );
    }

    @Override
    public ListModel listModel(ZendeskServiceImp zendeskServiceImp, MyObservable myObservable) {
        return Mockito.mock( ListModel.class  );
    }

}
