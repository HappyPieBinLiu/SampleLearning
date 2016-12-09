package com.happypiebinliu.samplelearning.Event;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends AppCompatActivity {
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        show = (TextView) findViewById(R.id.show);
    }
    public void download(View view) throws MalformedURLException {
        DownTask task = new DownTask(this);
        task.execute(new URL("http://http://www.crazyit.org/ethos.php"));
    }
    class DownTask extends AsyncTask<URL, Integer, String>{

        ProgressDialog progressDialog;
        int hasRead = 0;
        Context mContext;
        public DownTask(Context ctn){
            mContext = ctn;
        }

        /**
         * 完成实际的下载任务
         * 一般用来背重写
         * @param params
         * @return
         */
        @Override
        protected String doInBackground(URL... params) {

            StringBuilder sb = new StringBuilder();
            try {
                URLConnection connection = params[0].openConnection();
                // 把connection的输入流，包装成BufferReader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = bufferedReader.readLine() )!= null){
                    sb.append(line + "\n");
                    hasRead++;
                    publishProgress(hasRead);
                }
                return sb.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            // 返回页面内容
            show.setText(s);
            progressDialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(mContext);
            progressDialog.setTitle("下载任务");
            progressDialog.setMessage("下载任务正在执行〉〉〉〉〉〉〉〉〉〉");
            progressDialog.setCancelable(false);
            progressDialog.setMax(202);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            show.setText("已经读取了[" + values[0] + "]行" );
            progressDialog.setProgress(values[0]);
        }
    }
}
