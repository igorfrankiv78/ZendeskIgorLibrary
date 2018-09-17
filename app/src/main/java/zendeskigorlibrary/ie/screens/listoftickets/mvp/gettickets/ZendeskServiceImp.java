package zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zendeskigorlibrary.ie.constants.UserParam;
import zendeskigorlibrary.ie.model.TicketsResults;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.ListModel;
import zendeskigorlibrary.ie.zendesk.ZendeskService;

/*** Created by igorfrankiv on 03/05/2018. ***/

public class ZendeskServiceImp {

    private ZendeskService mZendeskService;

    public ZendeskServiceImp(ZendeskService zendeskService){
        mZendeskService = zendeskService;
    }

    public void getAllTheTickets( IOnCompleteGetTickets iOnCompleteGetTickets ){
        mZendeskService.getTickets( UserParam.URL ).enqueue(new Callback<TicketsResults>() {

            @Override
            public void onResponse(Call<TicketsResults> call, Response<TicketsResults> response) {
                if (response.isSuccessful()) {
                    iOnCompleteGetTickets.onGettingTickets(response.body());
                }
                else {
                    iOnCompleteGetTickets.onErrorGettingTickets(ListModel.ERROR_MESSAGE);//response.errorBody();
                }
            }

            @Override
            public void onFailure(Call<TicketsResults> call, Throwable t) {
                    iOnCompleteGetTickets.onErrorGettingTickets(t.getMessage());
            }

        });
    }
}
