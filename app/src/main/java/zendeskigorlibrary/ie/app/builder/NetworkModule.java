package zendeskigorlibrary.ie.app.builder;

import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import zendeskigorlibrary.ie.app.builder.helpers.AuthenticationInterceptor;
import zendeskigorlibrary.ie.constants.UserParam;

/*** Created by igorfrankiv on 27/04/2018.*/

@Module
public class NetworkModule {
    @IAppScope
    @Provides
    @Named("ZendeskServiceNew")
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor( Credentials.basic(UserParam.USERNAME,  UserParam.PASSWORD) );
    }

    @IAppScope
    @Provides
    @Named("ZendeskServiceNew")
    public OkHttpClient okHttpClient(@Named("ZendeskServiceNew") AuthenticationInterceptor authenticationInterceptor) {
        return new OkHttpClient.Builder().addNetworkInterceptor( authenticationInterceptor ).build() ;
    }
}
