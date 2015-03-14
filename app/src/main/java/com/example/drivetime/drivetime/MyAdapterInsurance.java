package com.example.drivetime.drivetime;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

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

        ImageView imageView3 = (ImageView) rl.findViewById(R.id.imageView3);
        TextView insuranceCompany = (TextView) rl.findViewById(R.id.insuraceCompany);
        TextView priceInsurance = (TextView) rl.findViewById(R.id.price);

//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Insurances");
//        query.whereEqualTo("objectId", Common.getInstance().getUser().get(position).getmId());
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> list, ParseException e) {
//                if (e == null) {
//                    for (final ParseObject parseObject : list) {
//                        ParseFile imageFile = (ParseFile) parseObject.get("image");
//                        if (imageFile != null) {
//                            imageFile.getDataInBackground(new GetDataCallback() {
//                                public void done(byte[] data, ParseException e) {
//                                    if (e == null) {
//                                        Bitmap bmp = BitmapFactory
//                                                .decodeByteArray(
//                                                        data, 0,
//                                                        data.length);
//
//                                        imageView3.setImageBitmap(bmp);
//                                    } else {
//                                    }
//                                }
//                            });
//                        }
//                    }
//                }
//            }
//        });

        imageView3.setImageBitmap(Common.getInstance().getInsurance().get(position).getBitmap());
        insuranceCompany.setText(Common.getInstance().getInsurance().get(position).getmInsurance());
        priceInsurance.setText(Common.getInstance().getInsurance().get(position).getmPrice());

        return rl;
    }
}
