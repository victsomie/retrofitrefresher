package com.example.admin.retrofitfresher.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 12/1/2017.
 *
 * This class will create a singleton of Retrofit in the method getClient(String baseUrl) and
 * return it to the caller.
 *
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public  static Retrofit getClient(String baseUrl){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
