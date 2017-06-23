package ru.startandroid.develop.p0571gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    GridView grMain;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvMain, data );
        grMain = (GridView)findViewById(R.id.grMain);
        grMain.setAdapter(adapter);
        adjustGridView();
    }

    private void adjustGridView() {
        grMain.setNumColumns(GridView.AUTO_FIT);
        grMain.setColumnWidth(80);
        grMain.setHorizontalSpacing(5);
        grMain.setVerticalSpacing(5);
        grMain.setStretchMode(GridView.NO_STRETCH);

    }
}
