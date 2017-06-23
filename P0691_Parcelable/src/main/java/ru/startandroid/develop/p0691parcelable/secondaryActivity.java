package ru.startandroid.develop.p0691parcelable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Slav on 06.12.2016.
 */

public class secondaryActivity extends Activity {

    final String LOG_TAG = "myLogs";
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary);
        Log.d(LOG_TAG, "onCreateSecondaryActivity" );
        MyObject myObj = (MyObject)getIntent().getParcelableExtra(MyObject.class.getCanonicalName());
        Log.d(LOG_TAG, "myObj: " + myObj.s + ", " + myObj.i);
    }
}
