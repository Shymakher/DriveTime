package com.example.drivetime.drivetime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Vector;

public class CompareActivity extends ActionBarActivity {

    private MyAdapterInsurance myAdapterInsurance;
    private ListView listView;
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        myAdapterInsurance = new MyAdapterInsurance(getApplicationContext());
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(myAdapterInsurance);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                rl = (RelativeLayout)view;

                Intent intent = new Intent(getApplicationContext(), ChosenActivity.class);
                startActivity(intent);

//                TextView textView = (TextView)rl.findViewById(R.id.insuraceCompany);
//                String str = textView.getText().toString();

//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compare, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void help(View view){

//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Insurances");
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> parseObjects, ParseException e) {
//                if (e == null){
////                    Common.getInstance().getInsurance().clear();
//                    for(ParseObject parse : parseObjects){
////                        company = parse.getString("InsuranceCompany");
////                        price = parse.getString("Price");
////                        Toast.makeText(getApplicationContext(), company + " " + price, Toast.LENGTH_SHORT).show();
//
//                        Common.getInstance().getInsurance().add(new Insurance(parse.getString("InsuranceCompany"), parse.getString("Price")));
////                        victor.add(new Insurance(parse.getString("InsuranceCompany"), parse.getString("Price")));
//                    }
//                }else{
//
//                }
//            }
//        });

//        for( insuranceqwe : Common.getInstance().getInsurance()){
//            System.out.println(insuranceqwe);
//        }

    }
}
