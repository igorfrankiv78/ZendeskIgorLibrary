package zendeskigorlibrary.mvp;

import com.twistedequations.mvl.rx.AndroidRxSchedulers;
import com.twistedequations.mvl.rx.TestAndroidRxSchedulers;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.IListView;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListModel;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListPresenter;
import zendeskigorlibrary.model.TicketsResultsTest;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/*** Created by igorfrankiv on 04/05/2018. */

public class ListPresenterTest {

    private IListView mIListView;
    private ListModel mListModel;
    private ListPresenter listPresenter;
    private TicketsResultsTest mTicketsResultsTest;
    private AndroidRxSchedulers schedulers = new TestAndroidRxSchedulers();

    @Before
    public void setUp() throws Exception {
        mListModel = mock(ListModel.class);
        mIListView = mock(IListView.class);
        listPresenter = new ListPresenter ( mIListView, mListModel, schedulers);
        mTicketsResultsTest = new TicketsResultsTest();
    }

    @Test
    public void listPresenterObservablesSubscriptionSucessTest() throws Exception {
        // ---------------------------------------------
        when( this.mListModel. getAllTheTickets() ).thenReturn( Observable.just( mTicketsResultsTest.getTicketsResults() ) );
        // ---------------------------------------------
        listPresenter.onCreate();
        // ---------------------------------------------
        verify( this.mIListView, times(1)).successInGettingTickets( mTicketsResultsTest.getTicketsResults() );
        // ---------------------------------------------
        listPresenter.unsubscribe();
        // ---------------------------------------------
    }

}
