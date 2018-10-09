package zendeskigorlibrary.ie.app.builder;

import dagger.Module;
import dagger.Provides;
import zendeskigorlibrary.ie.helpers.MyObservable;
/*** Created by igorfrankiv on 09/05/2018.*/
@Module
public class MyObservableModule {

    @IAppScope
    @Provides
    public MyObservable myObservable() {
        return new MyObservable<>();
    }
}
