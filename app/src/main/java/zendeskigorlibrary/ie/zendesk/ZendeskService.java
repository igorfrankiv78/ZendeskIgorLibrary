package zendeskigorlibrary.ie.zendesk;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import zendeskigorlibrary.ie.model.TicketsResults;
/*** Created by igorfrankiv on 27/04/2018. */

public interface ZendeskService {
    @GET
    Call<TicketsResults> getTickets(@Url String url);
}
