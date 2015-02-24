package com.example.drivetime.drivetime;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class PersonalDetailsActivity extends ActionBarActivity {

    ArrayList arrayAge = new ArrayList();
    ArrayAdapter<String> adapterAge;
    Spinner spinnerAge;
    int myAgeParse;

    String[] cars = {"ACURA", "ALFA ROMEO", "ASTON MARTIN", "AUDI", "BENTLEY", "BMW", "BMW ALPINA", "BUICK",
            "CADILLAC", "CHEVROLET", "CHRYSLER", "CITROEN", "DAEWOO", "DAIHATSU", "DODGE", "FERRARI", "FIAT", "FORD",
            "HONDA", "HUMMER", "HYUNDAI", "INFINITI", "ISUZU", "JAGUAR", "JEEP", "KIA", "LAMBORGHINI", "LAND ROVER",
            "LEXUS", "MASERATI", "MAYBACH", "MAZDA", "MERCEDES", "MERCEDES AMG", "MINI", "MITSUBISHI", "NISSAN", "OPEL",
            "PEUGEOT", "PONTIAC", "PORSCHE", "RENAULT", "ROLLS-ROYCE", "SAAB", "SEAT", "SKODA", "SMART", "SSANGYONG", "SUBARU",
            "SUZUKI", "TOYOTA", "VOLKSWAGEN", "VOLVO"};
    ArrayAdapter<String> adapterCars;
    Spinner spinnerCars;
    String carParse;

    String[] newDriver = {"yes", "no"};
    ArrayAdapter<String> adapterNewDriver;
    Spinner spinnerNewDriver;
    String newDriverParse;

    String[] IfPrivate = {"private", "company"};
    ArrayAdapter<String> adapterIfPrivate;
    Spinner spinnerIfPrivate;
    String IfPrivateParse;

    String[] insuranceBefore = {"yes", "no"};
    ArrayAdapter<String> adapterBefore;
    Spinner spinnerBefore;
    String insuranceBeforeParse;

    String[] claims = {"yes", "no"};
    ArrayAdapter<String> adapterClaims;
    Spinner spinnerClaims;
    String claimsParse;

    String[] police = {"yes", "no"};
    ArrayAdapter<String> adapterPolice;
    Spinner spinnerPolice;
    String policeParse;

    String[] state = {"Israel"};
    ArrayAdapter<String> adapterState;
    Spinner spinnerState;
    String stateParse;

    String[] city = {"Acrea", "Afula", "Arad", "Arielb", "Ashdod", "Ashkelond", "Baqa al-Gharbiyye", "Bat Yam",
            "Beershebae", "Beit She'anf", "Beit Shemeshg", "Beitar Illit", "Bnei Brakh", "Dimona",
            "Eilat", "El'ad", "Giv'at Shmuel", "Giv'atayim", "Hadera", "Haifa", "Herzliyak", "Hod HaSharon",
            "Holon", "Jerusalem", "Kafr Qasimm", "Karmiell", "Kfar Sabao", "Kiryat Atap",
            "Kiryat Bialikq", "Kiryat Gatr", "Kiryat Malakhis", "Kiryat Motzkint", "Kiryat Onou",
            "Kiryat Shmonav", "Kiryat Yamw", "Lod Center", "Ma ale Adumim", "Ma alot-Tarshiha",
            "Migdal HaEmekx", "Modi in Illit", "Modi in-Maccabim-Re uty", "Nahariyaz", "Nazareth", "Nazareth Illitaa", "Nesher",
            "Ness Zionaab", "Netanya", "Netivot", "Ofakimac", "Or Akivaad", "Or Yehuda", "Petah Tikvaae", "Qalansawe", "Ra anana",
            "Rahat", "Ramat Gan", "Ramat HaSharon", "Ramla", "Rehovot", "Rishon LeZionaf", "Rosh HaAyin", "Safedag", "Sakhnin", "Sderotah",
            "Shefa-Amr", "Tamra", "Tayibe", "Tel Aviv", "Tiberias", "Tira", "Tirat Carmelak", "Umm al-Fahm", "Yavne", "Yehud-Monosson", "Yokneam"};
    ArrayAdapter<String> adapterCity;
    Spinner spinnerCity;
    String cityParse;

    Button dealOffer;
    CheckBox checkBox;


    Calendar c = Calendar.getInstance();
    int DIALOG_DATE = 1;
    int myYear = c.get(Calendar.YEAR);
    int myMonth = c.get(Calendar.MONTH);
    int myDay = c.get(Calendar.DAY_OF_MONTH);

    int DIALOG_TIME = 2;
    int myMinute = c.get(Calendar.MINUTE);
    int myHour = c.get(Calendar.HOUR_OF_DAY);

    private ProgressDialog mPd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

////////////////////////////////////////////////////////////////
        for (int i = 17; i <= 100; i++) {
            arrayAge.add(i);
        }

        adapterAge = new ArrayAdapter<String>(this, R.layout.spinner_item, arrayAge);
        adapterAge.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        spinnerAge.setAdapter(adapterAge);

        spinnerAge.setPrompt("Age");

//        spinnerAge.setSelection(2);

        spinnerAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                myAgeParse = Integer.parseInt(spinnerAge.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////
        adapterCars = new ArrayAdapter<String>(this, R.layout.spinner_item, cars);
        adapterCars.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerCars = (Spinner) findViewById(R.id.spinnerCars);
        spinnerCars.setAdapter(adapterCars);

        spinnerCars.setPrompt("Cars");

//        spinnerAge.setSelection(2);

        spinnerCars.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                carParse = spinnerCars.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////
        adapterNewDriver = new ArrayAdapter<String>(this, R.layout.spinner_item, newDriver);
        adapterNewDriver.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerNewDriver = (Spinner) findViewById(R.id.spinnerNewDriver);
        spinnerNewDriver.setAdapter(adapterNewDriver);

        spinnerNewDriver.setPrompt("New Driver");

//        spinnerAge.setSelection(2);

        spinnerNewDriver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                newDriverParse = spinnerNewDriver.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////

        adapterIfPrivate = new ArrayAdapter<String>(this, R.layout.spinner_item, IfPrivate);
        adapterIfPrivate.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerIfPrivate = (Spinner) findViewById(R.id.spinnerIfPrivate);
        spinnerIfPrivate.setAdapter(adapterIfPrivate);

        spinnerIfPrivate.setPrompt("Private or company");

        spinnerIfPrivate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                IfPrivateParse = spinnerIfPrivate.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////

        adapterBefore = new ArrayAdapter<String>(this, R.layout.spinner_item, insuranceBefore);
        adapterBefore.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerBefore = (Spinner) findViewById(R.id.spinnerBefore);
        spinnerBefore.setAdapter(adapterBefore);

        spinnerBefore.setPrompt("Insurance before");

        spinnerBefore.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                insuranceBeforeParse = spinnerBefore.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////

        adapterClaims = new ArrayAdapter<String>(this, R.layout.spinner_item, claims);
        adapterClaims.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerClaims = (Spinner) findViewById(R.id.spinnerClaims);
        spinnerClaims.setAdapter(adapterClaims);

        spinnerClaims.setPrompt("Claims");

        spinnerClaims.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                claimsParse = spinnerClaims.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////
        adapterPolice = new ArrayAdapter<String>(this, R.layout.spinner_item, police);
        adapterPolice.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerPolice = (Spinner) findViewById(R.id.spinnerPolice);
        spinnerPolice.setAdapter(adapterPolice);

        spinnerPolice.setPrompt("Police");

        spinnerPolice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                policeParse = spinnerPolice.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////
        adapterState = new ArrayAdapter<String>(this, R.layout.spinner_item, state);
        adapterState.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerState = (Spinner) findViewById(R.id.spinnerState);
        spinnerState.setAdapter(adapterState);

        spinnerState.setPrompt("State");

        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                stateParse = spinnerState.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////

        adapterCity = new ArrayAdapter<String>(this, R.layout.spinner_item, city);
        adapterCity.setDropDownViewResource(R.layout.spinner_dropdown_item);


        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
        spinnerCity.setAdapter(adapterCity);

        spinnerCity.setPrompt("City");

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                cityParse = spinnerCity.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
////////////////////////////////////////////////////////////////

        dealOffer = (Button) findViewById(R.id.deal_offer);
        dealOffer.setEnabled(false);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
////////////////////////////////////////////////////////////////
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personal_details, menu);
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

    public void itemClicked(View view) {
        if (checkBox.isChecked()) {
            dealOffer.setEnabled(true);
        } else {
            dealOffer.setEnabled(false);
        }

    }

    public void date(View view) {
        showDialog(DIALOG_DATE);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, DatePickerDialog.THEME_DEVICE_DEFAULT_DARK, myCallBackDate, myYear, myMonth, myDay);
            return tpd;
        }
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd2 = new TimePickerDialog(this, TimePickerDialog.THEME_HOLO_DARK, myCallBackTime, myHour, myMinute, true);
//            TimePickerDialog.THEME_HOLO_DARK
            return tpd2;
        }
        return super.onCreateDialog(id);
    }

