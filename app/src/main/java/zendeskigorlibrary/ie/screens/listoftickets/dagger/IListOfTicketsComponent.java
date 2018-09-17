package zendeskigorlibrary.ie.screens.listoftickets.dagger;

import dagger.Component;
import zendeskigorlibrary.ie.app.builder.IRxMvpAppComponent;
import zendeskigorlibrary.ie.screens.listoftickets.ListOfTickets;

/*** Created by igorfrankiv on 26/04/2018.*/
@IListOfTicketsScope
@Component(modules = ListOfTicketsModule.class, dependencies = IRxMvpAppComponent.class)
public interface IListOfTicketsComponent {

    void inject(ListOfTickets listOfTickets);

}
