package com.example.rxlistview.helpers;import retrofit2.Retrofit;import retrofit2.converter.gson.GsonConverterFactory;public class RetrofitInstance {    private static final String BASE_URL = "https://docterpp.000webhostapp.com/hamzaali6307cloudSecurity/";    private static Retrofit retrofit = null;    public static RestApiService getApiService() {        if (retrofit == null) {            retrofit = new Retrofit                    .Builder()                    .baseUrl(BASE_URL)                    .addConverterFactory( GsonConverterFactory.create())                    .build();        }        return retrofit.create(RestApiService.class);    }}