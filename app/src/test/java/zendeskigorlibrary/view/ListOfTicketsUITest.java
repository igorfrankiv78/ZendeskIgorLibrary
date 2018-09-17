package zendeskigorlibrary.view;

import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import zendeskigorlibrary.ie.BuildConfig;
import zendeskigorlibrary.ie.R;
import zendeskigorlibrary.ie.screens.listoftickets.ListOfTickets;
import zendeskigorlibrary.ie.screens.listoftickets.viewadapt.ZendeskListViewAdapter;
import zendeskigorlibrary.model.TicketsResultsTest;

import static org.robolectric.Shadows.shadowOf;

/*** Created by igorfrankiv on 04/05/2018.*/

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ListOfTicketsUITest {

    private TicketsResultsTest mTicketsResultsTest;
    ShadowActivity myActivityShadow;
    RecyclerView currentRecyclerView;
    ActivityController<ListOfTickets> activityController;
    private ZendeskListViewAdapter mZendeskListViewAdapter;


    @Before
    public void setUp() throws Exception {
        mTicketsResultsTest = new TicketsResultsTest();
        activityController = Robolectric.buildActivity( ListOfTickets.class);
        activityController.create().start().visible();

        myActivityShadow = shadowOf(activityController.get());

        mZendeskListViewAdapter = new ZendeskListViewAdapter(mTicketsResultsTest.getTicketsResults(), RuntimeEnvironment.application);

        currentRecyclerView = ((RecyclerView) myActivityShadow.findViewById(R.id.recycler_view));
        currentRecyclerView.setAdapter(mZendeskListViewAdapter);
    }

    @Test
    public void test()throws Exception{

    }
}


