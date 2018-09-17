package zendeskigorlibrary.ie.app.builder;

import com.twistedequations.mvl.rx.AndroidRxSchedulers;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/*** Created by igorfrankiv on 26/02/2018.*/

public class MyAndroidRxSchedulers implements AndroidRxSchedulers {

    @Override
    public Scheduler network() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler io() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler computation() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler newThread() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler immediate() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler mainThread() {
        return Schedulers.immediate();
    }
}

