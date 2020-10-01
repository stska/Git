package com.geekbrains.githubclient.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geekbrains.githubclient.R;
import com.geekbrains.githubclient.mvp.presenter.list.IUserListPresenter;
import com.geekbrains.githubclient.mvp.view.UserItemView;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.ViewHolder> {
    private IUserListPresenter mPresenter;

    public UserRVAdapter(IUserListPresenter presenter) {
        mPresenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userView = inflater.inflate(R.layout.item_user, parent, false);

        ViewHolder viewHolder = new ViewHolder(userView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.position = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onItemClick(holder);
            }
        });

        mPresenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements UserItemView {
        TextView textView;
        int position;
        String login;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.tv_login);
        }

        @Override
        public void setLogin(String text) {
            login = text;
            textView.setText(login);
        }

        @Override
        public int getPos() {
            return position;
        }

        @Override
        public String getLoginName() {
            return login;
        }
    }

}
