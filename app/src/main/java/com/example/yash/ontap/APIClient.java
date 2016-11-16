package com.example.yash.ontap;
/**
 * Created by apple on 31/10/16.
 */
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by anirudhraghunath on 16/10/16.
 */

public class APIClient {
    public static PlacesInterface placesInterface = null;
    public static final String GOOGLE_API_KEY = "AIzaSyC74lHBff4RuqFsP3OexpeBCwnO4uxMcCQ";
    public static final String URL_BASE = "https://maps.googleapis.com/maps/api/place/nearbysearch";

    public static PlacesInterface getApi() {


        if (placesInterface == null) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(URL_BASE)
                    .build();
            placesInterface = adapter.create(PlacesInterface.class);
        }
        return placesInterface;
    }

    public interface PlacesInterface {
        @GET("/json?radius=5000&key=" + GOOGLE_API_KEY)
        void getRestaurants(@Query("location") String location, @Query("types") String types, Callback<GetRestaurants> movieCallback);
    }
}