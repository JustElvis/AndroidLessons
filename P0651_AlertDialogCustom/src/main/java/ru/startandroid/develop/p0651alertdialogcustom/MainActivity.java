package ru.startandroid.develop.p0651alertdialogcustom;

import android.app.Dialog;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    final int DIALOG = 1;

    int btn;
    LinearLayout view;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    TextView tvCount;
    ArrayList<TextView> textviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textviews = new ArrayList<TextView>(10);

        }
    public void onclick(View v){
        btn = v.getId();
        showDialog(DIALOG);
    }
    protected Dialog onCreateDialog(int id){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Custom Dialog");
        view = (LinearLayout)getLayoutInflater().inflate(R.layout.dialog, null);
        adb.setView(view);
        tvCount = (TextView)findViewById(R.id.tvCount);
        return adb.create();
    }
    protected void onPrepareDialog(int id, Dialog dialog){
        super .onPrepareDialog(id , dialog);
        if (id == DIALOG){
            TextView tvTime = (TextView)dialog.getWindow().findViewById(R.id.tvTime);
            tvTime.setText(sdf.format(new Date(System.currentTimeMillis())));
            if (btn == R.id.btnAdd){
                TextView tv = new  TextView(this);
                view.addView(tv, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tv.setText("someText" + (textviews.size() + 1));
                textviews.add(tv);
            } else {
                if (textviews.size() > 0){
                    TextView tv = textviews.get(textviews.size() - 1);
                    view.removeView(tv);
                    textviews.remove(tv);
                }
            }
            tvCount.setText("Кількість добавлений TextView = " + textviews.size());
        }
    }
}
