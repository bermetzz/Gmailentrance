package com.example.gmailentrance;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button btnClick;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = findViewById(R.id.btn_send);
        editTextTo = findViewById(R.id.edit_text);
        editTextSubject = findViewById(R.id.edit_text1);
        editTextMessage = findViewById(R.id.edit_text2);
    }


    public void onButtonClick(View view) {
        String to=editTextTo.getText().toString();
        String subject=editTextSubject.getText().toString();
        String message=editTextMessage.getText().toString();
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

    }
}