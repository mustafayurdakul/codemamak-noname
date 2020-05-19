package com.example.codemamak_noname;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ImageButton addButton = (ImageButton) findViewById(R.id.addLocation);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent markerActivity = new Intent(getApplicationContext(), AddLocation.class);
                startActivity(markerActivity);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng mamak = new LatLng(39.9048002, 32.9195131);

        LatLng markerDemokPark = new LatLng(39.9031252, 32.9350306);
        LatLng markerKutuphane = new LatLng(39.900369, 32.915591);
        LatLng markerDinlenPark = new LatLng(39.908608, 32.923790);

        mMap.addMarker(new MarkerOptions().position(markerDemokPark).title("Demokrasi Parkı").snippet("Demokrasi parkındaki bankları seç!").icon(BitmapDescriptorFactory.defaultMarker(45)));
        mMap.addMarker(new MarkerOptions().position(markerKutuphane).title("Ege Mahallesi Halk Kütüphanesi").snippet("Kütüphanenin tabelası değişecek. Nasıl olsun?").icon(BitmapDescriptorFactory.defaultMarker(210)));
        mMap.addMarker(new MarkerOptions().position(markerDinlenPark).title("Dinlenme Parkı").snippet("En güzel çocuk parkını seçmemiz için bize yardım et!").icon(BitmapDescriptorFactory.defaultMarker(10)));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker.getTitle().equals("Demokrasi Parkı")) {
                    Intent markerActivity = new Intent(getApplicationContext(), MarkerDemokPark.class);
                    startActivity(markerActivity);
                } else if (marker.getTitle().equals("Ege Mahallesi Halk Kütüphanesi")) {
                    Intent markerActivity = new Intent(getApplicationContext(), MarkerKutuphane.class);
                    startActivity(markerActivity);
                } else {
                    Intent markerActivity = new Intent(getApplicationContext(), MarkerDinlenmeParki.class);
                    startActivity(markerActivity);
                }
            }
        });

        float zoomLevel = 15.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mamak, zoomLevel));
    }
}
