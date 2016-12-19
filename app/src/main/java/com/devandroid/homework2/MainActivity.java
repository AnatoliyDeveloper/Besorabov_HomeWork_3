package com.devandroid.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button appButton = (Button) findViewById(R.id.app_btn);
        ImageButton callButton = (ImageButton) findViewById(R.id.call_btn);
        ImageButton smsButton = (ImageButton) findViewById(R.id.sms_btn);

        appButton.setOnClickListener(this);
        callButton.setOnClickListener(this);
        smsButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.app_btn:
                intent = callAppActivity();
                break;
            case R.id.call_btn:
                intent = callDialApp();
                break;
            case R.id.sms_btn:
                intent = callSmsApp();
                break;
        }
        startActivity(intent);
    }

    @NonNull
    private Intent callSmsApp() {
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        return intent;
    }

    @NonNull
    private Intent callDialApp() {
        Intent intent;
        intent = new Intent(Intent.ACTION_DIAL);
        return intent;
    }

    @NonNull
    private Intent callAppActivity() {
        Intent intent;
        intent = new Intent(this, AppActivity.class);
        return intent;
    }
}
