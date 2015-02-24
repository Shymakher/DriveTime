package com.example.drivetime.drivetime;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Vovanchik on 20.02.2015.
 */
public class MyAdapterInsurance extends BaseAdapter {

    private Context context;

    public MyAdapterInsurance(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Common.getInstance().getInsurance().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout rl = null;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        rl = (RelativeLayout) inflater.inflate(R.layout.insurance_list, parent, false);

        //ImageView image = (ImageView) rl.findViewById(R.id.imageView2);
        TextView insuranceCompany = (TextView) rl.findViewById(R.id.insuraceCompany);
        TextView priceInsurance = (TextView) rl.findViewById(R.id.price);

        insuranceCompany.setText(Common.getInstance().getInsurance().get(position).getmInsurance());
        priceInsurance.setText(Common.getInstance().getInsurance().get(position).getmPrice());

        //insuranceCompany.setTextColor(Color.BLACK);
        //priceInsurance.setTextColor(Color.RED);

        //insuranceCompany.setTextSize(25);
        //priceInsurance.setTextSize(25);

        return rl;
    }
}
