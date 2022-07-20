package com.lvwanjie.myapplication.androidTest.widget.testAsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.lvwanjie.myapplication.R;

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


}