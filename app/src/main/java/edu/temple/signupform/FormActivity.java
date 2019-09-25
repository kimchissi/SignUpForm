package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSave;
        TextView theName = findViewById(R.id.EditTextName);
        TextView theEmail = findViewById(R.id.EditEmail);
        TextView thePassword1 = findViewById(R.id.EditPassword1);
        TextView thePassword2 = findViewById(R.id.EditPassword2);
        final String Name = theName.getText().toString();
        final String Email = theEmail.getText().toString();
        final String Password1 = thePassword1.getText().toString();
        final String Password2 = thePassword2.getText().toString();

        buttonSave = findViewById(R.id.ButtonSave);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (isNotEmpty(Name) == false) {
                    Toast.makeText(FormActivity.this, "Please provide a name", Toast.LENGTH_LONG).show();
                } else if (isNotEmpty(Email) == false) {
                    Toast.makeText(FormActivity.this, "Please provide an email", Toast.LENGTH_LONG).show();
                } else if (isNotEmpty(Password1) == false || passwordMatches(Password1, Password2) == false) {
                    Toast.makeText(FormActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FormActivity.this, "Welcome, " + Name, Toast.LENGTH_LONG).show();
                }

            }
        };

        buttonSave.setOnClickListener(onClickListener);


    }

    protected boolean isNotEmpty(String text) {
        if (text.length() == 0) {
            return false;
        }
        return true;
    }

    protected boolean passwordMatches(String password1, String password2) {
        if (password1.equals(password2)) {
            return true;
        }
        return false;
    }

}
