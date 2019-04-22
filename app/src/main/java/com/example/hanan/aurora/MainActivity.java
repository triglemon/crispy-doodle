package com.example.hanan.aurora;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();
    }

    void Login(){
        final Button login = (Button) findViewById(R.id.login);
        final EditText userName = (EditText) findViewById(R.id.username);
        final EditText passWord = (EditText) findViewById(R.id.password);
        final TextView welcome = (TextView) findViewById(R.id.welcome);
        Thread t=new Thread(){


            @Override
            public void run(){

                while(!isInterrupted()){

                    try {
                        Thread.sleep(100);

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                welcome.setText("Welcome " + userName.getText().toString());
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        t.start();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("Aurora") &&
                        passWord.getText().toString().equals("1234"))   {
                    Intent intent = new Intent();
                    startActivity(intent);
                }
                else{
                    PasswordFailed();
                }
            }
        });
    }

    void PasswordFailed(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Username and Password Failed");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }







    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

