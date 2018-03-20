package com.amritha.acadgild.android_session13_assignment1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PopUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_pop_up);

        //finding the ids for these views

        Button dismissButton = (Button) findViewById(R.id.closBtn);

        Button buttonGoogle = (Button) findViewById(R.id.browser_1);

        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //opening the new page by initiating intent

                Intent iGoogle = new Intent(Intent.ACTION_VIEW);

                iGoogle.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //opening chrome browser directly opening the website

                iGoogle.setPackage("com.android.chrome");

                iGoogle.setData(Uri.parse("https://acadgild.com/"));

                startActivity(iGoogle);//starting the Activity
            }
        });

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                PopUpActivity.this.finish();//closing the dialog

            }
        });

    }
}
