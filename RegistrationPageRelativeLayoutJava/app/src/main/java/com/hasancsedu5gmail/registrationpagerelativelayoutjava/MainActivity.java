package com.hasancsedu5gmail.registrationpagerelativelayoutjava;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.*;
import android.text.*;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //layout
        RelativeLayout layoutRegister = new RelativeLayout(this);
        layoutRegister.setBackgroundColor(Color.WHITE);


        //---------------------------create components-----------------
        //registration button
        Button registerButton = new Button(this);
        registerButton.setText("Registration");
        registerButton.setBackgroundColor(Color.GREEN);


        //username input fild
        EditText userName = new EditText(this);
        userName.setBackgroundColor(Color.LTGRAY);

        //password field

        EditText userPassword = new EditText(this);
        userPassword.setBackgroundColor(Color.LTGRAY);



        //set id to identify
        registerButton.setId(1);
        userName.setId(2);
        userPassword.setId(3);

        //-------------------------------------------------------------------------------------

        //----------------component container properties---------------------------------------
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(

                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT

        );

        //userName container properties

        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(

                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT

        );

        RelativeLayout.LayoutParams userPasswordDetailse = new RelativeLayout.LayoutParams(

                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT

        );


        //--------------------------------give rulse to possitioning widgit

        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);

        userPasswordDetailse.addRule(RelativeLayout.ABOVE,registerButton.getId());
        userPasswordDetailse.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userPasswordDetailse.setMargins(0,0,0,50);

        userNameDetails.addRule(RelativeLayout.ABOVE,userPassword.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0,0,0,50);



        Resources r = getResources();

        int px = (int)TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                200,
                r.getDisplayMetrics()
                );



        userPassword.setWidth(px);
        userName.setWidth(px);






        //-----------------------------------------------------------------



        layoutRegister.addView(registerButton,buttonDetails);
        layoutRegister.addView(userPassword,userPasswordDetailse);
        layoutRegister.addView(userName,userNameDetails);


        setContentView(layoutRegister);

    }

}
