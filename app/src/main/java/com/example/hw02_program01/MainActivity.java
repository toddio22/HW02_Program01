package com.example.hw02_program01;
//Name: Todd Sachs
//Date: 11-7-2026
//Desc: RGB Selection App
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    //gui variables
    ConstraintLayout main;
    Button btn_j_saveColor;
    TextView tv_j_hex;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    ListView lv_j_savedColors;

    //arraylist
    private ArrayList<ColorInfo> listOfColors;


    //color variables
    private int redValue = 0;
    private int greenValue = 0;
    private int blueValue = 0;
    String redHex = "00";
    String greenHex = "00";
    String blueHex = "00";
    String currentHex = (redHex + greenHex + blueHex);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Connect to GUI
        main = findViewById(R.id.main);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        tv_j_hex = findViewById(R.id.tv_v_hex);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        lv_j_savedColors = findViewById(R.id.lv_v_savedColors);

        //initial array
        listOfColors = new ArrayList<ColorInfo>();

        //initial display
        tv_j_red.setText("Red: 0");
        tv_j_green.setText("Green: 0");
        tv_j_blue.setText("Blue: 0");
        tv_j_hex.setText("Hex Representation: " + currentHex);

        //Event Functions
        redChangeEvent();
        greenChangeEvent();
        blueChangeEvent();
        saveButtonClickEvent();

    }

    private void redChangeEvent()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //Log.d("Red:", "Red: " + progress);
                tv_j_red.setText("Red: " + progress);
                redValue = progress;
                //Log.d("Red Value:", "Red Value: " + redValue);
                redHex = String.format("%02X", redValue);
                //Log.d("Red Hex:", "Red Hex: " + redHex);
                currentHex = (redHex + greenHex + blueHex);
                tv_j_hex.setText("Hex Representation: " + currentHex);
                main.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void greenChangeEvent()
    {
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //Log.d("Green:", "Green: " + progress);
                tv_j_green.setText("Green: " + progress);
                greenValue = progress;
                //Log.d("Green Value:", "Green Value: " + greenValue);
                greenHex = String.format("%02X", greenValue);
                //Log.d("Green Hex:", "Green Hex: " + greenHex);
                currentHex = (redHex + greenHex + blueHex);
                tv_j_hex.setText("Hex Representation: " + currentHex);
                main.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void blueChangeEvent()
    {
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //Log.d("Blue:", "Blue: " + progress);
                tv_j_blue.setText("Blue: " + progress);
                blueValue = progress;
                //Log.d("Blue Value:", "Blue Value: " + blueValue);
                blueHex = String.format("%02X", blueValue);
                //Log.d("Blue Hex:", "Blue Hex: " + blueHex);
                currentHex = (redHex + greenHex + blueHex);
                tv_j_hex.setText("Hex Representation: " + currentHex);
                main.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void saveButtonClickEvent()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //creates saved color object
                ColorInfo ci = new ColorInfo(redValue, greenValue, blueValue, currentHex);

                //add it to the list
                listOfColors.add(ci);
                Log.d("List Size:", "List Size: " + listOfColors.size());


            }
        });
    }
}