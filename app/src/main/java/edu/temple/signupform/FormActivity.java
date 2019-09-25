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
        final TextView theName = findViewById(R.id.EditTextName);
        final TextView theEmail = findViewById(R.id.EditEmail);
        final TextView thePassword1 = findViewById(R.id.EditPassword1);
        final TextView thePassword2 = findViewById(R.id.EditPassword2);
        // apparently you can't put the text into a variable like this
        //final String Name = theName.getText().toString();
        //final String Email = theEmail.getText().toString();
        //final String Password1 = thePassword1.getText().toString();
        //final String Password2 = thePassword2.getText().toString();

        buttonSave = findViewById(R.id.ButtonSave);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //Toast.makeText(FormActivity.this, "hello, " + theName.getText().toString(), Toast.LENGTH_LONG).show();
                if (isNotEmpty(theName.getText().toString()) == false) {
                    Toast.makeText(FormActivity.this, "Please provide a name", Toast.LENGTH_LONG).show();
                } else if (isNotEmpty(theEmail.getText().toString()) == false) {
                    Toast.makeText(FormActivity.this, "Please provide an email", Toast.LENGTH_LONG).show();
                } else if (isNotEmpty(thePassword1.getText().toString()) == false || passwordMatches(thePassword1.getText().toString(), thePassword2.getText().toString()) == false) {
                    Toast.makeText(FormActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FormActivity.this, "Welcome, " + theName.getText().toString(), Toast.LENGTH_LONG).show();
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
