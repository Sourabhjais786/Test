package com.example.test;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private static Retrofit retrofit;
    ListView list_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        list_view = findViewById(R.id.list_view);

        /*ActivityHomeBinding activityHomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        ModelClass intentConstant=new ModelClass("Sourabh");
        activityHomeBinding.setName(intentConstant);
*/

        apiResponse();


    }

    private void apiResponse() {

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(IntentConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface api_interface = retrofit.create(ApiInterface.class);

        Call<List<ModelClass>> call = api_interface.getName();

        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                List<ModelClass> modelList = response.body();
                String[] listModel = new String[modelList.size()];
                for (int i = 0; i < modelList.size(); i++) {

                    listModel[i] = modelList.get(i).getName();
                }
                list_view.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listModel));
            }
            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

            }
        });
    }

}