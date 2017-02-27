package com.example.mithunkumerghose.sdcarddemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG TAG";
    private EditText etFileName, etText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button Clicked");
                String fileName = etFileName.getText().toString();

                File textFile = fileName.isEmpty() ? createFile("myFile.txt") : createFile(fileName);
                Log.d(TAG, textFile.getAbsolutePath());
                try (FileOutputStream fos = new FileOutputStream(textFile);
                     OutputStreamWriter writer = new OutputStreamWriter(fos)) {
                    writer.write(etText.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
        }
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }

    private File createFile(String fileName) {

        File defaultDir = null;
        if (isStoragePermissionGranted()) {
            defaultDir = Environment.getExternalStorageDirectory();
            Log.d(TAG, defaultDir.getAbsolutePath());
        } else
            Log.d(TAG, "Permission is not granted");
        assert defaultDir != null;
        return new File(defaultDir.getAbsolutePath() + "/" + fileName + ".txt");
    }

    private void initViews() {
        etFileName = (EditText) findViewById(R.id.file_name);
        etText = (EditText) findViewById(R.id.text_to_save);

        saveButton = (Button) findViewById(R.id.save_text);
    }
}
