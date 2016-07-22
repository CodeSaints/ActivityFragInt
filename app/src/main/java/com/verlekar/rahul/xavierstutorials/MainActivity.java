package com.verlekar.rahul.xavierstutorials;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowProgress = (Button) findViewById(R.id.btn_show_progress);
        btnShowProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfiniteProgress();
            }
        });
        Button btnGotoNewActivity = (Button) findViewById(R.id.btn_goto_new_activity);
        btnGotoNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNewActivity();
            }
        });
        Button btnGotoNewActivityMessage = (Button) findViewById(R.id.btn_goto_new_activity_value);
        btnGotoNewActivityMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateWithMessage();
            }
        });

    }

    ProgressDialog progressDialog;
    void showInfiniteProgress()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("We are working on something");
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(true); //This will dismiss on touch
        progressDialog.show(); //Dialog wont be shown until this command
    }

    void navigateToNewActivity()
    {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);//This command will cause the navigation
    }

    void navigateWithMessage()
    {
        String message = "This is a secret message";
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("SECRET", message); //Save contents of message with KEY as SECRET
        startActivity(intent);//This command will cause the navigation
    }
}
