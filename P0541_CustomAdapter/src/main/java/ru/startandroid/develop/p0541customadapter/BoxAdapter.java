package ru.startandroid.develop.p0541customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter{
    Context ctx;
    ArrayList<Product> objects;
    LayoutInflater inflater;

    public BoxAdapter(Context context, ArrayList<Product> products){
        objects = products;
        ctx = context;
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.item, parent, false);

        Product p = getProduct(position);
        ((TextView)view.findViewById(R.id.tvDescr)).setText(p.name);
        ((TextView)view.findViewById(R.id.tvPrice)).setText(p.price + "");
        ((ImageView)view.findViewById(R.id.image)).setImageResource(p.image);

        CheckBox cbBuy = (CheckBox)view.findViewById(R.id.checkbox);
        cbBuy.setOnCheckedChangeListener(myCheckChangeListener);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);


        return view;
    }

    private Product getProduct(int position) {
        return ((Product)getItem(position));

    }
    ArrayList<Product> getBox(){
        ArrayList<Product> box = new ArrayList<Product>();
        for (Product p : objects){
            if (p.box)
                box.add(p);
        }
    return box;


    }

    CompoundButton.OnCheckedChangeListener myCheckChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getProduct((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}