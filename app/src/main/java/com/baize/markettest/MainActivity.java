package com.baize.markettest;

import android.app.Application;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baize.markettest.control.AppListAdapter;
import com.baize.markettest.model.AppDataEntity;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AppListAdapter mAppListAdapter;
    public static final String APKURL = "http://dlied5.myapp.com/myapp/1104466820/sgame/2017_com.tencent.tmgp.sgame_h100_1.19.1.12.apk";
    public static String APKPATH = Environment.getExternalStorageDirectory() + "/lxb/wzry.apk";

    private Button mStart;
    private Button mPause;
    private Button mResume;
    private TextView mSpeed;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAppListAdapter = new AppListAdapter(this);

        AppDataEntity appDataEntity = new AppDataEntity();
        appDataEntity.setUrl(APKURL);
        mAppListAdapter.addData(appDataEntity);

        mRecyclerView.setAdapter(mAppListAdapter);*/

        initView();
    }

    private void initView(){

        mSpeed = (TextView)findViewById(R.id.txt_speed);
        progressBar = (ProgressBar)findViewById(R.id.task_pb);
        progressBar.setMax(100);

        mStart = (Button)findViewById(R.id.btn_start);
        mPause = (Button)findViewById(R.id.btn_pause);
        mResume = (Button)findViewById(R.id.btn_resume);

        EventClick eventClick = new EventClick();
        mStart.setOnClickListener(eventClick);
        mPause.setOnClickListener(eventClick);
        mResume.setOnClickListener(eventClick);

    }

    private class EventClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){

                case R.id.btn_start:
                    FileDownloader.getImpl().create(APKURL)
                            .setPath(APKPATH)
                            .setListener(mFileDownloadListener).start();
                    break;

                case R.id.btn_pause:
                    FileDownloader.getImpl().pause(mFileDownloadListener);
                    break;

                case R.id.btn_resume:

                    break;
            }
        }
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
            mSpeed.setText(String.format("%dKB/s", task.getSpeed()));
        }

        @Override
        protected void blockComplete(BaseDownloadTask task) {
        }

        @Override
        protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
        }

        @Override
        protected void completed(BaseDownloadTask task) {
            mSpeed.setText("下载完成");
            progressBar.setVisibility(View.GONE);
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
