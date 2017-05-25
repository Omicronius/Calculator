package com.example.androiddev.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androiddev.calculator.util.Calculator;
import com.example.androiddev.calculator.util.Operations;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView display;
    private String value1;
    private String value2;
    private Operations operation;
    private Calculator calculator;
    private boolean inputFinished;

    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button zeroButton;

    Button additionButton;
    Button subtractionButton;
    Button multiplicationButton;
    Button divisionButton;
    Button sqrtButton;
    Button xPow2Button;
    Button xPowYButton;
    Button dotButton;
    Button resultButton;
    Button resetButton;


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
            registerSimpleComponents();
        } else {
            setContentView(R.layout.activity_main_landscape);
            registerSimpleComponents();
            registerEngeneeringComponents();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerSimpleComponents();
    }

    private void registerSimpleComponents() {
        calculator = new Calculator();

        oneButton = (Button) findViewById(R.id.button_1);
        twoButton = (Button) findViewById(R.id.button_2);
        threeButton = (Button) findViewById(R.id.button_3);
        fourButton = (Button) findViewById(R.id.button_4);
        fiveButton = (Button) findViewById(R.id.button_5);
        sixButton = (Button) findViewById(R.id.button_6);
        sevenButton = (Button) findViewById(R.id.button_7);
        eightButton = (Button) findViewById(R.id.button_8);
        nineButton = (Button) findViewById(R.id.button_9);
        zeroButton = (Button) findViewById(R.id.button_0);
        dotButton = (Button) findViewById(R.id.dotButton);

        additionButton = (Button) findViewById(R.id.plusButton);
        subtractionButton = (Button) findViewById(R.id.minusButton);
        multiplicationButton = (Button) findViewById(R.id.multiplicationButton);
        divisionButton = (Button) findViewById(R.id.divisionButton);
        resultButton = (Button) findViewById(R.id.resultButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        display = (TextView) findViewById(R.id.display);

        display.setText("");

        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
        additionButton.setOnClickListener(this);
        subtractionButton.setOnClickListener(this);
        multiplicationButton.setOnClickListener(this);
        divisionButton.setOnClickListener(this);
        resultButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }

    private void registerEngeneeringComponents() {
        sqrtButton = (Button) findViewById(R.id.sqrtButton);
        xPow2Button = (Button) findViewById(R.id.xPow2Button);
        xPowYButton = (Button) findViewById(R.id.xPowYButton);
        dotButton = (Button) findViewById(R.id.dotButton);

        sqrtButton.setOnClickListener(this);
        xPow2Button.setOnClickListener(this);
        xPowYButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_1:
                if (inputFinished) {
                    display.setText("1");
                    inputFinished = false;
                } else {
                    display.append("1");
                }
                break;
            case R.id.button_2:
                if (inputFinished) {
                    display.setText("2");
                    inputFinished = false;
                } else {
                    display.append("2");
                }
                break;
            case R.id.button_3:
                if (inputFinished) {
                    display.setText("3");
                    inputFinished = false;
                } else {
                    display.append("3");
                }
                break;
            case R.id.button_4:
                if (inputFinished) {
                    display.setText("4");
                    inputFinished = false;
                } else {
                    display.append("4");
                }
                break;
            case R.id.button_5:
                if (inputFinished) {
                    display.setText("5");
                    inputFinished = false;
                } else {
                    display.append("5");
                }
                break;
            case R.id.button_6:
                if (inputFinished) {
                    display.setText("6");
                    inputFinished = false;
                } else {
                    display.append("6");
                }
                break;
            case R.id.button_7:
                if (inputFinished) {
                    display.setText("7");
                    inputFinished = false;
                } else {
                    display.append("7");
                }
                break;
            case R.id.button_8:
                if (inputFinished) {
                    display.setText("8");
                    inputFinished = false;
                } else {
                    display.append("8");
                }
                break;
            case R.id.button_9:
                if (inputFinished) {
                    display.setText("9");
                    inputFinished = false;
                } else {
                    display.append("9");
                }
                break;
            case R.id.button_0:
                if (inputFinished) {
                    display.setText("");
                } else if (!getDisplayText().equals("")) {
                    display.append("0");
                }
                break;
            case R.id.dotButton:
                if (inputFinished) {
                    display.setText("0.");
                    inputFinished = false;
                }
                if (getDisplayText().indexOf(".") == -1) {
                    if (getDisplayText().length() == 0) {
                        display.append("0.");
                    } else {
                        display.append(".");
                    }
                }
                break;
            case R.id.resetButton:
                display.setText("");
                break;
            case R.id.plusButton:
                operation = Operations.ADD;
                inputFinished = true;
                value1 = getDisplayText();
                break;
            case R.id.minusButton:
                operation = Operations.SUBTRACT;
                inputFinished = true;
                value1 = getDisplayText();
                break;
            case R.id.multiplicationButton:
                operation = Operations.MULTIPLY;
                inputFinished = true;
                value1 = getDisplayText();
                break;
            case R.id.divisionButton:
                operation = Operations.DIVIDE;
                inputFinished = true;
                value1 = getDisplayText();
                break;
            case R.id.sqrtButton:
                operation = Operations.SQRT;
                inputFinished = true;
                value1 = getDisplayText();
                display.setText(calculator.calculate(value1, operation));
                break;
            case R.id.xPow2Button:
                operation = Operations.POW_2;
                inputFinished = true;
                value1 = getDisplayText();
                display.setText(calculator.calculate(value1, operation));
                break;
            case R.id.xPowYButton:
                operation = Operations.POW_Y;
                inputFinished = true;
                value1 = getDisplayText();
                break;
            case R.id.resultButton:
                inputFinished = true;
                value2 = getDisplayText();
                display.setText(calculator.calculate(value1, value2, operation));
                break;
            default:
                break;
        }
    }

    private String getDisplayText() {
        return display.getText().toString();
    }
}

