package com.example.huma.binaryConvector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    Spinner fromSpinner, toSpinner;
    Button convertButton;
    EditText inputEditText;
    TextView resultTextView, hiddenTextView;
    ImageView infoImageView;
    String Input, Result, From, To, System;
    Converter mConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Toast.makeText(this, "Welcome toSpinner my app", Toast.LENGTH_SHORT).show();

        //clarify the layout elements
        fromSpinner = (Spinner) findViewById(R.id.from_spinner);
        toSpinner = (Spinner) findViewById(R.id.to_spinner);
        convertButton = (Button) findViewById(R.id.convert_button);
        inputEditText = (EditText) findViewById(R.id.input_editText);
        resultTextView = (TextView) findViewById(R.id.result_textView);
        hiddenTextView = (TextView) findViewById(R.id.hidden_textView);
        infoImageView = (ImageView) findViewById(R.id.info_imageView);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.MainLayout);
        final ColorWheal mColorWheal = new ColorWheal();


        // Create an ArrayAdapter using the string array from strings.xml and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.systems, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        //if the user choose to convert from hex then change input type to allow him to inter litters
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                From = String.valueOf(position);

                //if choose Hex change the inputEditText to string
                if (position == 3) {
                    inputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    inputEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                To = String.valueOf(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //convert :)
        /**
         *1-bin >> dec 0-1
         *2-bin >> oct 0-2
         *3-bin >> hex 0-3
         *
         *4-dec >> bin 1-0
         *5-dec >> oct 1-2
         *6-dec >> hex 1-3
         *
         *7-oct >> bin 2-0
         *8-oct >> dec 2-1
         *9-oct >> hex 2-3
         *
         *10-hex >> bin 3-0
         *11-hex >> dec 3-1
         *12-hex >> oct 3-2
         */
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changing background and button text color
                int colorInt = mColorWheal.getColor();
                relativeLayout.setBackgroundColor(colorInt);
                convertButton.setTextColor(colorInt);
                //choosing the system
                mConverter = new Converter();
                System = From + To;
                Input = inputEditText.getText().toString();

                //toggle to find the system and make sure that the input is not null
                if (Input.isEmpty()) {
                    new AlertDialog.Builder(MyActivity.this)
                            .setPositiveButton(android.R.string.ok, null)
                            .setTitle("Ooops!")
                            .setMessage("Please enter number first").show();
                } else if (System.equals("01")) {
                    Result = mConverter.ConvertBinToDec(Input);

                } else if (System.equals("02")) {
                    Result = mConverter.ConvertBinToOct(Input);

                } else if (System.equals("03")) {
                    Result = mConverter.ConvertBinToHex(Input);

                } else if (System.equals("10")) {
                    Result = mConverter.ConvertDecToBin(Integer.parseInt(Input));

                } else if (System.equals("12")) {
                    Result = mConverter.ConvertDecToOct(Integer.parseInt(Input));

                } else if (System.equals("13")) {
                    Result = mConverter.ConvertDecToHex(Integer.parseInt(Input));

                } else if (System.equals("20")) {
                    Result = mConverter.ConvertOctToBin(Input);

                } else if (System.equals("21")) {
                    Result = mConverter.ConvertOctToDec(Input);

                } else if (System.equals("23")) {
                    Result = mConverter.ConvertOctToHex(Input);

                } else if (System.equals("30")) {
                    Result = mConverter.ConvertHexToBin(Input);

                } else if (System.equals("31")) {
                    Result = mConverter.ConvertHexToDec(Input);

                } else if (System.equals("32")) {
                    Result = mConverter.ConvertHexToOct(Input);

                }

                //display the result
                resultTextView.setText(Result);
            }
        });

        //just for fun
        hiddenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hiddenTextView.setText("Ibrahim Eid");
            }
        });

        infoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, Info.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_info) {
            startActivity(new Intent(MyActivity.this, Info.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
