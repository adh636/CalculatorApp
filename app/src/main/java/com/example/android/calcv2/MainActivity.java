package com.example.android.calcv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String display = "0";
    private String nextNumber = "";
    private double firstParam = 0;
    private double currentResult = 0;
    private double result = 0;
    private int modifier = 0; // 1 is +, 2 is -, 3 is *, 4 is /
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
        if (!reset || modifier != 0) {
            display += 1;
            nextNumber += "1";
            showDisplay();
        }
        else {
            display = "1";
            nextNumber = "1";
            showDisplay();
            reset = false;
        }
    }

    public void two(View v) {
        if (!reset || modifier != 0) {
            display += 2;
            nextNumber += "2";
            showDisplay();
        }
        else {
            display = "2";
            nextNumber = "2";
            showDisplay();
            reset = false;
        }
    }

    public void three(View v) {
        if (!reset || modifier != 0) {
            display += 3;
            nextNumber += "3";
            showDisplay();
        }
        else {
            display = "3";
            nextNumber = "3";
            showDisplay();
            reset = false;
        }
    }

    public void four(View v) {
        if (!reset || modifier != 0) {
            display += 4;
            nextNumber += "4";
            showDisplay();
        }
        else {
            display = "4";
            nextNumber = "4";
            showDisplay();
            reset = false;
        }
    }

    public void five(View v) {
        if (!reset || modifier != 0) {
            display += 5;
            nextNumber += "5";
            showDisplay();
        }
        else {
            display = "5";
            nextNumber = "5";
            showDisplay();
            reset = false;
        }
    }

    public void six(View v) {
        if (!reset || modifier != 0) {
            display += 6;
            nextNumber += "6";
            showDisplay();
        }
        else {
            display = "6";
            nextNumber = "6";
            showDisplay();
            reset = false;
        }
    }

    public void seven(View v) {
        if (!reset || modifier != 0) {
            display += 7;
            nextNumber += "7";
            showDisplay();
        }
        else {
            display = "7";
            nextNumber = "7";
            showDisplay();
            reset = false;
        }
    }

    public void eight(View v) {
        if (!reset || modifier != 0) {
            display += 8;
            nextNumber += "8";
            showDisplay();
        }
        else {
            display = "8";
            nextNumber = "8";
            showDisplay();
            reset = false;
        }
    }

    public void nine(View v) {
        if (!reset || modifier != 0) {
            display += 9;
            nextNumber += "9";
            showDisplay();
        }
        else {
            display = "9";
            nextNumber = "9";
            showDisplay();
            reset = false;
        }
    }

    public void zero(View v) {
        if (!reset || modifier != 0) {
            display += 0;
            nextNumber += "0";
            showDisplay();
        }
        else {
            display = "0";
            nextNumber = "0";
            showDisplay();
            reset = false;
        }
    }

    public void decimal(View v) {
        if (!reset || modifier != 0) {
            display += ".";
            nextNumber += ".";
            showDisplay();
        }
        else {
            display = "0.";
            nextNumber = "0.";
            showDisplay();
            reset = false;
        }
    }

    public void add(View v) {
        currentResult = Double.parseDouble(nextNumber);
        if (firstParam != 0) {
            firstParam = currentResult;
        }
        else {
            firstParam = updateFirstParam(currentResult);
        }
        display += " + ";
        modifier = 1;
        reset = true;
        showDisplay();
        nextNumber = "";
    }

    public void subtract(View v) {
        currentResult = Double.parseDouble(nextNumber);
        if (firstParam != 0) {
            firstParam = currentResult;
        }
        else {
            firstParam = updateFirstParam(currentResult);
        }
        display = "0";
        modifier = 2;
        reset = true;
        showDisplay();
        nextNumber = "";
    }

    public void multiply(View v) {
        currentResult = Double.parseDouble(nextNumber);
        if (firstParam != 0) {
            firstParam = currentResult;
        }
        else {
            firstParam = updateFirstParam(currentResult);
        }
        display = "0";
        modifier = 3;
        reset = true;
        showDisplay();
        nextNumber = "";

    }

    public void divide(View v) {
        currentResult = Double.parseDouble(nextNumber);
        if (firstParam != 0) {
            firstParam = currentResult;
        }
        else {
            firstParam = updateFirstParam(currentResult);
        }
        display = "0";
        modifier = 4;
        reset = true;
        showDisplay();
        nextNumber = "";
    }

    public void clear(View v) {
        result = 0;
        display = "0";
        modifier = 0;
        reset = true;
        showDisplay();
        nextNumber = "";
        firstParam = 0;
    }

    public void equal(View v) {
        double secondParam = Double.parseDouble(nextNumber);

        if (modifier == 0) {
            display +=  " = " + nextNumber;
        }
        else if (modifier == 1) {
            display += " = " + Double.toString(firstParam + secondParam);
        }
        else if (modifier == 2) {
            display += " = " + Double.toString(firstParam - secondParam);
        }
        else if (modifier == 3) {
            display += " = " + Double.toString(firstParam * secondParam);
        }
        else if (modifier == 4) {
            display += " = " + Double.toString(firstParam / secondParam);
        }

        showDisplay();
        reset = true;
    }

    /*
    public String updateDisplay(int current) {
        if (modifier == 1) {
            return " + " + current;
        }
        else if (modifier == 2) {
            return " - " + current;
        }
        else if (modifier == 3) {
            return " * " + current;
        }
        else if (modifier == 4) {
            return " / " + current;
        }
        return Double.toString(current);
    }
    */

    public double updateFirstParam(double current) {
        if (modifier == 1) {
            return firstParam + current;
        }
        else if (modifier == 2) {
            return firstParam - current;
        }
        else if (modifier == 3) {
            return firstParam * current;
        }
        else if (modifier == 4) {
            return firstParam / current;
        }
        return current;
    }
}