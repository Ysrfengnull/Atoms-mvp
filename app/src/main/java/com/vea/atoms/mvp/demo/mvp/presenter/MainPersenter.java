package com.vea.atoms.mvp.demo.mvp.presenter;

import com.vea.atoms.mvp.base.RxPresenter;
import com.vea.atoms.mvp.demo.mvp.contract.MainContract;
import com.vea.atoms.mvp.demo.mvp.model.entity.User;
import com.vea.atoms.mvp.demo.mvp.model.service.DemoService;
import com.vea.atoms.mvp.integration.IRepositoryManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Administrator on 2018/8/23.
 */

public class MainPersenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    private IRepositoryManager repositoryManager;

    @Inject
    public MainPersenter(IRepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
    }

    @Override
    public void getUser(int lastIdQueried, int perPage) {

        Observable.just(repositoryManager
            .obtainRetrofitService(DemoService.class)
            .getUsers(lastIdQueried, 10))
            .flatMap(new Function<Observable<List<User>>, ObservableSource<List<User>>>() {
                @Override
                public ObservableSource<List<User>> apply(Observable<List<User>> listObservable) throws Exception {
                    return listObservable;
                }
            })
            .subscribeOn(Schedulers.io())
            .doOnSubscribe(disposable -> {
                //订阅之前常用于显示loading
            }).subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally(() -> {
                // 结束之后
            })
            .subscribe(new Observer<List<User>>() {
                @Override
                public void onSubscribe(Disposable d) {
                    addSubscription(d);
                }

                @Override
                public void onNext(List<User> users) {
                    Timber.d(users.size() + "");
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });

//            .subscribeOn(Schedulers.io())
//            .doOnSubscribe(disposable -> {
//                //订阅之前常用于显示loading
//            }).subscribeOn(AndroidSchedulers.mainThread())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doFinally(() -> {
//                // 结束之后
//            });
//    }
    }
}