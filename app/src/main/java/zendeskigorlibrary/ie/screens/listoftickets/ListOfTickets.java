package zendeskigorlibrary.ie.screens.listoftickets;
/*** Created by igor on 04/06/2017. ***/

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import zendeskigorlibrary.ie.R;
import zendeskigorlibrary.ie.app.RxMvpApp;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import zendeskigorlibrary.ie.model.TicketsResults;
import zendeskigorlibrary.ie.screens.listoftickets.dagger.DaggerIListOfTicketsComponent;
import zendeskigorlibrary.ie.screens.listoftickets.dagger.ListOfTicketsModule;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.IListView;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListPresenter;
import zendeskigorlibrary.ie.screens.listoftickets.viewadapt.ZendeskListViewAdapter;

public class ListOfTickets extends Activity implements IListView {

    @Inject
    ListPresenter mListPresenter;
    private RecyclerView mRecyclerViewVirtical;
    private ZendeskListViewAdapter mZendeskListViewAdapter;

    @BindView(R.id.errorText)
    TextView errorText;

    private final String errorStr = "Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_testr);
        ButterKnife.bind(this);

        DaggerIListOfTicketsComponent.builder()
                .iRxMvpAppComponent(RxMvpApp.get(this).component())
                .listOfTicketsModule(new ListOfTicketsModule(this))
                .build().inject(this);
        mListPresenter.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mListPresenter.unsubscribe();
    }

    @Override
    public void successInGettingTickets(TicketsResults ticketsResults) {

        if( ticketsResults != null ){
            errorText.setVisibility(View.GONE);
            mZendeskListViewAdapter = new ZendeskListViewAdapter(ticketsResults, this);
            mRecyclerViewVirtical = (RecyclerView) findViewById(R.id.recycler_view);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            mRecyclerViewVirtical.setLayoutManager(layoutManager);
            mRecyclerViewVirtical.setAdapter(mZendeskListViewAdapter);
        }
        else {
            errorText.setText(errorStr);
            errorText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void errorInGettingTickets(String reason) {
        errorText.setVisibility(View.VISIBLE);
        errorText.setText(reason);
        Toast.makeText(getApplicationContext(), reason, Toast.LENGTH_LONG).show();
    }
}