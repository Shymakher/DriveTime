package com.example.drivetime.drivetime;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ChosenActivity extends ActionBarActivity {

    TextView dateView;
    TextView timeView;
    TextView ageView;
    TextView newDriverView;
    TextView carView;
    TextView ifPrivateView;
    TextView insBeforeView;
    TextView claimsView;
    TextView policeView;
    TextView stateView;
    TextView cityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen);

        dateView = (TextView)findViewById(R.id.textView12);
        timeView = (TextView)findViewById(R.id.textView22);
        ageView = (TextView)findViewById(R.id.textView202);
        newDriverView = (TextView)findViewById(R.id.textView32);
        carView = (TextView)findViewById(R.id.textView42);
        ifPrivateView = (TextView)findViewById(R.id.textView52);
        insBeforeView = (TextView)findViewById(R.id.textView62);
        claimsView = (TextView)findViewById(R.id.textView72);
        policeView = (TextView)findViewById(R.id.textView82);
        stateView = (TextView)findViewById(R.id.textView92);
        cityView = (TextView)findViewById(R.id.textView102);

        for (User user : Common.getInstance().getUser()){
            dateView.setText(""+user.getmDay()+":"+user.getmMonth()+":"+user.getmYear());
            timeView.setText(""+user.getmHour()+":"+user.getmMinute());
            ageView.setText(""+user.getmAge());
            newDriverView.setText(""+user.getmNewDriver());
            carView.setText(""+user.getmCar());
            ifPrivateView.setText(""+user.getmIfPrivate());
            insBeforeView.setText(""+user.getmInsBefore());
            claimsView.setText(""+user.getmClaims());
            policeView.setText(""+user.getmPolice());
            stateView.setText(""+user.getmState());
            cityView.setText(""+user.getmCity());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chosen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void confirm(View view){
        Intent intent = new Intent(getApplicationContext(), LoginPaymentActivity.class);
        startActivity(intent);
    }
}
