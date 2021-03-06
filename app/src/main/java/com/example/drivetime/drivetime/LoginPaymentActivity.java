package com.example.drivetime.drivetime;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Arrays;


public class LoginPaymentActivity extends FragmentActivity {

    private LoginButton loginBtn;
    private TextView username;
    private UiLifecycleHelper uiHelper;

    String id;

    EditText cardNumber;
    EditText cvvNumber;
    EditText dateCard;
    EditText idNumber;
    EditText licenceNumber;
    CheckBox sendReceipt;

    String a;
    int keyDel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_payment);

        uiHelper = new UiLifecycleHelper(this, statusCallback);
        uiHelper.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_payment);

        username = (TextView) findViewById(R.id.username);
        loginBtn = (LoginButton) findViewById(R.id.fb_login_button);
        loginBtn.setReadPermissions(Arrays.asList("email"));
        loginBtn.setUserInfoChangedCallback(new LoginButton.UserInfoChangedCallback() {
            @Override
            public void onUserInfoFetched(final GraphUser user) {
                if (user != null) {
                    username.setText("You are currently logged in as " + user.getName() + " ---- " + user.getProperty("email").toString());

                    for (User userProject : Common.getInstance().getUser()) {
                        id = userProject.getmId();
                    }

                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Person");
                    query.getInBackground(id, new GetCallback<ParseObject>() {
                        public void done(ParseObject gameScore, ParseException e) {
                            if (e == null) {
                                // Now let's update it with some new data. In this case, only cheatMode and score
                                // will get sent to the Parse Cloud. playerName hasn't changed.
                                gameScore.put("Full_name", user.getName());
                                gameScore.put("Email", user.getProperty("email").toString());
                                gameScore.saveInBackground();
                            }
                        }
                    });


                } else {
                    username.setText("You are not logged in.");
                }
            }
        });

/////////////////////////////////////////////////////////////////////////////////
        cardNumber = (EditText) findViewById(R.id.editNumCard);
        dateCard = (EditText) findViewById(R.id.editDate);
        cvvNumber = (EditText) findViewById(R.id.editCVV);
        idNumber = (EditText) findViewById(R.id.editID);
        licenceNumber = (EditText) findViewById(R.id.editLicence);
        sendReceipt = (CheckBox) findViewById(R.id.sendReceipt);

        cardNumber.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                boolean flag = true;
                String eachBlock[] = cardNumber.getText().toString().split("-");
                for (int i = 0; i < eachBlock.length; i++) {
                    if (eachBlock[i].length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {

                    cardNumber.setOnKeyListener(new View.OnKeyListener() {

                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {

                            if (keyCode == KeyEvent.KEYCODE_DEL)
                                keyDel = 1;
                            return false;
                        }
                    });

                    if (keyDel == 0) {

                        if (((cardNumber.getText().length() + 1) % 5) == 0) {

                            if (cardNumber.getText().toString().split("-").length <= 3) {
                                cardNumber.setText(cardNumber.getText() + "-");
                                cardNumber.setSelection(cardNumber.getText().length());
                            }
                        }
                        a = cardNumber.getText().toString();
                    } else {
                        a = cardNumber.getText().toString();
                        keyDel = 0;
                    }

                } else {
                    cardNumber.setText(a);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_payment, menu);
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

    private Session.StatusCallback statusCallback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state,
                         Exception exception) {
            if (state.isOpened()) {
                Log.d("MainActivity", "Facebook session opened.");
            } else if (state.isClosed()) {
                Log.d("MainActivity", "Facebook session closed.");
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        uiHelper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSaveInstanceState(Bundle savedState) {
        super.onSaveInstanceState(savedState);
        uiHelper.onSaveInstanceState(savedState);
    }

    public void buyNow(View view) {

        startActivity(new Intent(getApplicationContext(), StartActivity.class));



    }

}
