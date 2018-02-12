package com.example.admin.retrofitfresher.data.remote;

/**
 * Created by Admin on 12/1/2017.
 *
 *  This class will have the base URL as a static variable
 *  and will also provide the APIService interface
 *  by with a getAPIService() static method to the rest of our application.
 *
 *  NB: Make sure you end the base URL with a /.
 *
 */

public class ApiUtils {

    private ApiUtils(){}

    // NB: Make sure you end the base URL with a /.
    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public static  APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
