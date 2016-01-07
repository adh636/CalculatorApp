package com.example.android.calcv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String display = "0";
    private String currentNumber = "";
    private String previousNumber = "";
    private String operation = "";
    private boolean reset = true;
    private boolean equal = false;
    private boolean lastPressed = true; // ensures the last button pressed wasn't an operator
    
    public void updateNumber(String number) {
        if (!reset) {
            resetAll();
        }
        if (currentNumber.equals("") && operation.equals("")) {
            display = number;
            currentNumber = number;
            showDisplay();
        }
        else {
            display += number;
            currentNumber += number;
            showDisplay();
        }
        lastPressed = false;
    }

    public void addModifier(String modifier) {
        if (lastPressed) {
            return;
        }
        if (!previousNumber.equals("") && !equal) {
            previousNumber = Double.toString(calculateResult());
        }
        else if (previousNumber.equals("")){
            previousNumber = currentNumber;
        }
        operation = modifier;
        display += " " + operation + " ";
        currentNumber = "";
        showDisplay();
        reset = true;
        equal = false;
        lastPressed = true;
    }

    public double calculateResult() {
        if (operation.equals("+")) {
            return Double.parseDouble(previousNumber) + Double.parseDouble(currentNumber);
        }
        else if (operation.equals("-")) {
            return Double.parseDouble(previousNumber) - Double.parseDouble(currentNumber);
        }
        else if (operation.equals("*")) {
            return Double.parseDouble(previousNumber) * Double.parseDouble(currentNumber);
        }
        else if (operation.equals("/")) {
            return Double.parseDouble(previousNumber) / Double.parseDouble(currentNumber);
        }
        else {
            return Double.parseDouble(currentNumber);
        }
    }

    public void resetAll() {
        display = "0";
        currentNumber = "";
        previousNumber = "";
        operation = "";
        reset = true;
        equal = false;
        lastPressed = true;
    }

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
    
    public void equal(View v) {
        display += " = " + calculateResult();
        previousNumber = Double.toString(calculateResult());
        reset = false;
        equal = true;
        int length = display.length();
        if (display.substring(length - 2, length).equals(".0")) {
            display = display.substring(0, length - 2);
        }
        showDisplay();
    }

    public void one(View v) {
        updateNumber("1");
    }

    public void two(View v) {
        updateNumber("2");
    }

    public void three(View v) {
        updateNumber("3");
    }

    public void four(View v) {
        updateNumber("4");
    }

    public void five(View v) {
        updateNumber("5");
    }

    public void six(View v) {
        updateNumber("6");
    }

    public void seven(View v) {
        updateNumber("7");
    }

    public void eight(View v) {
        updateNumber("8");
    }

    public void nine(View v) {
        updateNumber("9");
    }

    public void zero(View v) {
        updateNumber("0");
    }

    public void decimal(View v) {
        updateNumber(".");
    }

    public void add(View v) {
        addModifier("+");
    }

    public void subtract(View v) {
        addModifier("-");
    }

    public void multiply(View v) {
        addModifier("*");
    }

    public void divide(View v) {
        addModifier("/");
    }

    public void clear(View v) {
        resetAll();
        showDisplay();
    }
}