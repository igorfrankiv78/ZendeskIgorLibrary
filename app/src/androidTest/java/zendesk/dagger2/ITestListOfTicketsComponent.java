package zendesk.dagger2;

import dagger.Component;
import zendeskigorlibrary.ie.app.builder.IRxMvpAppComponent;
import zendeskigorlibrary.ie.screens.listoftickets.dagger.IListOfTicketsScope;
import zendeskigorlibrary.ie.screens.listoftickets.dagger.ListOfTicketsModule;

/*** Created by igorfrankiv on 03/05/2018.*/
@IListOfTicketsScope
@Component(modules = ListOfTicketsModule.class, dependencies = IRxMvpAppComponent.class)
public interface ITestListOfTicketsComponent {
    void inject(ListOfTicketsTest listOfTicketsTest);
}
