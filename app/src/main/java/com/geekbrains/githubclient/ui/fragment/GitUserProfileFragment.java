package com.geekbrains.githubclient.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.geekbrains.githubclient.R;
import com.geekbrains.githubclient.mvp.presenter.UserFragmentPresenter;
import com.geekbrains.githubclient.mvp.presenter.UsersPresenter;
import com.geekbrains.githubclient.mvp.view.ISetLogNameForUserProf;
import com.geekbrains.githubclient.mvp.view.UserProfileView;
import com.geekbrains.githubclient.ui.BackButtonListener;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class GitUserProfileFragment extends MvpAppCompatFragment implements UserProfileView, BackButtonListener, ISetLogNameForUserProf {
    private static final String LOG_NAME = "log_name";
    private View view;
    private TextView userGreeting;

    @InjectPresenter
    UserFragmentPresenter mPresenter;

    @ProvidePresenter
    UserFragmentPresenter provideForwardPresenter(){
        return new UserFragmentPresenter(getArguments().getString(LOG_NAME));
    }

    public static GitUserProfileFragment getNewInstance(String logName){
        GitUserProfileFragment fragment = new GitUserProfileFragment();
        Bundle arguments = new Bundle();
        arguments.putString(LOG_NAME,logName);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_fragment_layout, container, false);
        userGreeting = view.findViewById(R.id.gitUser);

        return view;
    }

    @Override
    public boolean backPressed() {
        return mPresenter.backPressed();
    }

    @Override
    public void loadProfile() {
      //TODO future profile data, probably :D
}

    @Override
    public void setLogUserLogName(String userLogName) {
        userGreeting.setText(userLogName);
    }
}
