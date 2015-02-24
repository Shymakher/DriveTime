package com.example.drivetime.drivetime;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

public class MyApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, "WhLHywbPRIIcxx4dPAgTOFvyyhJEd2JQXyfFLsE8",
				"HyQX2PNS3EXFDXTnPJE5AmdeyeVYClk1HkT8x5JW");



	}

}
