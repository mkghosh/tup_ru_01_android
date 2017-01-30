package com.example.mithunkumerghose.sharedpreferencedemo.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mithunkumerghose.sharedpreferencedemo.R;
import com.example.mithunkumerghose.sharedpreferencedemo.util.MyPrefManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MyPrefManager prefManager;
    TextView prefDataView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefDataView = (TextView) findViewById(R.id.pref_data_view);
        prefManager = new MyPrefManager(this);

        Button addButton, clearButton, removeButton, addAndCreateButton, getDataButton;

        addAndCreateButton = (Button) findViewById(R.id.create_btn);
        addButton = (Button) findViewById(R.id.add_btn);
        clearButton = (Button) findViewById(R.id.clear_btn);
        removeButton = (Button) findViewById(R.id.remove_btn);
        getDataButton = (Button) findViewById(R.id.get_data_btn);

        addAndCreateButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        removeButton.setOnClickListener(this);
        getDataButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                final Dialog addDialog = new Dialog(this);
                addDialog.setCancelable(true);
                addDialog.setContentView(R.layout.dialog_layout);
                addDialog.show();
                final EditText keyText = (EditText) addDialog.findViewById(R.id.et_key);
                final EditText valueText = (EditText)addDialog.findViewById(R.id.et_value);
                Button submitButton = (Button)addDialog.findViewById(R.id.submit_button);
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String key = keyText.getText().toString();
                        String value = valueText.getText().toString();
                        if(key.isEmpty() && value.isEmpty()) {
                            keyText.setError("Please Enter a key text");
                            valueText.setError("Please Enter a value text");
                        }
                        else if(key.isEmpty())
                            keyText.setError("Please Enter a key text");
                        else if(value.isEmpty())
                            valueText.setError("Please Enter a value text");
                        else {
                            prefManager.addDataToPref(key,value);
                            addDialog.dismiss();
                        }

                    }
                });
                break;
            case R.id.create_btn:
                prefManager.createAndAddDataInPreference();
                break;
            case R.id.clear_btn:
                prefManager.clearPreference();
                break;
            case R.id.remove_btn:
                final Dialog rmvDialog = new Dialog(this);
                rmvDialog.setCancelable(true);
                rmvDialog.setContentView(R.layout.dialog_layout);
                rmvDialog.show();
                final EditText keyEditText = (EditText) rmvDialog.findViewById(R.id.et_key);
                final EditText valueEditText = (EditText)rmvDialog.findViewById(R.id.et_value);
                valueEditText.setVisibility(View.GONE);
                Button submitRmButton = (Button)rmvDialog.findViewById(R.id.submit_button);
                submitRmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String keyText = keyEditText.getText().toString();
                        if(keyText.isEmpty())
                            keyEditText.setError("Please Insert a key text");
                        else {
                            prefManager.removeDataFromPref(keyText);
                            rmvDialog.dismiss();
                        }
                    }
                });
                break;
            case R.id.get_data_btn:
                final Dialog getDialog = new Dialog(this);
                getDialog.setCancelable(true);
                getDialog.setContentView(R.layout.dialog_layout);
                getDialog.show();
                final EditText keyGetEditText = (EditText) getDialog.findViewById(R.id.et_key);
                final EditText valueGetText = (EditText)getDialog.findViewById(R.id.et_value);
                valueGetText.setVisibility(View.GONE);
                Button submitGetButton = (Button)getDialog.findViewById(R.id.submit_button);
                submitGetButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = keyGetEditText.getText().toString();
                        if(text.isEmpty())
                            keyGetEditText.setError("Please insert a key text to search for the value");
                        else {
                            getDialog.dismiss();
                            String value = prefManager.readPreferencesData(text);
                            prefDataView.setVisibility(View.VISIBLE);
                            prefDataView.setText(value);
                        }
                    }
                });
                break;
            default:
                break;
        }
    }
}
