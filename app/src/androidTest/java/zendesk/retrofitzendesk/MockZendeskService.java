package zendesk.retrofitzendesk;

import java.net.URLConnection;
import java.util.List;
import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;
import zendesk.model.TicketsResultsTest;
import zendesk.util.NetworkUtil;
import zendeskigorlibrary.ie.constants.UserParam;
import zendeskigorlibrary.ie.model.Tickets;
import zendeskigorlibrary.ie.model.TicketsResults;
import zendeskigorlibrary.ie.zendesk.ZendeskService;

public class MockZendeskService implements ZendeskService
{
    private final BehaviorDelegate<ZendeskService> delegate;

    public MockZendeskService(BehaviorDelegate<ZendeskService> service) {
    this.delegate = service;
}

    @Override
    public Call<TicketsResults> getTickets(String url) {
//        TicketsResults lTicketsResults = new TicketsResults( networkTest() );
        TicketsResults lTicketsResults = new TicketsResults( new TicketsResultsTest().getTickets() );
        return delegate.returningResponse(lTicketsResults).getTickets( UserParam.URL );
    }

    public List<Tickets> networkTest() {
        URLConnection urlConnection = NetworkUtil.sendGetRequest( UserParam.URL, NetworkUtil.getAuthStr(UserParam.USERNAME, UserParam.PASSWORD) );

        String jsonData = NetworkUtil.readMultipleLinesRespone( urlConnection );

        return NetworkUtil.readJSONFile( jsonData );
    }

}
