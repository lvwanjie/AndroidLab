package com.lvwanjie.myapplication.androidTest.widget.testAsyncTask;

import android.os.AsyncTask;

class MyAsyncTask<T,E,A> extends AsyncTask<T,E,A> {


    @Override
    protected A doInBackground(T... ts) {
        return null;
    }

    @Override
    protected void onProgressUpdate(E... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(A a) {
        super.onPostExecute(a);
    }
}
