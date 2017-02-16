package com.example.mithunkumerghose.startingmaterialdesign.adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mithunkumerghose.startingmaterialdesign.R;

/**
 * @author Mithun Kumer Ghose.
 */
class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView stNameView, stIdView, stDeptView;

    RecyclerViewHolder(View itemView) {
        super(itemView);

        stNameView = (TextView) itemView.findViewById(R.id.stName);
        stDeptView = (TextView) itemView.findViewById(R.id.stDept);
        stIdView = (TextView) itemView.findViewById(R.id.stId);
    }


}
