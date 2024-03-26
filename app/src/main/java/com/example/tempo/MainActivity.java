package com.example.tempo;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText etCity, etCountry;
    TextView tvResult;
    private final String url ="https://api.openweathermap.org/data/2.5/weather?q=saopaulo&appid=e5c03f5af0ce29e8b1c268620a8d55a6";
    private final String appid = "e5c03f5af0ce29e8b1c268620a8d55a6";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    public void getWeatherDetails(View view) {
    }
}