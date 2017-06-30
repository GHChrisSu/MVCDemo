package com.baize.markettest.view;


import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baize.markettest.R;
import com.baize.markettest.model.AppDataEntity;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;


/**
 * Created by lxb on 2017/2/8.
 */

public class AppItemView extends ViewHolder<AppDataEntity> {
    /**
     * 新版本本地文件路径
     */
    public static String APKPATH = Environment.getExternalStorageDirectory() + "/lxb/智视.apk";

    public LinearLayout mFrame;
    public TextView mName;
    private TextView mAddress;
    private TextView mDownLoad;
    private ProgressBar progressBar;
    private AppDataEntity appDataEntity;
    private String url;

    public static final String APKURL = "http://resource.espacetime.com/appupdate/app-release.apk";


    private Context mContext;


    public AppItemView(Context context, ViewGroup parent) {
        super(context, parent, R.layout.layout_blue_item);
        mContext = context;

    }

    @Override
    public void setData(AppDataEntity data) {
        if (appDataEntity != data) {
            appDataEntity = data;
            url = appDataEntity.getUrl();
            //mDownLoad.setText(url);


        }
    }

    @Override
    public void findView(View itemView) {
        progressBar = (ProgressBar) itemView.findViewById(R.id.task_pb);
        progressBar.setMax(100);
        mDownLoad = (TextView) itemView.findViewById(R.id.txt_download);
        mDownLoad.setOnClickListener(new EventClick(url));
    }

    private class EventClick implements View.OnClickListener {

        private String url;

        public EventClick(String url) {
            this.url = url;
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.txt_download:
                    startDownLoad(APKURL);
                    break;
            }
        }

    }


    private void startDownLoad(String url) {

        FileDownloader.getImpl().create(url)
                .setPath(APKPATH)
                .setListener(mFileDownloadListener).start();



    }

    private FileDownloadListener mFileDownloadListener = new FileDownloadListener() {

        @Override
        protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        }

        @Override
        protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
        }

        @Override
        protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {

            final float percent = soFarBytes / (float) totalBytes;

            progressBar.setProgress((int) (percent * 100));
        }

        @Override
        protected void blockComplete(BaseDownloadTask task) {
        }

        @Override
        protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
        }

        @Override
        protected void completed(BaseDownloadTask task) {
        }

        @Override
        protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        }

        @Override
        protected void error(BaseDownloadTask task, Throwable e) {
        }

        @Override
        protected void warn(BaseDownloadTask task) {
        }
    };



}
