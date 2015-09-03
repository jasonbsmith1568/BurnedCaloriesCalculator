package com.mm214.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Defining onclick listener for finding the result
        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                Spinner spr = (Spinner) findViewById(R.id.sprOperator);
                EditText edtNumber1 = ( EditText) findViewById(R.id.edtNumber1);
                EditText edtNumber2 = ( EditText) findViewById(R.id.edtNumber2);
                EditText edtResult = ( EditText) findViewById(R.id.edtResult);

                String selectedItem = (String) spr.getSelectedItem();


                if(selectedItem.trim().equals("+")){
                    float result = Float.parseFloat(edtNumber1.getText().toString())  + Float.parseFloat(edtNumber2.getText().toString());
                    edtResult.setText(Float.toString(result));
                }else if(selectedItem.trim().equals("-")){
                    float result = Float.parseFloat(edtNumber1.getText().toString())  - Float.parseFloat(edtNumber2.getText().toString());
                    edtResult.setText(Float.toString(result));
                }else if(selectedItem.trim().equals("x")){
                    float result = Float.parseFloat(edtNumber1.getText().toString())  * Float.parseFloat(edtNumber2.getText().toString());
                    edtResult.setText(Float.toString(result));
                }else if(selectedItem.trim().equals("/")){
                    float result = Float.parseFloat(edtNumber1.getText().toString())  / Float.parseFloat(edtNumber2.getText().toString());
                    edtResult.setText(Float.toString(result));
                }


            }
        };


        // Getting reference of the button btnResult
        Button btn = (Button) findViewById(R.id.btnResult);

        // Setting onclick listener
        btn.setOnClickListener(listener);


    }
}