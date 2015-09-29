package com.example.android.calcv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String display = "0";
    private String result = "0";
    private int modifier = 0;
    private boolean reset = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void showDisplay() {
        TextView calcDisplay = (TextView) findViewById(R.id.display);
        calcDisplay.setText(String.valueOf(display));
    }


    public void one(View v) {
        if (!reset) {
            display += 1;
            showDisplay();
        }
        else {
            display = "1";
            showDisplay();
            reset = false;
        }
    }

    public void two(View v) {
        if (!reset) {
            display += 2;
            showDisplay();
        }
        else {
            display = "2";
            showDisplay();
            reset = false;
        }
    }

    public void three(View v) {
        if (!reset) {
            display += 3;
            showDisplay();
        }
        else {
            display = "3";
            showDisplay();
            reset = false;
        }
    }

    public void four(View v) {
        if (!reset) {
            display += 4;
            showDisplay();
        }
        else {
            display = "4";
            showDisplay();
            reset = false;
        }
    }

    public void five(View v) {
        if (!reset) {
            display += 5;
            showDisplay();
        }
        else {
            display = "5";
            showDisplay();
            reset = false;
        }
    }

    public void six(View v) {
        if (!reset) {
            display += 6;
            showDisplay();
        }
        else {
            display = "6";
            showDisplay();
            reset = false;
        }
    }

    public void seven(View v) {
        if (!reset) {
            display += 7;
            showDisplay();
        }
        else {
            display = "7";
            showDisplay();
            reset = false;
        }
    }

    public void eight(View v) {
        if (!reset) {
            display += 8;
            showDisplay();
        }
        else {
            display = "8";
            showDisplay();
            reset = false;
        }
    }

    public void nine(View v) {
        if (!reset) {
            display += 9;
            showDisplay();
        }
        else {
            display = "9";
            showDisplay();
            reset = false;
        }
    }

    public void zero(View v) {
        if (!reset) {
            display += 0;
            showDisplay();
        }
        else {
            display = "0";
            showDisplay();
            reset = false;
        }
    }

    public void decimal(View v) {
        if (!reset) {
            display += ".";
            showDisplay();
        }
        else {
            display = ".";
            showDisplay();
            reset = false;
        }
    }

    public void add(View v) {
        result = display;
        display = "0";
        modifier = 1;
        reset = true;
    }

    public void subtract(View v) {
        result = display;
        display = "0";
        modifier = 2;
        reset = true;
    }

    public void multiply(View v) {
        result = display;
        display = "0";
        modifier = 3;
        reset = true;
    }

    public void divide(View v) {
        result = display;
        display = "0";
        modifier = 4;
        reset = true;
    }

    public void clear(View v) {
        result = "0";
        display = "0";
        modifier = 0;
        reset = true;
        showDisplay();
    }

    public void equal(View v) {
        double firstParam = Double.parseDouble(result);
        double secondParam = Double.parseDouble(display);

        if (modifier == 0) {
            display = Double.toString(secondParam);
        }
        else if (modifier == 1) {
            display = Double.toString(firstParam + secondParam);
        }
        else if (modifier == 2) {
            display = Double.toString(firstParam - secondParam);
        }
        else if (modifier == 3) {
            display = Double.toString(firstParam * secondParam);
        }
        else if (modifier == 4) {
            display = Double.toString(firstParam / secondParam);
        }

        showDisplay();
        reset = true;
    }
}
