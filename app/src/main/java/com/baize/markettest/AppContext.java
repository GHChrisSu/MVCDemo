package com.baize.markettest;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by lxb on 2017/6/8.
 */

public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.init(this);
    }
}
