package com.dannielexample.libor.danniel;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.dannielexample.libor.danniel.R.id.button_login;
import static com.dannielexample.libor.danniel.R.id.button_signup;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    public Button button;
    public EditText password;
    public EditText confirm;
    public EditText email;
    public EditText firstn;
    public EditText lastn;
    public EditText mi;
    public CheckBox checkbox;
    public ProgressBar progress;

    public void init() {
        button = (Button) findViewById(R.id.button_signup);
        password = (EditText)findViewById(R.id.editText_password);
        confirm = (EditText)findViewById(R.id.editText_confirmpassword);
        email = (EditText)findViewById(R.id.editText_email);
        firstn = (EditText)findViewById(R.id.editText_firstname);
        lastn = (EditText)findViewById(R.id.editText_lastname);
        mi = (EditText)findViewById(R.id.editText_mi);
        checkbox = (CheckBox) findViewById(R.id.checkBox);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Animation myAnim = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.alpha);
                Button Signup = (Button) findViewById(button_signup);

                Signup.startAnimation(myAnim);

                if(password.getText().toString().matches(confirm.getText().toString()))
                {
                    if(lastn.getText().toString().matches("") && mi.getText().toString().matches("")
                            && email.getText().toString().matches("") && password.getText().toString().matches("")
                            && confirm.getText().toString().matches("") && !checkbox.isChecked()||

                            mi.getText().toString().matches("")
                                    && email.getText().toString().matches("") && password.getText().toString().matches("")
                                    && confirm.getText().toString().matches("") && !checkbox.isChecked()||

                            email.getText().toString().matches("") && password.getText().toString().matches("")
                                    && confirm.getText().toString().matches("") && !checkbox.isChecked()||

                          password.getText().toString().matches("")
                                    && confirm.getText().toString().matches("") && !checkbox.isChecked()||

                            confirm.getText().toString().matches("") && !checkbox.isChecked())
                    {//for all blanks
                        Toast.makeText(Main2Activity.this, "incomplete information", Toast.LENGTH_SHORT).show();
                    }
                    else if (!checkbox.isChecked())
                    {//for check box
                        Toast.makeText(Main2Activity.this, "please check the agreement", Toast.LENGTH_SHORT).show();
                    }
                    else if(password.getText().toString().matches("") && confirm.getText().toString().matches(""))
                    {//for empty password and confirm password
                        Toast.makeText(Main2Activity.this, "please enter a password", Toast.LENGTH_SHORT).show();
                    }
                    else if (firstn.getText().toString().matches(""))
                    {//for empty first name
                        Toast.makeText(Main2Activity.this, "please enter your first name", Toast.LENGTH_SHORT).show();
                    }
                    else if (lastn.getText().toString().matches(""))
                    {//for empty last name
                        Toast.makeText(Main2Activity.this, "please enter your last name", Toast.LENGTH_SHORT).show();
                    }
                    else if (mi.getText().toString().matches(""))
                    {//empty middle initial
                        Toast.makeText(Main2Activity.this, "please enter your middle initial", Toast.LENGTH_SHORT).show();
                    }
                    else if (email.getText().toString().matches(""))
                    {//for empty email
                        Toast.makeText(Main2Activity.this, "please enter your e-mail", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {//for all complete
                        Toast.makeText(Main2Activity.this, "signing in...",Toast.LENGTH_SHORT).show();
                        Intent toy = new Intent(Main2Activity.this, MainActivity.class);
                        toy.putExtra("email", email.getText().toString());
                        toy.putExtra("password", confirm.getText().toString());
                        startActivity(toy);
                    }

                }
                else if (password.getText().toString() != confirm.getText().toString())
                {
                    if(confirm.getText().toString().matches(""))
                    {//for empty confirm password
                        Toast.makeText(Main2Activity.this, "please confirm your password", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {//for error password and confirm password
                        Toast.makeText(Main2Activity.this, "password is not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void onClick(View v)
    {
        if(checkbox.isChecked())
        Toast.makeText(Main2Activity.this, "all data will store temporarily", Toast.LENGTH_SHORT).show();
    }
}
