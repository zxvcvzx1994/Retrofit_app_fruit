package com.cvcompany.vo.myapplication.Module.Retrofit;

import com.cvcompany.vo.myapplication.Module.MyFruit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by vinh on 8/23/2017.
 */

public interface ApiInterface {
    @POST("juice.php")
    Call<List<MyFruit>> getData(@Query("init_name") String name);
}
