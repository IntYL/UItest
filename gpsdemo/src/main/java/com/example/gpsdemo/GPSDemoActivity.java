package com.example.gpsdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class GPSDemoActivity extends AppCompatActivity {
    private final String TAG = "gps";
    private TextView tv_gps;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button btn_screen_shot;
    private final static String[] MULTI_PERMISSIONS = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpsdemo);
        tv_gps = findViewById(R.id.tv_gps);
        initGPS();
    }

    private void initGPS() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, MULTI_PERMISSIONS, 101);
            return;
        }
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager == null) {
            Log.d(TAG, "locationManager = null");
            return;
        }

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                showLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d(TAG, "onProviderEnabled:" + provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d(TAG, "onProviderDisabled:" + provider);

            }
        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, locationListener);
    }

    private void showLocation(Location location) {
        StringBuilder stringBuilder = new StringBuilder();
        double altitude = location.getAltitude();
        stringBuilder.append("高度:" + altitude + "\n");
        double longitude = location.getLongitude();
        stringBuilder.append("经度:" + longitude + "\n");
        double latitude = location.getLatitude();
        stringBuilder.append("纬度:" + latitude + "\n");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == Activity.RESULT_OK){
            initGPS();
        }
    }
}
