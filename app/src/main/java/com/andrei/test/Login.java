 package com.andrei.test;

 import android.content.Intent;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;

 import androidx.appcompat.app.AppCompatActivity;

 public class Login extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.login);


         Button login = findViewById(R.id.signin);
         Button registro = findViewById(R.id.register);
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Login.this, HomeActivity.class);
                  startActivity(intent);
             }
         });

         registro.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Login.this, RegisterActivity.class);
                 startActivity(intent);
             }
         });
     }

 }
