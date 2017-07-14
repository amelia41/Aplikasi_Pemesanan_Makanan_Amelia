package com.amelia.pert4.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amelia.pert4.DetailMenu;
import com.amelia.pert4.Interface.OnItemClickListener;
import com.amelia.pert4.Model.Makanan;
import com.amelia.pert4.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.amelia.pert4.R.id.imageView;
import static com.amelia.pert4.R.id.imageView_Detail;

/**
 * Created by amelia41 on 6/20/2017.
 */

public class RecyclerMakananAdapter extends RecyclerView.Adapter<RecyclerMakananAdapter.ViewHolder> {

    private List<Makanan> arrData;
    private Context context;
    public OnItemClickListener clickListener;

    public RecyclerMakananAdapter(Context context, List<Makanan> arrData){
        this.arrData = arrData;
        this.context = context;
    }

    public void setClickListener(OnItemClickListener ClickListener) {
        this.clickListener = ClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{ //mengimplementasikan dr interface mau diapain
        public TextView tvJudul, tvHarga;
        public ImageView imageView;
        public ViewHolder(View itemView){
            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.textNama);
            tvHarga = (TextView) itemView.findViewById(R.id.textHarga);
            imageView = (ImageView)itemView.findViewById(R.id.imageView2); //imageView2 dr item recycler makanan gambar buttonnya
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), DetailMenu.class);
            context.startActivity(i);
            i.putExtra("Judul",tvJudul.getText());//pindahin data antar activity pake putExtra
            i.putExtra("Harga",tvHarga.getText());
            context.startActivity(i);
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
