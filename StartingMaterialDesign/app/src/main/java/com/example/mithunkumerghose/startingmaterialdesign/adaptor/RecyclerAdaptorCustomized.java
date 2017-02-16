package com.example.mithunkumerghose.startingmaterialdesign.adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mithunkumerghose.startingmaterialdesign.R;
import com.example.mithunkumerghose.startingmaterialdesign.model.StudentModel;

import java.util.ArrayList;

/**
 * @author Mithun Kumer Ghose.
 */

public class RecyclerAdaptorCustomized extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<StudentModel> allStudents;

    public RecyclerAdaptorCustomized(ArrayList<StudentModel> allStudents) {
        this.allStudents = allStudents;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_view,null);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        StudentModel studentModel = allStudents.get(position);

        holder.stNameView.setText(studentModel.getStName());
        holder.stDeptView.setText(studentModel.getBatchCode());
        holder.stIdView.setText(studentModel.getStId());
    }

    @Override
    public int getItemCount() {
        return allStudents.size();
    }
}
