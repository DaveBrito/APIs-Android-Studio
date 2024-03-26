package com.example.tempo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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
        etCity = findViewById(R.id.etCity);
        etCountry = findViewById(R.id.etCountry);
        tvResult = findViewById(R.id.tvResult);

    }

    public void getWeatherDetails(View view) {

     String tempurl = "";
     String city = etCity.getText().toString().trim();
     String country = etCountry.getText().toString().trim();
     if (city.equals("")){
         tvResult.setText("Cidade não encontrada");
     } else{
         if (!country.equals("")){
             tempurl = url + "?q=" + city + "," + country + "&appid" + appid;
         } else{
             tempurl = url + "?q=" + city + "&appid" + appid;
         }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, tempurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), volleyError.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });
     }


    }
}