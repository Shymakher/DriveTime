package com.example.drivetime.drivetime;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class StartActivity extends ActionBarActivity {

    Button buttonStart, buttonStop;
    Switch aSwitch;
    TextView timerView;

    public int genTime;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Calendar c = Calendar.getInstance();
        int myMinute = c.get(Calendar.MINUTE);
        int myHour = c.get(Calendar.HOUR_OF_DAY);

        aSwitch = (Switch) findViewById(R.id.switch1);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setEnabled(false);
        buttonStop = (Button) findViewById(R.id.buttonStop);

        timerView = (TextView) findViewById(R.id.textView10);

        for (User user : Common.getInstance().getUser()) {
            genTime = ((user.getmHour() - myHour) * 60 + (user.getmMinute() - myMinute)) * 60;
//            timerView.setText("myHour " + myHour + "\n" + "genTime " + genTime + "\n" + " user.getmHour() " + user.getmHour());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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

    public void switcher(View view) {
        if (aSwitch.isChecked()) {
            buttonStart.setEnabled(true);
        } else {
            buttonStart.setEnabled(false);
        }
    }

    public void start(View view) {
        timer = new CountDownTimer(genTime * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                System.out.println(hms);
                timerView.setText(hms);

            }

            @Override
            public void onFinish() {
                timerView.setText("Completed.");
            }
        }.start();
        buttonStart.setEnabled(false);
    }

    public void stop(View view) {
        timer.cancel();
    }

}
