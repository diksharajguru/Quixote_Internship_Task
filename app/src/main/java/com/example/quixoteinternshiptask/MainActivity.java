package com.example.quixoteinternshiptask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEmail = email.getText().toString();
                String newPassword = password.getText().toString();
                String userDetails = preferences.getString(newEmail + newPassword + "data","No information on that user.");
                SharedPreferences.Editor editor = preferences.edit();
                if (newEmail.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your mail id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (newPassword.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                editor.putString(userDetails,userDetails);
                editor.commit();
                Toast.makeText(MainActivity.this, "Logged in..", Toast.LENGTH_SHORT).show();
                Intent displayScreen = new Intent(MainActivity.this, Login.class);
                startActivity(displayScreen);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(MainActivity.this, signup.class);
                startActivity(registerScreen);
            }
        });
    }
}
