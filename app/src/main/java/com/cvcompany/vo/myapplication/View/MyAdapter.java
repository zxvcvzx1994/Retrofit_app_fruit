package com.cvcompany.vo.myapplication.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cvcompany.vo.myapplication.Module.MyFruit;
import com.cvcompany.vo.myapplication.R;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vinh on 8/23/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder>{
    private List<MyFruit> list = Collections.emptyList();
    private Context context;

    public MyAdapter(Context context, List<MyFruit> list){
        this.context = context;
        this.list  = list;
    }
    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        MyFruit myFruit = list.get(position);
        holder.txtId.setText(""+myFruit.getId());
        holder.txtName.setText(""+myFruit.getName());
        holder.txtPrice.setText(""+myFruit.getPrice());
        Glide.with(context).load(myFruit.getPicture()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtId)
        TextView txtId;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtPrice)
        TextView txtPrice;
        @BindView(R.id.img)
        ImageView img;

        public MyViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
