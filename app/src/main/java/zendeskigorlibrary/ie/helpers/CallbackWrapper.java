package zendeskigorlibrary.ie.helpers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*** Created by igorfrankiv on 29/03/2018.*/

public class CallbackWrapper<T> implements Callback<T> {
    private Wrapper<T> wrapper;

    public CallbackWrapper(Wrapper<T> wrapper) {
        this.wrapper = wrapper;
    }

    public void onFailure(Call<T> call, Throwable t) {
        wrapper.onResult(t, null);
    }

    public void onResponse(Call<T> call, Response<T> response) {
        wrapper.onResult(null, response);
    }

    public static interface Wrapper<T> {
        void onResult(Throwable t, Response<T> response);
    }
}
