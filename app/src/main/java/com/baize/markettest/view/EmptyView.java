package com.baize.markettest.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baize.markettest.R;
import com.baize.markettest.model.EmptyEntity;


/**
 * Created by lxb on 2017/2/8.
 */

public class EmptyView extends ViewHolder<EmptyEntity> {

    public LinearLayout mFrame;
    public TextView mTips;
    private EmptyEntity emptyEntity;



    public EmptyView(Context context, ViewGroup parent) {
        super(context, parent, R.layout.layout_blue_empty);
    }

    @Override
    public void setData(EmptyEntity data) {
        if (emptyEntity != data) {
            emptyEntity = data;
            mTips.setText(emptyEntity.getTips());


        }
    }

    @Override
    public void findView(View itemView) {


    }
}