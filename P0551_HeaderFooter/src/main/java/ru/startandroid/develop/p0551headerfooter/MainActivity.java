package ru.startandroid.develop.p0551headerfooter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    String[] data = {"one", "two", "three", "four", "five"};
    ListView lvMain;
    ArrayAdapter<String> adapter;

    View header1;
    View header2;

    View footer1;
    View footer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView)findViewById(R.id.lvMain);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        header1 = createHeader ("header1");
        header2 = createHeader ("header2");
        footer1 = createFooter ("footer1");
        footer2 = createFooter ("footer2");

        fillList();
    }

    View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    View createHeader(String text) {
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    void fillList() {

        lvMain.addHeaderView(header1);
        lvMain.addHeaderView(header2, "some text for header2", false);
        lvMain.addFooterView(footer1);
        lvMain.addFooterView(footer2, "some text for footer2", false);
        lvMain.setAdapter(adapter);



        }

    public void onClick(View v){

        
    }
}
