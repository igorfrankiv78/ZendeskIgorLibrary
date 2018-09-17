package zendeskigorlibrary.ie.app.builder;

/*** Created by igorfrankiv on 27/02/2018.*/
import dagger.Module;
import dagger.Provides;
import com.twistedequations.mvl.rx.AndroidRxSchedulers;

@Module
public class RxModule {

    @IAppScope
    @Provides
    public AndroidRxSchedulers rxSchedulers() {
        return new MyAndroidRxSchedulers();
    }

}