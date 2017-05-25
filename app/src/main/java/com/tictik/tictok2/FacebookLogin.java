package com.tictik.tictok2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookLogin extends AppCompatActivity {
    LoginButton loginButton;
    Profile profile;
    CallbackManager callbackManager;
    ImageView mImgCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_facebook_login);


        if(isLoggedIn()){

            showOtpDialog(profile);
        }
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        loginButton.setReadPermissions("public_profile");
        callbackManager = CallbackManager.Factory.create();
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                //    profile=Profile.getCurrentProfile();
                showOtpDialog(profile);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    private void showOtpDialog(Profile profile) {
        final Dialog dialog = new Dialog(FacebookLogin.this);
        dialog.setContentView(R.layout.otp_dialog);
        dialog.setTitle("Your Mobile Number");


        final RelativeLayout otpLayout = (RelativeLayout) dialog.findViewById(R.id.otpLayout);
        final RelativeLayout verifiedLayout = (RelativeLayout) dialog.findViewById(R.id.verifiedLayout);
        // set the custom dialog components - text, image and button

        // text.setText(profile.getName());
      mImgCheck = (ImageView) dialog.findViewById(R.id.tick);



        Button dialogButton = (Button) dialog.findViewById(R.id.submit);
        Button letsbegin = (Button) dialog.findViewById(R.id.letsbegin);
        // if button is clicked, close the custom dialog
        letsbegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileNumberVerified(otpLayout, verifiedLayout);
            }
        });

        dialog.show();
    }

    private void mobileNumberVerified(RelativeLayout otpLayout, RelativeLayout verifiedLayout) {

        otpLayout.setVisibility(View.INVISIBLE);
        ((Animatable) mImgCheck.getDrawable()).start();
        verifiedLayout.setVisibility(View.VISIBLE);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void nextActivity() {

        startActivity(new Intent(FacebookLogin.this, GameType.class));
        finish();
    }

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

}
