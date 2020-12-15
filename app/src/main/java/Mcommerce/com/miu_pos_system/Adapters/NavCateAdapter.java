package Mcommerce.com.miu_pos_system.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import Mcommerce.com.miu_pos_system.Models.Category;
import Mcommerce.com.miu_pos_system.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class NavCateAdapter extends RecyclerView.Adapter<NavCateAdapter.CateViewHolder> {

    private ArrayList<Category> mCates;
    private Context mContext;

    public NavCateAdapter(Context mContext, ArrayList<Category> mCates) {
        this.mCates = mCates;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_category, parent, false);
        return new CateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CateViewHolder holder, int position) {
        holder.tvCateName.setText(mCates.get(position).getCateName());
        holder.imgCate.setImageResource(R.drawable.jacket);
    }

    @Override
    public int getItemCount() {
        return mCates.size();
    }

    public class CateViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgCate;
        TextView tvCateName;

        public CateViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCate = itemView.findViewById(R.id.imgCate);
            tvCateName = itemView.findViewById(R.id.tvCateName);
        }
    }
}
