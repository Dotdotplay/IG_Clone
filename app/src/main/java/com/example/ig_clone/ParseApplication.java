package com.example.ig_clone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("raqib-ig-clone") // should correspond to APP_ID env variable
                .clientKey("raqib123")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://raqib-ig-clone.herokuapp.com/parse").build());
    }
}
