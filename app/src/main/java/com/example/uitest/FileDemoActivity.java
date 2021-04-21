package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.File;

public class FileDemoActivity extends AppCompatActivity {
    private StringBuilder stringBuilder;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_demo);
        textView = findViewById(R.id.tv_content);
        readFileDirectory();
    }

    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }


    private void readFileDirectory() {
        stringBuilder = new StringBuilder();
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            File file1 = Environment.getExternalStorageDirectory();
            if (file1 != null) {
                stringBuilder.append("Environment.getExternalStorageDirectory():");
                stringBuilder.append(getFileContent(file1));
            }
        }
        File rootFile = Environment.getRootDirectory();
        if (rootFile != null) {
            stringBuilder.append("\n");
            stringBuilder.append("Environment.getRootDirectory():");
            stringBuilder.append(getFileContent(rootFile));
        }

        File dataFile = Environment.getDataDirectory();
        if (dataFile != null) {
            stringBuilder.append("\n");
            stringBuilder.append("Environment.getDataDirectory():");
            stringBuilder.append(getFileContent(dataFile));
        }

        File downloadCacheFile = Environment.getDownloadCacheDirectory();
        if (downloadCacheFile != null) {
            stringBuilder.append("\n");
            stringBuilder.append("Environment.getDownloadCacheDirectory():");
            stringBuilder.append(getFileContent(downloadCacheFile));
        }

        File storageDirectory = Environment.getStorageDirectory();
        if (storageDirectory != null) {
            stringBuilder.append("\n");
            stringBuilder.append("Environment.getStorageDirectory():");
            stringBuilder.append(getFileContent(storageDirectory));
        }

        textView.setText(stringBuilder.toString());
    }

    private String getFileContent(File file) {
        if (file == null) return "\r\rnull";
        if (file.isFile()) {
            return "\r\r" + file.getAbsolutePath();
        }
        if (file.isDirectory()) {
            String[] files = file.list();
            if (files ==null || files.length==0){
                return "\r\rfiles ==null || files.length==0";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String a : files) {
                stringBuilder.append("\r\r").append(a).append("\n");
            }
            return stringBuilder.toString();
        }

        return "not file && not direct";

    }
}