package com.example.myapplication;

import com.example.myapplication.model.Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PolyService {


    @GET("wp-json/wp/v2/comments")
    Call<List<Chat>> getChat(@Query("page") int page,
                                   @Query("per_page") int per_page);
}
