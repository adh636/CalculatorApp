package com.example.android.calcv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String display = "0";
    private String currentNumber = "";
    private String previousNumber = "";
    private String operation = "";
    private boolean reset = true;
    private boolean equal = false;
    private boolean lastPressed = true; // tells you if last button pressed was an operator

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

    // executes whenever a number or decimal point is pressed
    public void updateNumber(String number) {

        // if last button pressed was "=", resets before updating number
        if (!reset) {
            resetAll();
        }

        //  displays and stores first number if variables have been reset or app just loaded
        if (currentNumber.equals("") && operation.equals("")) {
            display = number;
            currentNumber = number;
            showDisplay();
        }

        // appends number to display and current number
        else {
            display += number;
            currentNumber += number;
            showDisplay();
        }

        // allows an operator to be used
        lastPressed = false;
    }

    // executes whenever a modifier is pressed (+, -, *, /)
    public void addModifier(String modifier) {

        // do nothing if a number or equal wasn't last button pressed
        if (lastPressed) {
            return;
        }
        
        // if previousNumber is not empty and equal wasn't last button pressed, 
        // calculator result and update previousNumber
        if (!previousNumber.equals("") && !equal) {
            previousNumber = Double.toString(calculateResult());
        }
        
        // if previousNumber is not empty and equal was pressed last,
        // store currentNumber in previousNumber
        else if (previousNumber.equals("")){
            previousNumber = currentNumber;
        }
        
        
        operation = modifier; // update operation with modifier
        display += " " + operation + " "; // update display with modifier
        currentNumber = ""; // clear currentNumber
        reset = true; // keeps display from resetting
        equal = false; // stores that equal was not last button pressed
        lastPressed = true; // stores last pressed as operator
        showDisplay();
    }
    
    // return solution based on which operator was pressed last
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
    
    // set all variables to default values
    public void resetAll() {
        display = "0";
        currentNumber = "";
        previousNumber = "";
        operation = "";
        reset = true;
        equal = false;
        lastPressed = true;
    }
    
    // display text on app screen
    public void showDisplay() {
        TextView calcDisplay = (TextView) findViewById(R.id.display);
        ScrollView scrollDisplay = (ScrollView) findViewById(R.id.scroller);
        calcDisplay.setText(String.valueOf(display)); // set text in TextView to content stored in display
        scrollDisplay.fullScroll(View.FOCUS_DOWN); // scroll the view to the bottom
    }

    // executes when equal button is pressed
    public void equal(View v) {

        // do nothing if a number or equal wasn't last button pressed
        if (lastPressed) {
            return;
        }
        
        display += " = " + calculateResult(); // update display with equal sign and result
        previousNumber = Double.toString(calculateResult()); // update previousNumber
        reset = false; // if a number is pressed next, variable are reset
        equal = true; // stores that equal was last button pressed
        int length = display.length();
        
        // if calculateResult() returned ".0" at the end, remove from display
        if (display.substring(length - 2, length).equals(".0")) {
            display = display.substring(0, length - 2);
        }
        
        showDisplay();
    }
    
    // reset variables and display
    public void clear(View v) {
        resetAll();
        showDisplay();
    }

    // implementation not yet correct (not updating display)
    /*
    public void plusMinus(View v) {
        if(currentNumber.substring(0, 1).equals("-")) {
            currentNumber = currentNumber.substring(1);
        }
        else {
            currentNumber = "-" + currentNumber;
        }
    }
    */

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
}