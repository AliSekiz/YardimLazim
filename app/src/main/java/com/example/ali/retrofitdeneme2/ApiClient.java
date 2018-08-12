<<<<<<< HEAD
package com.example.ali.retrofitdeneme2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String baseUrl="http://fetihonal.com/yardimlazim/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
=======
package com.example.ali.retrofitdeneme2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String baseUrl="http://fetihonal.com/yardimlazim/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
>>>>>>> 08d5860b6cd833166675829839f1fa229a8da4f4
