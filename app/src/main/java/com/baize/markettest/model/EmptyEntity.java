package com.baize.markettest.model;


import com.baize.markettest.constant.Constant;

/**
 * 空数据类型
 * Created by lxb on 2017/2/8.
 */
public class EmptyEntity extends BaseData {

    private String tips;

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Override
    public int getItemType() {
        return Constant.EMPTY_TIPS;
    }
}
