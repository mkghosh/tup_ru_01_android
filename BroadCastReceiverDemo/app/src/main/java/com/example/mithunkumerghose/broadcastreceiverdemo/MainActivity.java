package com.example.mithunkumerghose.broadcastreceiverdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnIntentFire, btnStartService, btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
        setClickListener();
    }

    private void initButtons() {
        btnIntentFire = (Button) findViewById(R.id.btn_intent_fire);
        btnStartService = (Button) findViewById(R.id.startServiceButton);
        btnStopService = (Button) findViewById(R.id.stopServiceButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_intent_fire:
                Intent intent = new Intent();
                intent.setAction("com.mithun.MY_RECEIVER");
                sendBroadcast(intent);
                break;
            case R.id.startServiceButton:
                Toast.makeText(this, "Start Service Clicked", Toast.LENGTH_SHORT).show();
                startService(new Intent(this,MyService.class));
                break;
            case R.id.stopServiceButton:
                stopService(new Intent(this, MyService.class));
                break;
        }
    }

    public void setClickListener() {
        btnStartService.setOnClickListener(this);
        btnIntentFire.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
    }
}
