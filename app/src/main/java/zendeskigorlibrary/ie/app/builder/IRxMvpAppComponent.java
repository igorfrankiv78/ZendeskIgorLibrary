package zendeskigorlibrary.ie.app.builder;

/*** Created by igorfrankiv on 26/02/2018.*/
import dagger.Component;
import android.content.Context;
import com.twistedequations.mvl.rx.AndroidRxSchedulers;
import zendeskigorlibrary.ie.helpers.MyObservable;
import zendeskigorlibrary.ie.zendesk.ZendeskService;

@IAppScope
@Component(modules = {  RxMvpAppModule.class,
                        NetworkModule.class,
                        RestServiceModule.class,
                        RxModule.class,
                        MyObservableModule.class})
public interface IRxMvpAppComponent {

    Context context();
    AndroidRxSchedulers rxSchedulers();
    ZendeskService zendeskService();
    MyObservable myObservable();
}
