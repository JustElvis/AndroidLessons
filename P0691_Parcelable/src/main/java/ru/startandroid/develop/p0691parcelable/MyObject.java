package ru.startandroid.develop.p0691parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by Slav on 06.12.2016.
 */

public class MyObject implements Parcelable {
    static final String LOG_TAG = "myLogs";
    String s;
    int i;


    public MyObject(String _s, int _i){
        Log.d(LOG_TAG, "MyObject(String _s, int _i");
        s = _s;
        i = _i;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d(LOG_TAG, "WriteToParcel");
        parcel.writeString(s);
        parcel.writeInt(i);


    }


    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");

            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };
    private MyObject(Parcel parcel){
        Log.d(LOG_TAG, "MyObject(Parcel parcel)");
        s = parcel.readString();
        i = parcel.readInt();
    }




}
