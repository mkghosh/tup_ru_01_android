package com.example.mithunkumerghose.sharedpreferencedemo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author Mithun Kumer Ghose.
 */

public class MyPrefManager {

    private Context context;
    public MyPrefManager (Context context) {
        this.context = context;
    }

    public void createAndAddDataInPreference() {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(Constants.PREF_KEY, "This is my Shared Preference Demo Data.");
        editor.apply();
    }

    public void clearPreference() {
        SharedPreferences.Editor editor = getEditor();
        editor.clear();
        editor.apply();
        Toast.makeText(context, "Shared Preference have been cleared.", Toast.LENGTH_SHORT).show();
    }

    public void addDataToPref(String key, String value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, value);
        editor.apply();
        Toast.makeText(context, "Preference Key : " + key + " and value " + value + " added" , Toast.LENGTH_SHORT).show();
    }

    public void removeDataFromPref(String key) {
        SharedPreferences.Editor editor = getEditor();
        editor.remove(key);
        editor.apply();
        Toast.makeText(context, "Data removed with the associated key : " + key, Toast.LENGTH_SHORT).show();
    }

    public String readPreferencesData(String text) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        return preferences.getString(text,"No value found");
    }

    private SharedPreferences.Editor getEditor() {
        SharedPreferences preferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        return preferences.edit();
    }
}
