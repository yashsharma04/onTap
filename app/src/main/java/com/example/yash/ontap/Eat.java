package com.example.yash.ontap;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Eat extends AppCompatActivity {
    String[] mobileArray = {"Dollops","Eye of the Tiger","Saiba","Atil","Red Kitchen","Burger King"};
    LocationManager locationManager;
    android.location.Location loc;
    public static final int REQ_CODE = 0011;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);


        final ListView listView = (ListView) findViewById(R.id.mobile_list);
        //listView.setAdapter(adapter);
        getLocation();
        if (loc != null) {

            String locationString = String.valueOf(loc.getLatitude());
            locationString += ",";
            locationString += String.valueOf(loc.getLongitude());

            APIClient.getApi().getRestaurants(locationString, "food", new Callback<GetRestaurants>() {
                @Override
                public void success(GetRestaurants restaurants, Response response) {
                    Log.d("well", "hello");
                    listView.setAdapter(new ListViewAdapter(restaurants.getResults()));
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("error", error.toString());
                }
            });
        }
    }
    public void getLocation() {
        if (ActivityCompat.checkSelfPermission(Eat.this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(Eat.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(Criteria.POWER_LOW);

            android.location.Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (location == null) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
                loc = location;
            } else
                loc = location;

        } else
            ActivityCompat.requestPermissions(Eat.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQ_CODE) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED)
                getLocation();
            else {

                //Snackbar.make(findViewById(android.R.id.content), "Location permission request was denied",Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private LocationListener listener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(android.location.Location location) {
            loc = location;
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
            locationManager.removeUpdates(listener);
        }
    };


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                String str = mobileArray[position];
//                Intent intent = new Intent(Eat.this,EatItemActivity.class);
//                intent.putExtra("val",str);
//                startActivity(intent);
//
//            }
//        });
//    }
}
