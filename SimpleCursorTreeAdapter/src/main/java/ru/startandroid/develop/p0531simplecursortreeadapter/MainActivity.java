package ru.startandroid.develop.p0531simplecursortreeadapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleCursorTreeAdapter;

public class MainActivity extends AppCompatActivity {
    ExpandableListView elvMain;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DB(this);
        db.open();

        Cursor cursor = db.getCompanyData();
        startManagingCursor(cursor);

        String[] from = new String[]{DB.COMPANY_COLUMN_NAME};
        int[] to = new int[]{android.R.id.text1};
        String[] childFrom = new String[]{DB.PHONE_COLUMN_NAME};
        int[] childTO = new int[] {android.R.id.text1};

        SimpleCursorTreeAdapter sctAdapter = new MyAdapter(this, cursor, android.R.layout.simple_expandable_list_item_1,
                from, to, android.R.layout.simple_list_item_1, childFrom, childTO);
        elvMain = (ExpandableListView)findViewById(R.id.elvMain);
        elvMain.setAdapter(sctAdapter);

    }
    protected void onDestroy(){
        super.onDestroy();
        db.close();
    }

    private class MyAdapter extends SimpleCursorTreeAdapter {
        public MyAdapter(Context context, Cursor cursor, int groupLayout, String[] from, int[] to,
                         int childLayout, String[] childFrom, int[] childTo) {
            super(context, cursor, groupLayout, from, to, childLayout, childFrom, childTo);
        }

        @Override
        protected Cursor getChildrenCursor(Cursor groupCursor) {
            int idColumn = groupCursor.getColumnIndex(DB.COMPANY_COLUMN_ID);
            return db.getPhoneData(groupCursor.getInt(idColumn));
        }
    }
}
