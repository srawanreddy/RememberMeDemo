package com.example.sravanreddy.remembermedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    CheckBox remember;
    Button button;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        remember=findViewById(R.id.checkBox);

        sharedPreferences=getSharedPreferences("My_SharedFile", Context.MODE_PRIVATE);
        username.setText(sharedPreferences.getString("UserName", ""));
        password.setText(sharedPreferences.getString("Password", ""));
        remember.setChecked(sharedPreferences.getBoolean("RememberMe", false));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(remember.isChecked()) {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("UserName", username.getText().toString());
                editor.putString("Password", password.getText().toString());
                editor.putBoolean("RememberMe", true);
                editor.commit();
                }
                else
                {
                    sharedPreferences.edit().remove("UserName").commit();
                    sharedPreferences.edit().remove("Password").commit();
                }
            }
        });
    }
}
