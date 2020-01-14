package com.example.lastest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    TextView tv_location_now,tv_date_now,tv_weather_now, tv_timeStatepro, tv_temperature_now, tv_wind_now, tv_windScale_now, tv_maxtemperature, tv_mintemperature;
    ImageView tv_weatherpicture;
    Button tv_selectcity;
    String location="beijing";
    @Override
    protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tv_selectcity = (Button) findViewById(R.id.nav_button);
            tv_selectcity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Selectcity.class);
                    //startActivity(intent);
                    startActivityForResult(intent, 1);
                    //setResult(1, intent);//设置resultCode，onActivityResult()中能获取到
                }
            });
            tv_date_now = findViewById(R.id._date);
            tv_weatherpicture = (ImageView) findViewById(R.id.WeatherPicture);
            tv_temperature_now = findViewById(R.id._temperature);
            tv_weather_now = findViewById(R.id._TimeState);
            tv_timeStatepro = findViewById(R.id._timeStatepro);
            tv_wind_now = findViewById(R.id._wind);
            tv_windScale_now = findViewById(R.id._windClass);
            tv_location_now = findViewById(R.id._location);
            tv_maxtemperature = findViewById(R.id._maxtemperature);
            tv_mintemperature = findViewById(R.id._mintemperature);

            String address = "https://api.seniverse.com/v3/weather/now.json?key=SjY71Vb_acn6rto_z&location=" + location+ "&language=zh-Hans&unit=c";
            HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
                @Override
                public void OnFinish(String response) {
                    Log.d(TAG, "OnFinish: " + response);
                    Gson gson = new Gson();
                    Weather weatherList = gson.fromJson(response.toString(), Weather.class);
                    List<Weather.ResultsBean> resultsBeanList = weatherList.getResults();
                    showResponse(resultsBeanList);
                }

                @Override
                public void OnError(Exception e) {
                    Log.d(TAG, "run: " + e.getMessage());
//                Toast.makeText(MainActivity.this, "test" + e.getMessage(), Toast.LENGTH_LONG);
                }
            });
            String address2 = "https://api.seniverse.com/v3/weather/daily.json?key=SjY71Vb_acn6rto_z&location=beijing&start=0&days=1";
            HttpUtil.sendHttpRequest(address2, new HttpCallbackListener() {
                @Override
                public void OnFinish(String response) {
                    Gson gson = new Gson();
                    TodayWeather todayweatherList = gson.fromJson(response.toString(), TodayWeather.class);
                    List<TodayWeather.ResultsBean> resultsBeanList2 = todayweatherList.getResults();
                    showResponse2(resultsBeanList2);
                }

                @Override
                public void OnError(Exception e) {
                    Log.d(TAG, "run: " + e.getMessage());

                }
            });
        }

    private void showResponse(final List<Weather.ResultsBean> resultsBeanList){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        tv_temperature_now.setText(resultsBeanList.get(0).getNow().getTemperature());
                    }
                }, 0 ,1800000);
                tv_weather_now.setText(resultsBeanList.get(0).getNow().getText());
                tv_timeStatepro.setText(resultsBeanList.get(0).getNow().getText());
                tv_wind_now.setText(resultsBeanList.get(0).getNow().getWind_direction());
                tv_windScale_now.setText(resultsBeanList.get(0).getNow().getWind_scale());
                tv_location_now.setText(resultsBeanList.get(0).getLocation().getName());
                String code=resultsBeanList.get(0).getNow().getCode();
                switch(code){
                    case "0" :
                        tv_weatherpicture.setImageResource(R.drawable.a0);
                        break;
                    case "1" :
                        tv_weatherpicture.setImageResource(R.drawable.a1);
                        break;
                    case "4" :
                        tv_weatherpicture.setImageResource(R.drawable.a4);
                        break;
                    case "5" :
                        tv_weatherpicture.setImageResource(R.drawable.a5);
                        break;
                    case "6" :
                        tv_weatherpicture.setImageResource(R.drawable.a6);
                        break;
                    case "7" :
                        tv_weatherpicture.setImageResource(R.drawable.a7);
                        break;
                    case "8" :
                        tv_weatherpicture.setImageResource(R.drawable.a8);
                        break;
                    case "9" :
                        tv_weatherpicture.setImageResource(R.drawable.a9);
                        break;
                    case "10" :
                        tv_weatherpicture.setImageResource(R.drawable.a10);
                        break;
                    case "11" :
                        tv_weatherpicture.setImageResource(R.drawable.a11);
                        break;
                    case "12" :
                        tv_weatherpicture.setImageResource(R.drawable.a12);
                        break;
                    case "13" :
                        tv_weatherpicture.setImageResource(R.drawable.a13);
                        break;
                    case "14" :
                        tv_weatherpicture.setImageResource(R.drawable.a14);
                        break;
                    case "15" :
                        tv_weatherpicture.setImageResource(R.drawable.a15);
                        break;
                    case "16" :
                        tv_weatherpicture.setImageResource(R.drawable.a16);
                        break;
                    case "17" :
                        tv_weatherpicture.setImageResource(R.drawable.a17);
                        break;
                    case "18" :
                        tv_weatherpicture.setImageResource(R.drawable.a18);
                        break;
                    case "19" :
                        tv_weatherpicture.setImageResource(R.drawable.a19);
                        break;
                    case "20" :
                        tv_weatherpicture.setImageResource(R.drawable.a20);
                        break;
                    case "21" :
                        tv_weatherpicture.setImageResource(R.drawable.a21);
                        break;
                    case "22" :
                        tv_weatherpicture.setImageResource(R.drawable.a22);
                        break;
                    case "23" :
                        tv_weatherpicture.setImageResource(R.drawable.a23);
                        break;
                    case "24" :
                        tv_weatherpicture.setImageResource(R.drawable.a24);
                        break;
                    case "25" :
                        tv_weatherpicture.setImageResource(R.drawable.a25);
                        break;
                    case "26" :
                        tv_weatherpicture.setImageResource(R.drawable.a26);
                        break;
                    case "27" :
                        tv_weatherpicture.setImageResource(R.drawable.a27);
                        break;
                    case "28" :
                        tv_weatherpicture.setImageResource(R.drawable.a28);
                        break;
                    case "29" :
                        tv_weatherpicture.setImageResource(R.drawable.a29);
                        break;
                    case "30" :
                        tv_weatherpicture.setImageResource(R.drawable.a30);
                        break;
                    case "31" :
                        tv_weatherpicture.setImageResource(R.drawable.a31);
                        break;
                    case "32" :
                        tv_weatherpicture.setImageResource(R.drawable.a32);
                        break;
                    case "33" :
                        tv_weatherpicture.setImageResource(R.drawable.a33);
                        break;
                    case "34" :
                        tv_weatherpicture.setImageResource(R.drawable.a34);
                        break;
                    case "35" :
                        tv_weatherpicture.setImageResource(R.drawable.a35);
                        break;
                    case "36" :
                        tv_weatherpicture.setImageResource(R.drawable.a36);
                        break;
                    case "37" :
                        tv_weatherpicture.setImageResource(R.drawable.a37);
                        break;
                    case "38" :
                        tv_weatherpicture.setImageResource(R.drawable.a38);
                        break;
                    case "99" :
                        tv_weatherpicture.setImageResource(R.drawable.a99);
                        break;
                }
            }
        });
    }
    private void showResponse2(final List<TodayWeather.ResultsBean> resultsBeanList2){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_maxtemperature.setText(resultsBeanList2.get(0).getDaily().get(0).getHigh());
                tv_mintemperature.setText(resultsBeanList2.get(0).getDaily().get(0).getLow());
                tv_date_now.setText(resultsBeanList2.get(0).getDaily().get(0).getDate());
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("hw");
                    Log.d("MainActivity", returnedData);
                    location=returnedData;
                    String address = "https://api.seniverse.com/v3/weather/now.json?key=SjY71Vb_acn6rto_z&location=" + location+ "&language=zh-Hans&unit=c";
                    HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
                        @Override
                        public void OnFinish(String response) {
                            Log.d(TAG, "OnFinish: " + response);
                            Gson gson = new Gson();
                            Weather weatherList = gson.fromJson(response.toString(), Weather.class);
                            List<Weather.ResultsBean> resultsBeanList = weatherList.getResults();
                            showResponse(resultsBeanList);
                        }
                        @Override
                        public void OnError(Exception e) {
                            Log.d(TAG, "run: " + e.getMessage());
//                Toast.makeText(MainActivity.this, "test" + e.getMessage(), Toast.LENGTH_LONG);
                        }
                    });
                    String address2 = "https://api.seniverse.com/v3/weather/daily.json?key=SjY71Vb_acn6rto_z&location="+location+"&start=0&days=1";
                    HttpUtil.sendHttpRequest(address2, new HttpCallbackListener() {
                        @Override
                        public void OnFinish(String response) {
                            Gson gson = new Gson();
                            TodayWeather todayweatherList = gson.fromJson(response.toString(), TodayWeather.class);
                            List<TodayWeather.ResultsBean> resultsBeanList2 = todayweatherList.getResults();
                            showResponse2(resultsBeanList2);
                        }

                        @Override
                        public void OnError(Exception e) {
                            Log.d(TAG, "run: " + e.getMessage());
                        }
                    });
                }
                break;
            default:
        }
    }
}


