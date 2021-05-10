package com.example.quixoteinternshiptask;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
//public class signup extends AppCompatActivity {
//    private CheckBox saveLoginCheckBox;
//    private Boolean saveLogin;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//        final EditText userName = (EditText) findViewById(R.id.etNewName);
//        final EditText password = (EditText) findViewById(R.id.etNewPassword);
//        final EditText email = (EditText) findViewById(R.id.etNewEmail);
//        final EditText phone = (EditText) findViewById(R.id.editTextPhone);
//        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);
//        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
//        String newPassword = password.getText().toString();
//        String newUser  = userName.getText().toString();
//        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
//        saveLogin = preferences.getBoolean("saveLogin", false);
//        SharedPreferences.Editor editor = preferences.edit();
//        if (saveLogin == true) {
//            password.setText(preferences.getString("password", ""));
//            saveLoginCheckBox.setChecked(true);
//        }
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            String MobilePattern = "[0-9]{10}";
//            String Expn =
//                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
//                            +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//                            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
//                            +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//                            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
//                            +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
//            String passwordpattern = "^(?=.[a-z])" + !newPassword.contains(newUser) + "(?=.[A-Z]) (?=.[A-Z]) (?=.[@#$%^&+=]) (?=.[0-9]) (?=.*[0-9]){8,23}";
//            @Override
//            public void onClick(View v) {
//                if (saveLoginCheckBox.isChecked()) {
//                    editor.putBoolean("saveLogin", true);
//                    editor.putString("password", newPassword);
//
//                    editor.commit();
//                } else {
//                    editor.clear();
//                    editor.commit();
//                }
//                if(!phone.getText().toString().matches(MobilePattern)) {
//                    Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
//                }
//                if(!email.getText().toString().matches(Expn)) {
//                    Toast.makeText(getApplicationContext(), "Please enter valid email id", Toast.LENGTH_SHORT).show();
//                }
//                if(!password.getText().toString().matches(passwordpattern)) {
//                    Toast.makeText(getApplicationContext(), "Please enter valid password", Toast.LENGTH_SHORT).show();
//                }
//                String newPassword = password.getText().toString();
//                String newUser  = userName.getText().toString();
//                String newEmail = email.getText().toString();
//                String Phone = phone.getText().toString();
//                editor.putString(newUser,newUser);
//                editor.commit();
//                editor.putString(newPassword, newPassword);
//                editor.commit();
//                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
//                editor.commit();
//                editor.putString(Phone, Phone);
//                editor.commit();
//                Intent displayScreen = new Intent(signup.this, MainActivity.class);
//                startActivity(displayScreen);
//            }
//        });
//    }
//}
public class signup extends AppCompatActivity {
    private CheckBox remember;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText password = (EditText) findViewById(R.id.etNewPassword);
        final EditText email = (EditText) findViewById(R.id.etNewEmail);
        final EditText phone = (EditText) findViewById(R.id.editTextPhone);
        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);
        String newUser  = userName.getText().toString();
        String newPassword = password.getText().toString();
        String newEmail = email.getText().toString();
        String newPhone = phone.getText().toString();
        remember =findViewById(R.id.remember);
        boolean isRemember = preferences.getBoolean("remember_password",false);
        if (isRemember){
            String Password = preferences.getString("etNewPassword","");
            password.setText(Password);
            remember.setChecked(true);
        }
            String MobilePattern = "[0-9]{10}";
            String Expn =
                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                            +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                            +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                            +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
            String passwordpattern = "^(?=.[a-z])" + !newPassword.contains(newUser) + "(?=.[A-Z]) (?=.[A-Z]) (?=.[@#$%^&+=]) (?=.[0-9]) (?=.*[0-9]){8,14}";
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(remember.isChecked()){
                    editor.putBoolean("remember_password",true);
                    editor.putString("Password",newPassword);
                }else{editor.clear();}

                editor = preferences.edit();
                if(!phone.getText().toString().matches(MobilePattern)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
                }
                if(!email.getText().toString().matches(Expn)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid email id", Toast.LENGTH_SHORT).show();
                }
                if(!password.getText().toString().matches(passwordpattern)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid password", Toast.LENGTH_SHORT).show();
               }
                editor.putString(newUser,newUser);
                editor.commit();
                editor.putString(newPassword, newPassword);
                editor.commit();
                editor.putString(newPhone, newPhone);
                editor.commit();
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();
            }
        });

    }

}
