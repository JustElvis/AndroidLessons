package ru.startandroid.develop.p0601alertdialogsimple;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int DIALOG_EXIT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclick(View view){
        showDialog(DIALOG_EXIT);
    }
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_EXIT){
            AlertDialog.Builder abd = new AlertDialog.Builder(this);
            abd.setTitle(R.string.exit);
            abd.setMessage(R.string.save_data);
            abd.setIcon(android.R.drawable.ic_dialog_info);
            abd.setPositiveButton(R.string.yes, myClickListener);
            abd.setNegativeButton(R.string.no, myClickListener);
            abd.setNeutralButton(R.string.cancel, myClickListener);
            return abd.create();
        }
        return super.onCreateDialog(id);
    }
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case Dialog.BUTTON_POSITIVE:
                    saveData();
                    finish();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    finish();
                    break;
                case Dialog.BUTTON_NEUTRAL:
                    break;
            }

        }
    };

    void saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }
}
