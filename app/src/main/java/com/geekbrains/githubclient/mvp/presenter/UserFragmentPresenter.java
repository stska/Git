package com.geekbrains.githubclient.mvp.presenter;

import com.geekbrains.githubclient.GithubApplication;
import com.geekbrains.githubclient.mvp.view.ISetLogNameForUserProf;
import com.geekbrains.githubclient.mvp.view.UserProfileView;
import com.geekbrains.githubclient.ui.BackButtonListener;
import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

//public class UserFragmentPresenter extends MvpPresenter<UserProfileView> implements BackButtonListener{
public class UserFragmentPresenter extends MvpPresenter<ISetLogNameForUserProf> implements BackButtonListener{
    private Router mRouter;
    private String logName;
    private final String GREETING = "Hello, user: ";

    public UserFragmentPresenter(String logName) {
        mRouter = GithubApplication.INSTANCE.getRouter();
        this.logName = logName;
        getViewState().setLogUserLogName(GREETING.concat(logName));
    }
    public boolean backPressed() {
        mRouter.exit();
        return true;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

}
