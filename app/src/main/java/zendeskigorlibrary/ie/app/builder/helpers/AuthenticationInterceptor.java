package zendeskigorlibrary.ie.app.builder.helpers;

/**
 * Created by igorfrankiv on 09/10/2018.
 */
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

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
