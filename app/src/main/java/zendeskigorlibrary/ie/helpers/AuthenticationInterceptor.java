package zendeskigorlibrary.ie.helpers;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/*** Created by igor on 03/06/2017. ***/

public class AuthenticationInterceptor implements Interceptor {

    private String authToken;

    public AuthenticationInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(
                chain.request().
                newBuilder().
                header("Authorization", authToken).
                build());
    }
}