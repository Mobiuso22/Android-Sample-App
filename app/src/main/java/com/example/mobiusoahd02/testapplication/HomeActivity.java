package com.example.mobiusoahd02.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Context;

public class HomeActivity extends AppCompatActivity {
    final Context context = this;
    private Button mExitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        Button start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startNotification();
            }
        });

        Button stop = (Button) findViewById(R.id.stop);

        stop.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Stop(v);
            }
        });

        mExitBtn = (Button) findViewById(R.id.exit);

        mExitBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showExitDialog();
            }
        });
    }

    private void showExitDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        alertDialogBuilder.setTitle((getResources().getString(R.string.exit_dialog_title)));

        alertDialogBuilder
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        HomeActivity.this.finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void startNotification() {
        this.startService(new Intent(HomeActivity.this, Notification_Service.class));
    }

    public void Stop(View v) {
        this.stopService(new Intent(HomeActivity.this, Notification_Service.class));

    }


}