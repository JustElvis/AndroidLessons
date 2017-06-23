package ru.startandroid.develop.p0611alertdialogprepare;

import android.app.Dialog;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "mylogs";
    final int DIALOG = 1;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclick(View view){
        showDialog(DIALOG);
    }
    protected Dialog onCreateDialog(int id){
        Log.d(LOG_TAG, "On create dialog");
        if (id == DIALOG){
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Час");

            adb.setMessage(sdf.format(new Date(System.currentTimeMillis())) );
            return adb.create();
        }
        return super.onCreateDialog(id);
    }
    protected void  onPrepareDialog(int id, Dialog dialog){
        super.onPrepareDialog(id, dialog);
        Log.d(LOG_TAG, "onPrepareDialog");
        if (id == DIALOG){
            ((AlertDialog)dialog).setMessage(sdf.format(new Date(System.currentTimeMillis())));
        }
    }
}
