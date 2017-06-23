package ru.startandroid.develop.p0591datepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int DIALOG_DATE = 1;
    int myYear = 2016;
    int myMonth = 11;
    int myDay = 15;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate = (TextView)findViewById(R.id.tvDate);

    }
    public void onclick(View view){
        showDialog(DIALOG_DATE);
    }
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_DATE){
            DatePickerDialog dpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
            return dpd;
        }
        return super.onCreateDialog(id);
    }
    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myYear = year;
            myMonth = month;
            myDay = dayOfMonth;
            tvDate.setText("date is : " + myYear + "/" + myMonth + "/" + myDay);
        }
    };
}
