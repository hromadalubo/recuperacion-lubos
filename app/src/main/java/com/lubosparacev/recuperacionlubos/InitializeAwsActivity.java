package com.lubosparacev.recuperacionlubos;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;

public class InitializeAwsActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Log.i("Recuperacion Lubos", "Initialized Cognito");
        } catch (AmplifyException e) {
            e.printStackTrace();
            Log.e("Recuperacion Lubos", "Could not initialize Cognito", e);
        }
        try {
            Amplify.configure(getApplicationContext());
            Log.i("Recuperacion Lubos", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("Recuperacion Lubos", "Could not initialize Amplify", error);
        }

    }
}