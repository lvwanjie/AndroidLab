package com.lvwanjie.myapplication.androidTest.widget.testMemoryFile;

import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;

import java.io.IOException;

class TestMemoryFile {


    public void test(){
        MemoryFile file;
        try {
            ParcelFileDescriptor.dup(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
