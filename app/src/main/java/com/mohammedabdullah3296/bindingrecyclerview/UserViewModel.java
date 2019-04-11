package com.mohammedabdullah3296.bindingrecyclerview;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserViewModel extends ViewModel {

    private MutableLiveData<List<User>> usersList;

    public LiveData<List<User>> getUsers() {
        if (usersList == null) {
            usersList = new MutableLiveData<List<User>>();
            loadUsers();
        }

        return usersList;
    }

    private void loadUsers() {

        ApiInterface apiService1 =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<User>> call1 = apiService1.getUsers("135");
        call1.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, retrofit2.Response<List<User>> response) {
                int statusCode = response.code();
                usersList.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
             }
        });
    }


}
