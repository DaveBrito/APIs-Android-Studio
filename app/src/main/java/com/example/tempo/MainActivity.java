package com.example.tempo;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Declarando as variáveis ​​de classe
    EditText etCity, etCountry; // Campos de entrada de texto para cidade e país
    TextView tvResult; // Campo de texto para exibir os resultados

    // Coordenadas geográficas padrão (São Paulo, Brasil)
    double latitude = -23.5475;
    double longitude = -46.6361;

    // Número de previsões meteorológicas a serem recuperadas
    int numberOfForecasts = 5;

    // URL da API do OpenWeatherMap
    String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&cnt=" + numberOfForecasts + "&appid=a2ffacee9f355be08ed01d8ab9322df9";

    // Chave de acesso à API do OpenWeatherMap
    private final String appid = "a2ffacee9f355be08ed01d8ab9322df9";

    // Formato decimal para formatar os valores numéricos
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos campos de entrada e saída de texto
        etCountry = findViewById(R.id.etCountry); // Campo de entrada de texto para o país
        tvResult = findViewById(R.id.tvResult); // Campo de texto para exibir os resultados
    }

    // Método chamado quando o botão é clicado para obter os detalhes do clima
    public void getWeatherDetails(View view) {
        String tempurl = ""; // Variável para armazenar a URL da solicitação
        String country = etCountry.getText().toString().trim(); // Obtendo o nome do país do campo de entrada

        // Verificando se o campo de entrada do país está vazio
        if (TextUtils.isEmpty(country)) {
            // Se estiver vazio, exibir uma mensagem de erro na TextView de resultados
            tvResult.setText("Por favor, insira o nome do país");
        } else {
            // Se não estiver vazio, construir a URL da solicitação com base no país fornecido
            tempurl = url + "&q=" + country + "&appid=" + appid;

            // Criando uma solicitação de string usando Volley
            StringRequest stringRequest = new StringRequest(Request.Method.GET, tempurl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Método chamado quando a resposta da solicitação é recebida com sucesso

                    // Variável para armazenar a saída a ser exibida na TextView de resultados
                    String output = "";

                    try {
                        JSONObject jsonResponse = new JSONObject(response);

                        // Verificando se a resposta indica que o país ou estado não foi encontrado
                        if (jsonResponse.has("message") && jsonResponse.getString("message").equals("city not found")) {
                            // Se o país ou estado não for encontrado, exibir uma mensagem de erro na TextView de resultados
                            tvResult.setText("País ou estado não encontrado");
                        } else {
                            // Obtendo a matriz de informações sobre o clima da resposta
                            JSONArray jsonArray = jsonResponse.getJSONArray("weather");

                            // Obtendo o primeiro objeto de informações sobre o clima
                            JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);

                            // Obtendo a descrição do clima
                            String description = jsonObjectWeather.getString("description");

                            // Obtendo o objeto de informações principais sobre o clima
                            JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");

                            // Obtendo a temperatura e ajustando de Kelvin para Celsius
                            double temp = jsonObjectMain.getDouble("temp") - 273.15;

                            // Obtendo a sensação térmica e ajustando de Kelvin para Celsius
                            double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;

                            // Obtendo a pressão atmosférica
                            float pressure = jsonObjectMain.getInt("pressure");

                            // Obtendo a umidade relativa do ar
                            int humidity = jsonObjectMain.getInt("humidity");

                            // Obtendo informações sobre o vento
                            JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                            String wind = jsonObjectWind.getString("speed");

                            // Obtendo informações sobre a nebulosidade
                            JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                            String clouds = jsonObjectClouds.getString("all");

                            // Obtendo informações sobre o país e a cidade
                            JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                            String countryName = jsonObjectSys.getString("country");
                            String cityName = jsonResponse.getString("name");

                            // Definindo a cor do texto na TextView de resultados
                            tvResult.setTextColor(Color.rgb(68, 134, 199));

                            // Construindo a saída com os detalhes do clima
                            output += "Clima atual de " + cityName + " (" + countryName + ")"
                                    + "\n Temperatura: " + df.format(temp) + " °C"
                                    + "\n Sensação: " + df.format(feelsLike) + " °C"
                                    + "\n Umidade: " + humidity + "%"
                                    + "\n Descrição: " + description
                                    + "\n Velocidade do Vento: " + wind + "m/s (metros por segundo)"
                                    + "\n Nebulosidade: " + clouds + "%"
                                    + "\n Pressão: " + pressure + " hPa";

                            // Exibindo a saída na TextView de resultados
                            tvResult.setText(output);
                        }
                    } catch (JSONException e) {
                        // Lidando com exceções ao analisar a resposta JSON
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Método chamado quando ocorre um erro na solicitação
                    // Exibindo uma mensagem de erro usando Toast
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });

            // Adicionando a solicitação à fila de solicitações do Volley
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}
