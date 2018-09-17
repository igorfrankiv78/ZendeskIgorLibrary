package zendeskigorlibrary.ie.app.builder;

import dagger.Module;
import dagger.Provides;
import zendeskigorlibrary.ie.screens.listoftickets.mvp.gettickets.ZendeskServiceImp;
import zendeskigorlibrary.ie.zendesk.ZendeskService;

/*** Created by igorfrankiv on 03/05/2018.*/

@Module
public class ZendeskServiceHelperModule {
    @IAppScope
    @Provides
    public ZendeskServiceImp dbHelper(ZendeskService zendeskService ) {
        return new ZendeskServiceImp(  zendeskService );
    }
}
