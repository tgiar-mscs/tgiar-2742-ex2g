package com.example.tgiar2742ex2g1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import cz.msebera.android.httpclient.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<SensorReading> sensorReadings;
    private RecyclerView recyclerView;
    private Context context;
    private AsyncHttpClient httpClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;
        loadSensorReading();

    }
    private void loadSensorReading() {
        String url = "http://204.77.50.53/propertymonitor/api/sensorreadings/2";
        this.httpClient = new AsyncHttpClient();
        this.httpClient.get(MainActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers,
                                  byte[] responseBody) {
                String json = new String(responseBody);
                sensorReadings = SensorReadingJSONParser.getSensorReadings(json);
                SensorReadingAdapter adapter = new SensorReadingAdapter(
                        MainActivity.this, R.layout.sensor_reading_recylcler_item, sensorReadings);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(int statusCode, PreferenceActivity.Header[] headers,
                                  byte[] responseBody, Throwable error) {

            }
                });

//        String json = "{\n" +
//                "  \"readings\": [\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60161,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:01:43.54235\",\n" +
//                "      \"value\": 29,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60162,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:03:04.7657807\",\n" +
//                "      \"value\": 30,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60163,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:05:06.5187565\",\n" +
//                "      \"value\": 31,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60164,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:05:47.3773175\",\n" +
//                "      \"value\": 32,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60165,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:06:48.2299219\",\n" +
//                "      \"value\": 33,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60166,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:07:28.8307888\",\n" +
//                "      \"value\": 34,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60167,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:08:09.4228174\",\n" +
//                "      \"value\": 32,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60168,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:08:29.7470375\",\n" +
//                "      \"value\": 31,\n" +
//                "      \"sensor\": null\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"sensorReadingId\": 60169,\n" +
//                "      \"sensorId\": 2,\n" +
//                "      \"dateTime\": \"2018-11-26T10:08:50.0713275\",\n" +
//                "      \"value\": 30,\n" +
//                "      \"sensor\": null\n" +
//                "    }]}";
//        this.sensorReadings = SensorReadingJSONParser.getSensorReadings(json);
//    }
    }
}