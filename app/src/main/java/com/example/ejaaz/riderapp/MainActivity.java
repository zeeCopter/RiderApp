package com.example.ejaaz.riderapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ejaaz.riderapp.Utils.CommonUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

public class MainActivity extends AppCompatActivity {

    MapView mMapView;
    private GoogleMap googleMap;
    Button makeBusyBtn,payMethodBtn,endRideBtn,arrivedBtn;
    LinearLayout arrivedTopLL,btnLL,arrivedLL,endRideLL;
    RelativeLayout secondLastRL,firstLastRL;
    ImageView backIV;
    TextView topHeadingTV,cancelTV,packageOnBoardTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = findViewById(R.id.mapView);
        makeBusyBtn = findViewById(R.id.makeBusyBtn);
        payMethodBtn = findViewById(R.id.payMethodBtn);
        arrivedTopLL = findViewById(R.id.arrivedTopLL);
        secondLastRL = findViewById(R.id.secondLastRL);
        firstLastRL = findViewById(R.id.firstLastRL);
        backIV = findViewById(R.id.backIV);
        topHeadingTV = findViewById(R.id.topHeadingTV);
        cancelTV = findViewById(R.id.cancelTV);
        endRideBtn = findViewById(R.id.endRideBtn);
        btnLL = findViewById(R.id.btnLL);
        arrivedBtn = findViewById(R.id.arrivedBtn);
        packageOnBoardTV = findViewById(R.id.packageOnBoardTV);
        arrivedLL = findViewById(R.id.arrivedLL);
        endRideLL = findViewById(R.id.endRideLL);

        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
                        mMapView.getMapAsync(new OnMapReadyCallback() {
                            @Override
                            public void onMapReady(GoogleMap mMap) {
                                googleMap = mMap;

                                // For showing a move to my location button
                                if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                googleMap.setMyLocationEnabled(true);

                                startLocationListener();

                            }
                        });
        makeBusyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AcceptRequestActivity.class));
            }
        });

        arrivedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScreenAccordingToState(2);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(CommonUtils.acceptOrRejectState == 1)
        {
            changeScreenAccordingToState(1);
        }
    }

    private void startLocationListener() {

        long mLocTrackingInterval = 1000 * 10; // 10 sec
        float trackingDistance = 0;
        LocationAccuracy trackingAccuracy = LocationAccuracy.HIGH;

        LocationParams.Builder builder = new LocationParams.Builder()
                .setAccuracy(trackingAccuracy)
                .setDistance(trackingDistance)
                .setInterval(mLocTrackingInterval);

        SmartLocation.with(this)
                .location()
                .continuous()
                .config(builder.build())
                .start(new OnLocationUpdatedListener() {
                    @Override
                    public void onLocationUpdated(Location location) {
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(location.getLatitude(),location.getLongitude())).zoom(16).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    }
                });
    }

    private void changeScreenAccordingToState(int state)
    {
        if(state == 0)
        {
            payMethodBtn.setVisibility(View.GONE);
            arrivedTopLL.setVisibility(View.GONE);
            secondLastRL.setVisibility(View.GONE);
            makeBusyBtn.setVisibility(View.VISIBLE);
            firstLastRL.setVisibility(View.VISIBLE);
            backIV.setBackgroundResource(R.drawable.ic_dehaze);
            topHeadingTV.setText("Free");
            cancelTV.setVisibility(View.GONE);
        }
        else if(state == 1)
        {
            payMethodBtn.setVisibility(View.VISIBLE);
            arrivedTopLL.setVisibility(View.VISIBLE);
            secondLastRL.setVisibility(View.VISIBLE);
            makeBusyBtn.setVisibility(View.GONE);
            firstLastRL.setVisibility(View.GONE);
            backIV.setBackgroundResource(R.drawable.arrow);
            topHeadingTV.setText("Package");
            cancelTV.setVisibility(View.VISIBLE);
        }
        else if(state == 2)
        {
            btnLL.setVisibility(View.GONE);
            endRideBtn.setVisibility(View.VISIBLE);
            packageOnBoardTV.setVisibility(View.VISIBLE);
            endRideLL.setVisibility(View.VISIBLE);
            arrivedLL.setVisibility(View.GONE);
        }
    }


}
