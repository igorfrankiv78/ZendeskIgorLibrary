package zendesk.helpers;

import android.support.annotation.NonNull;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.inject.Inject;

import zendesk.dagger2.DaggerITestListOfTicketsComponent;
import zendesk.dagger2.TestListOfTicketsModule;
import zendesk.model.TicketsResultsTest;
import zendeskigorlibrary.ie.app.RxMvpApp;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets.ZendeskServiceImp;
import zendeskigorlibrary.ie.model.MyObservable;
import zendeskigorlibrary.ie.model.TicketsResults;
import zendeskigorlibrary.ie.screens.listoftickets.ListOfTickets;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.IListView;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets.IOnCompleteGetTickets;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListPresenter;

/*** Created by igorfrankiv on 09/05/2018. */
@RunWith(AndroidJUnit4.class)
public class ZendeskServiceImpTest {

    @Inject
    ListPresenter mListPresenter;

    @Inject
    ZendeskServiceImp mZendeskServiceImp;

    @Inject
    MyObservable deleteItemLocationsDBObs;

    private IListView mIListView = Mockito.mock(IListView.class);

    private TicketsResultsTest mTicketsResultsTest;

    @Rule
    public ActivityTestRule<ListOfTickets> activityTestRule =  new ActivityTestRule<>(ListOfTickets.class);

    @Before
    public void setUp() {

        mTicketsResultsTest = new TicketsResultsTest();

        DaggerITestListOfTicketsComponent.builder()
                .iRxMvpAppComponent(RxMvpApp.get(activityTestRule.getActivity()).component())
                .listOfTicketsModule(new TestListOfTicketsModule(mIListView) )
                .build().inject(this);
    }

    @Test
    public void testZendeskServiceHelperSuccess() {

        mZendeskServiceImp.getAllTheTickets(new IOnCompleteGetTickets() {

            @Override
            public void onErrorGettingTickets(@NonNull String reason) {
            }

            @Override
            public void onGettingTickets(@NonNull TicketsResults ticketsResults) {
                deleteItemLocationsDBObs.add(ticketsResults);

                Assert.assertEquals("This is a test ticket", ticketsResults.getResults().get(0).getDescription());

                Assert.assertEquals(45, ticketsResults.getResults().size() );
            }
        });
    }
}