//    protected Dialog onCreateDialog(int id) {
//        if (id == DIALOG_TIME) {
//            TimePickerDialog tpd2 = new TimePickerDialog(this, myCallBackTime, myHour, myMinute, true);
//            return tpd2;
//        }
//        return super.onCreateDialog(id);
//    }


    DatePickerDialog.OnDateSetListener myCallBackDate = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            Toast.makeText(getApplicationContext(), "Today is " + myDay + " : " + myMonth + " : " + myYear, Toast.LENGTH_SHORT).show();
        }
    };

    TimePickerDialog.OnTimeSetListener myCallBackTime = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myMinute = minute;
            myHour = hourOfDay;
            Toast.makeText(getApplicationContext(), "Time is " + myHour + " hours " + myMinute + " minutes", Toast.LENGTH_SHORT).show();
        }
    };

    public void time(View view) {
        showDialog(DIALOG_TIME);
    }

    public void dealOffer(View view) {

        mPd = new ProgressDialog(this, ProgressDialog.THEME_HOLO_DARK);
        mPd.setTitle("Loading!");
        mPd.setMessage("Please wait! :)");
        mPd.show();

        final ParseObject po = new ParseObject("Person");

        po.put("Day", myDay);
        po.put("Month", myMonth);
        po.put("Year", myYear);

        po.put("Minute", myMinute);
        po.put("Hour", myHour);

        po.put("Age", myAgeParse);
        po.put("NewDriver", newDriverParse);
        po.put("Car", carParse);
        po.put("What_using", IfPrivateParse);
        po.put("Insuranse_Before", insuranceBeforeParse);
        po.put("Claims", claimsParse);
        po.put("Police", policeParse);
        po.put("State", stateParse);
        po.put("City", cityParse);

        po.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Common.getInstance().getUser().add(new User(po.getObjectId(),myDay, myMonth, myYear, myMinute, myHour, myAgeParse, newDriverParse, carParse, IfPrivateParse, insuranceBeforeParse, claimsParse, policeParse, stateParse, cityParse));
                } else {
                    Toast.makeText(getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT).show();
                    System.out.println(e.getLocalizedMessage());
                }
            }
        });

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Insurances");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    Common.getInstance().getInsurance().clear();
                    for (ParseObject parse : parseObjects) {
                        Common.getInstance().getInsurance().add(new Insurance(parse.getString("InsuranceCompany"), parse.getString("Price")));
                    }
                    Intent intent = new Intent(getApplicationContext(), CompareActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT).show();
                }
                mPd.cancel();

            }


        });

    }

}
