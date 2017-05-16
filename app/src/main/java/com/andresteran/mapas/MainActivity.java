package com.andresteran.mapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap m_maps;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNormal =(Button) findViewById(R.id.id_btn_normal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        Button btnSatelite =(Button) findViewById(R.id.id_btn_satelite);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_maps.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        Button btnHibrido =(Button) findViewById(R.id.id_btn_hibrido);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_maps.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });


        MapFragment mapFragment =(MapFragment) getFragmentManager().findFragmentById(R.id.mapas);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady =true;
        LatLng pasto = new LatLng(1.2089284, -77.2779443);
        CameraPosition target = CameraPosition.builder().target(pasto).zoom(15).build();
        m_maps.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
