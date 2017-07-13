package sg.edu.rp.c346.p08_map;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);
                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);

                    UiSettings uiCompass = map.getUiSettings();
                    uiCompass.setCompassEnabled(true);

                    UiSettings uiZoom = map.getUiSettings();
                    uiZoom.setZoomControlsEnabled(true);

                    LatLng North = new LatLng(1.459107, 103.8248925);

                    LatLng Central = new LatLng(1.2978023, 103.8474414);

                    LatLng East = new LatLng(1.3671489, 103.9280213);

                    LatLng SG = new LatLng(1.3553794, 103.8677444);

                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(SG, 15));

                    Marker north = map.addMarker(new
                            MarkerOptions()
                            .position(North)
                            .title("HQ - North")
                            .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                    "Tel:65433456")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    Marker central = map.addMarker(new
                            MarkerOptions()
                            .position(Central)
                            .title("HQ - North")
                            .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                    "Operating hours: 11am-8pm\n" +
                                    "Tel:67788652")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    Marker east = map.addMarker(new
                            MarkerOptions()
                            .position(East)
                            .title("HQ - North")
                            .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                    "Operating hours: 9am-5pm\n" +
                                    "Tel:66776677")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                }
            }
        });


        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    UiSettings uiCompass = map.getUiSettings();
                    uiCompass.setCompassEnabled(true);

                    UiSettings uiZoom = map.getUiSettings();
                    uiZoom.setZoomControlsEnabled(true);

                    int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION);

                    if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                        map.setMyLocationEnabled(true);
                    } else {
                        Log.e("GMap - Permission", "GPS access has not been granted");
                    }

                    LatLng North = new LatLng(1.459107, 103.8248925);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(North, 18));

                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(North)
                            .title("HQ - North")
                            .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm" +
                                    "Tel:65433456")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

                    UiSettings uiCompass = map.getUiSettings();
                    uiCompass.setCompassEnabled(true);

                    UiSettings uiZoom = map.getUiSettings();
                    uiZoom.setZoomControlsEnabled(true);

                    int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION);

                    if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                        map.setMyLocationEnabled(true);
                    } else {
                        Log.e("GMap - Permission", "GPS access has not been granted");
                    }

                    LatLng Central = new LatLng(1.2978023, 103.8474414);

                    Marker central = map.addMarker(new
                            MarkerOptions()
                            .position(Central)
                            .title("HQ - North")
                            .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                    "Operating hours: 11am-8pm\n" +
                                    "Tel:67788652")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                    UiSettings uiCompass = map.getUiSettings();
                    uiCompass.setCompassEnabled(true);

                    UiSettings uiZoom = map.getUiSettings();
                    uiZoom.setZoomControlsEnabled(true);

                    int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION);

                    if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                        map.setMyLocationEnabled(true);
                    } else {
                        Log.e("GMap - Permission", "GPS access has not been granted");
                    }

                    LatLng East = new LatLng(1.3671489, 103.9280213);

                    Marker east = map.addMarker(new
                            MarkerOptions()
                            .position(East)
                            .title("HQ - North")
                            .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                    "Operating hours: 9am-5pm\n" +
                                    "Tel:66776677")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                }
            }
        });
    }
}
