package zendeskigorlibrary.ie.app.builder;

import com.twistedequations.mvl.rx.AndroidRxSchedulers;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zendeskigorlibrary.ie.constants.UserParam;
import zendeskigorlibrary.ie.zendesk.ZendeskService;
/*** Created by igorfrankiv on 27/04/2018. ***/
@Module
public class RestServiceModule {

    @IAppScope
    @Provides
    public ZendeskService zendeskService(@Named("ZendeskServiceNew") OkHttpClient okHttpClient, AndroidRxSchedulers androidSchedulers) {
         return new Retrofit.Builder().
                baseUrl(  UserParam.API_BASE_URL ).
                addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(androidSchedulers.network())).
                addConverterFactory(GsonConverterFactory.create()).
                client(  okHttpClient  ).
                build().create(ZendeskService.class);
    }
}