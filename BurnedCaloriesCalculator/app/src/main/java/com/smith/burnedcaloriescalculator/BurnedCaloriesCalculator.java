package com.smith.burnedcaloriescalculator;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static android.content.SharedPreferences.*;

public class BurnedCaloriesCalculator extends AppCompatActivity
implements OnEditorActionListener, OnClickListener, OnItemSelectedListener {

    private EditText weightEditText;
    private SeekBar milesRanSeekBar;
    private TextView caloriesBurnedTextView;
    private Spinner ftSpinner, inSpinner;
    private TextView bmiTextView;
    private EditText nameEditText;
    private TextView milesRanSeekBarAmount;
    private SharedPreferences savedValues;

    //instance variables
    int progress = 1;
    String weightAmountString = "";
    String ftAmountString = "";
    String inAmountString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burned_calories_calculator);

        //get references to the widgets
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        milesRanSeekBar = (SeekBar) findViewById(R.id.milesRanSeekBar);
        caloriesBurnedTextView = (TextView) findViewById(R.id.caloriesBurnedTextView);
        ftSpinner = (Spinner) findViewById(R.id.ftSpinner);
        inSpinner = (Spinner) findViewById(R.id.inSpinner);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        milesRanSeekBarAmount = (TextView) findViewById(R.id.milesRanSeekBarAmount);

        //listeners
        weightEditText.setOnEditorActionListener(this);
        milesRanSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started Tracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                milesRanSeekBarAmount.setText( progress + "miles");
            }
        });
        nameEditText.setOnEditorActionListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.height_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ftSpinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterIn = ArrayAdapter.createFromResource(this, R.array.inch_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inSpinner.setAdapter(adapterIn);



    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_UNSPECIFIED ||
                actionId == EditorInfo.IME_ACTION_DONE){
            calculateAndDisplay();
        }
        return false;
    }

    private void calculateAndDisplay() {
        weightAmountString = weightEditText.getText().toString();
        ftAmountString = ftSpinner.getSelectedItem().toString();
        inAmountString = inSpinner.getSelectedItem().toString();

        float weightAmount;
        int ftAmount = Integer.parseInt(ftAmountString);
        int inAmount = Integer.parseInt(inAmountString);

        if(weightAmountString.equals("")){
            weightAmount = 0;
        }
        else{
            weightAmount = Float.parseFloat(weightAmountString);
        }

        float caloriesBurnedAmount = (float) (.75 * weightAmount * progress);
        DecimalFormat dc = new DecimalFormat("#.##");
        caloriesBurnedTextView.setText(dc.format(caloriesBurnedAmount));
        DecimalFormat nc = new DecimalFormat("#");
        Float bmiAmount = (weightAmount * 703)/((12*ftAmount) + inAmount);
        bmiTextView.setText(nc.format(bmiAmount));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onPause() {
        //changes for git
        Editor editor = savedValues.edit();
        editor.putString("weightAmountString", weightAmountString);
        editor.putInt("progress", progress);
        editor.putString("ftSpinner", ftAmountString);
        editor.putString("inSpinner", inAmountString);

        super.onPause();
    }
}
