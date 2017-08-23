package com.cvcompany.vo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cvcompany.vo.myapplication.Module.MyFruit;
import com.cvcompany.vo.myapplication.Module.Retrofit.ApiClient;
import com.cvcompany.vo.myapplication.Module.Retrofit.ApiInterface;
import com.cvcompany.vo.myapplication.View.MyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.getSimpleName() ;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        getRetrofic("fruit");
    }

    public void getRetrofic(String name){
        apiInterface = ApiClient.createREtrofic().create(ApiInterface.class);
        Call<List<MyFruit>> call = apiInterface.getData(name);
        call.enqueue(new Callback<List<MyFruit>>() {
            @Override
            public void onResponse(Call<List<MyFruit>> call, Response<List<MyFruit>> response) {
                MyAdapter adapter = new MyAdapter(MainActivity.this, response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<MyFruit>> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
