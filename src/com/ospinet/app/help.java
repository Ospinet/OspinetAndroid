package com.ospinet.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ospinet.app.R;


public class help extends Activity {
    EditText To_Email, From_Email, Description;
    Button Cancel, Send;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        To_Email = (EditText) findViewById(R.id.edtTo_Email);
        From_Email = (EditText) findViewById(R.id.edtEmail);
        Description = (EditText) findViewById(R.id.editDescription);
        Cancel = (Button) findViewById(R.id.btnCancel);
        Send = (Button) findViewById(R.id.btnSend);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent records = new Intent(help.this, Member_Home.class);
                help.this.startActivity(records);
            }
        });

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation val = new Validation();
                if(val.Is_Valid_Email(From_Email) && !Description.getText().toString().trim().equals(""))
                {
                    Toast.makeText(help.this, "Problem in network.. Try after some time", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(help.this, "Please enter your email address and Problem", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onBackPressed() {
        Intent i = new Intent(help.this, Member_Home.class);
        this.startActivity(i);
        finish();
    }
}


