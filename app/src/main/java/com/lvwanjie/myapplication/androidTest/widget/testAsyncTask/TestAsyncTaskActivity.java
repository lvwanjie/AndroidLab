package com.lvwanjie.myapplication.androidTest.widget.testAsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.javaTest.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestAsyncTaskActivity extends AppCompatActivity {

    static final String TAG= "TestAsyncTaskActivity.j";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_task);
    }

    public void btClick(View view){
        test();
    }


    public void test(){
        for (int i = 0;i<30;i++){
            useAsyncTask(i);
        }
    }

    public void useAsyncTask(int i){
        AsyncTask<String,Integer,String> asyncTask = new AsyncTask<String, Integer, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Log.i(TAG, "taskIndex = "+i+"===="+"onPreExecute: ");
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                Log.i(TAG, "taskIndex = "+i+"===="+"onProgressUpdate: "+Arrays.toString(values));
            }

            @Override
            protected String doInBackground(String... strings) {
                Log.i(TAG, "taskIndex = "+i+"===="+"doInBackground: "+ Arrays.toString(strings)+Thread.currentThread().getName());
                try {
                    publishProgress(0);
                    Thread.sleep(500);
                    publishProgress(30);
                    Thread.sleep(500);
                    publishProgress(60);
                    Thread.sleep(500);
                    publishProgress(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "done";
            }

            @Override
            protected void onPostExecute(String s) {
                Log.i(TAG, "taskIndex = "+i+"===="+"onPostExecute: "+s);
                super.onPostExecute(s);
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"p1","p2");
    }


    public void a(){
      MyAsyncTask myAsyncTask =  new MyAsyncTask ();
      myAsyncTask.execute("");
      myAsyncTask.execute();
      myAsyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);;
      myAsyncTask.cancel(true);
      myAsyncTask.execute(new Runnable() {
          @Override
          public void run() {

          }
      });
    }

    public interface I {
        int a = 0;
        void i();
    }
    public abstract class Test implements I {

        public abstract void i();

        private void a(){
            Vector vector;
            ArrayList arrayList;
            LinkedList list;


           new  BufferedReader(new InputStreamReader(new InputStream() {
               @Override
               public int read() throws IOException {
                   return 0;
               }
           }),4);

        }
    }


}