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




    static final CameraPosition PASTO= CameraPosition.builder()
            .target(new LatLng(1.2089284, -77.2779443)).zoom(15)
            .bearing(90)//grados de la camara
            .tilt(45)//longitud de la camara
            .build();



    static final CameraPosition SEATLE= CameraPosition.builder()
            .target(new LatLng(47.6204, -122.3491)).zoom(15)
            .bearing(90)//grados de la camara
            .tilt(45)//longitud de la camara
            .build();
    static final CameraPosition TOKYO= CameraPosition.builder()
            .target(new LatLng(35.6895, 139.6917)).zoom(15)
            .bearing(90)//grados de la camara
            .tilt(45)//longitud de la camara
            .build();
    static final CameraPosition DUBLIN= CameraPosition.builder()
            .target(new LatLng(53.3478, -6.2597)).zoom(15)
            .bearing(90)//grados de la camara
            .tilt(45)//longitud de la camara
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSeatle =(Button) findViewById(R.id.id_btn_seattle);
        btnSeatle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                volar(SEATLE);
            }
        });

        Button btnDublin =(Button) findViewById(R.id.id_btn_dublin);
        btnDublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                volar(DUBLIN);
            }
        });
        Button btnTokyo =(Button) findViewById(R.id.id_btn_tokyo);
        btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                volar(TOKYO);
            }
        });


        MapFragment mapFragment =(MapFragment) getFragmentManager().findFragmentById(R.id.mapas);
        mapFragment.getMapAsync(this);

    }

    public  void volar (CameraPosition ciudad){
        m_maps.animateCamera(CameraUpdateFactory.newCameraPosition(ciudad),10000,null);
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady =true;
        m_maps = googleMap;

        //m_maps.moveCamera(CameraUpdateFactory.newCameraPosition(PASTO));
        volar(PASTO);



    }


}
