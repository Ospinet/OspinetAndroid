package com.ospinet.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.ospinet.app.R;


public class login_2 extends FragmentActivity {
    Button SignUp, Login;

    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_2);
        SignUp = (Button) findViewById(R.id.btn_login_signup);
        Login = (Button) findViewById(R.id.btn_login_button);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(login_2.this, LoginActivity.class);
                login_2.this.startActivity(login);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(login_2.this, SignUpActivity.class);
                login_2.this.startActivity(signup);
            }
        });
    }
}


