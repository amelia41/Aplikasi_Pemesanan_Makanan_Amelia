package com.amelia.pert4;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amelia.pert4.Adapter.RecyclerMakananAdapter;
import com.amelia.pert4.Model.Makanan;
import com.amelia.pert4.Service.TransaksiService;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MakananFragment extends Fragment implements Callback<List<Makanan>> {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private ArrayList<String> dataset;
    private List<Makanan> transaksiDatas = new ArrayList<>();
    private ProgressDialog progressDialog;


    public MakananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_makanan, container, false);

        //deklarasikan rcyclerview
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_makanan);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        init();
        return rootView;
    }

    private void init() {
        /** ambil dari API
         *
         */
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://other.alterindonesia.com/restoran/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TransaksiService transaksiService = retrofit.create(TransaksiService.class);
        Call<List<Makanan>> getTransaksiCall = transaksiService.getMakanan();
        getTransaksiCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Makanan>> call, Response<List<Makanan>> response) {
        progressDialog.hide(); //memberhentikan kotak loading saat gamabr telah selesai diambil pd server
        for (Makanan makanan : response.body()) {
            transaksiDatas.add(makanan);
        }

        //buat ukurannya tetap
        recyclerView.setHasFixedSize(true);

        //gunakan linear
        recyclerLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(recyclerLayoutManager);

        //setting adapter
        recyclerAdapter = new RecyclerMakananAdapter(getContext(),transaksiDatas);
        recyclerView.setAdapter(recyclerAdapter);
    }

        @Override
        public void onFailure (Call<List<Makanan>> call, Throwable t){
            Toast.makeText(getContext(),"Please check your internet connection",Toast.LENGTH_LONG).show();
            progressDialog.hide();
        }
    }

