package com.baize.markettest.control;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import com.baize.markettest.constant.Constant;
import com.baize.markettest.model.BaseData;
import com.baize.markettest.view.EmptyView;
import com.baize.markettest.view.ViewHolder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lxb on 2017/2/8.
 */
public class RecyclerViewBaseAdapter extends RecyclerView.Adapter<ViewHolder> {


    protected Context context;
    private List<BaseData> dataList;

    public RecyclerViewBaseAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<? extends BaseData> append) {
        getDataList().addAll(append);
    }

    public void appendData(List<? extends BaseData> append){
       getDataList().addAll(union(getDataList(),append));
    }

    public void appendData(BaseData BaseData){
        getDataList().add(BaseData);
    }

    /**
     * 获取列表并集
     *
     * @param list1
     * @param list2
     * @return
     */
    private List<BaseData> union(List<? extends BaseData> list1,List<? extends BaseData> list2){
        Set<BaseData> mTmp = new HashSet<>();
        mTmp.addAll(list1);
        mTmp.addAll(list2);

        List<BaseData> newList = new ArrayList<>();
        newList.addAll(mTmp);
        return newList;
    }

    public void addData(BaseData vhModel) {
        List<BaseData> list = new ArrayList<>();
        list.add(vhModel);
        addData(list);
    }

    public void clean() {
        getDataList().clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == Constant.EMPTY_TIPS) {

            return new EmptyView(context, parent);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(getDataList().get(position));
    }

    @Override
    public int getItemCount() {
        return getDataList().size();
    }

    /**
     * 获取视图类型，从数据中获取
     * 即从数据中设定一个类型用来区分不同的视图
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return getDataList().get(position).getItemType();
    }

    public List<BaseData> getDataList() {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        return dataList;
    }

}
