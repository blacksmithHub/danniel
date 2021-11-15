package com.dannielexample.libor.danniel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.dannielexample.libor.danniel.R.id.button_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public Button button;

    public void init() {
        button = (Button) findViewById(R.id.button_signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(toy);
            }
        });
    }
    public void onClick1(View v) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Button Login = (Button) findViewById(button_login);
        Login.startAnimation(myAnim);

        EditText password = (EditText)findViewById(R.id.editText_password);
        EditText email = (EditText)findViewById(R.id.editText_email) ;
        Bundle bu;
        bu = getIntent().getExtras();

        if(email.getText().toString().matches("") && password.getText().toString().matches(""))
        {
            Toast.makeText(MainActivity.this, "Invalid account", Toast.LENGTH_SHORT).show();
        }
        else if (!email.getText().toString().matches(bu.getString("email")) || !password.getText().toString().matches(bu.getString("password")))
        {
            if (!password.getText().toString().matches(bu.getString("password")) && !email.getText().toString().matches(bu.getString("email")))
            {
            Toast.makeText(MainActivity.this, "Invalid account", Toast.LENGTH_SHORT).show();
            }
            else if(!email.getText().toString().matches(bu.getString("email")))
            {
                Toast.makeText(MainActivity.this, "Invalid e-mail", Toast.LENGTH_SHORT).show();
            }
            else if(!password.getText().toString().matches(bu.getString("password")))
            {
                Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
            }

        }
        else if (email.getText().toString().matches(bu.getString("email")) && password.getText().toString().matches(bu.getString("password")))
        {
                Toast.makeText(MainActivity.this, "Loggin in...", Toast.LENGTH_SHORT).show();
        }

    }
    /*public void onClickpass (View v)
    {
        Button show = (Button)findViewById(R.id.button_show);
        if (show.callOnClick())
        {
            show.setInputType(InputType.TYPE_CLASS_TEXT);
            show.setText("HIDE");
        }
        else{
            show.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    public void onClickerase (View v)
    {
        Button erase = (Button)findViewById(R.id.button_erase);
        if (erase.callOnClick())
        {
            erase.setText(null);
        }
    }*/
}

