package com.example.shantacse.recyclear_veiw_in_online.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shantacse.recyclear_veiw_in_online.R;
import com.example.shantacse.recyclear_veiw_in_online.model.employee;
import com.squareup.picasso.Picasso;

import java.util.List;

public class employeeadapter extends RecyclerView.Adapter<employeeadapter.holder>{

    //-----Initialize global variable----//
    private List<employee> employeeslist;
    private Context context;

    //-----Step 2: define constructor----///
    public employeeadapter(List<employee> employeeslist, Context context) {
        this.employeeslist = employeeslist;
        this.context = context;
    }

    //---------overrided methord----------//
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {

        //------this code is for initialize Layout for create View with binding data----//
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(holder holder, final int position)
    {
        Picasso.with(context).load(employeeslist.get(position).getImage()).into(holder.empimage);
        holder.empname.setText(employeeslist.get(position).getName());
        holder.empdesignation.setText(employeeslist.get(position).getDesignation());
        holder.empstudy.setText(employeeslist.get(position).getStudy());
        holder.empemail.setText(employeeslist.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return employeeslist.size();
    }

    ///---step 1: initialize a holder class with viewholder---//
    class holder extends RecyclerView.ViewHolder
    {
        //----Initialize widget variable----///
        ImageView empimage;
        TextView empname;
        TextView empdesignation;
        TextView empstudy;
        TextView empemail;

        public holder(View itemView) {
            super(itemView);

            empimage = itemView.findViewById(R.id.profileimage);
            empname = itemView.findViewById(R.id.pname);
            empdesignation = itemView.findViewById(R.id.pdesignation);
            empstudy = itemView.findViewById(R.id.pstudy);
            empemail = itemView.findViewById(R.id.pemail);


        }
    }


}
