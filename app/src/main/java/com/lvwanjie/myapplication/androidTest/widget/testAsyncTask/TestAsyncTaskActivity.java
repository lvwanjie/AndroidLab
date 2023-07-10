package com.lvwanjie.myapplication.androidTest.widget.testAsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.javaTest.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestAsyncTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_task);
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