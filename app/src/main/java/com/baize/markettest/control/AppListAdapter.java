package com.baize.markettest.control;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import com.baize.markettest.view.ViewHolder;
import com.baize.markettest.constant.Constant;
import com.baize.markettest.view.AppItemView;
import com.baize.markettest.view.EmptyView;

import java.util.Iterator;
import java.util.List;

/**
 * 蓝牙适配器
 * Created by lxb on 2017/2/8.
 */
public class AppListAdapter extends RecyclerViewBaseAdapter  {

    private Context mContext;

    public AppListAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if (viewType == Constant.APP_TYPE) {
            return new AppItemView(this.context, parent);
        }

        if(viewType == Constant.EMPTY_TIPS){
            return new EmptyView(this.context, parent);
        }
        return super.onCreateViewHolder(parent, viewType);
    }




}
