package com.amelia.pert4.Service;

import com.amelia.pert4.Model.Makanan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by amelia41 on 7/7/2017.
 */

public interface TransaksiService {
    @GET("api/get_makanan")
    Call<List<Makanan>> getMakanan();



}
