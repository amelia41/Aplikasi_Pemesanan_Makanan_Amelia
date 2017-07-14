package com.amelia.pert4.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amelia.pert4.Model.Makanan;
import com.amelia.pert4.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.amelia.pert4.R.id.imageView;

/**
 * Created by amelia41 on 6/20/2017.
 */

public class RecyclerMakananAdapter extends RecyclerView.Adapter<RecyclerMakananAdapter.ViewHolder> {

    private List<Makanan> arrData;
    private Context context;

    public RecyclerMakananAdapter(Context context, List<Makanan> arrData){
        this.arrData = arrData;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvJudul, tvHarga;
        public ImageView imageView;
        public ViewHolder(View itemView){
            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.textNama);
            tvHarga = (TextView) itemView.findViewById(R.id.textHarga);
            imageView = (ImageView)itemView.findViewById(R.id.imageView2); //imageView2 dr item recycler makanan gambar buttonnya

        }



    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_makanan, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerMakananAdapter.ViewHolder holder, int position) {
        //mengambil dataset dari array dan menempatkannya sesuai posisinya
        Makanan transaksiData = arrData.get(position);
        holder.tvJudul.setText(transaksiData.getNama_menu());
        holder.tvHarga.setText(transaksiData.getHarga()+"");

        Picasso.with(context).load(transaksiData.getGambar())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }
}
