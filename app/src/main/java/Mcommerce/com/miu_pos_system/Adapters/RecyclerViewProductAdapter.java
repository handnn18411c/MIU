package Mcommerce.com.miu_pos_system.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Mcommerce.com.miu_pos_system.Models.Category;
import Mcommerce.com.miu_pos_system.Models.ProductTab;
import Mcommerce.com.miu_pos_system.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewProductAdapter extends RecyclerView.Adapter<RecyclerViewProductAdapter.CateViewHolder> {

    private ArrayList<ProductTab> mCates;
    private Context mContext;

    public RecyclerViewProductAdapter(Context mContext, ArrayList<ProductTab> mCates) {
        this.mCates = mCates;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        return new CateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CateViewHolder holder, int position) {
        ProductTab mCate = mCates.get(position) ;
            holder.tvProductID.setText(mCate.getProductID());
            holder.tvProductName.setText(mCate.getProductName());
            holder.tvPrice.setText(mCate.getPrice() +"");
            holder.tvQuantity.setText(mCate.getQuantity()+"");
            holder.tvCreateDate.setText(mCate.getCreateDate());
            holder.tvCategory.setText(mCate.getCategory());


//        holder.tvCateName.setText(mCates.get(position).getCateName());
//        holder.imgCate.setImageResource(R.drawable.jacket);

    }

    @Override
    public int getItemCount() {
        return mCates.size();
    }

    public class CateViewHolder extends RecyclerView.ViewHolder {

        CheckBox cbProduct ;
        TextView tvProductID , tvProductName ,tvCategory , tvCreateDate , tvQuantity , tvPrice;

        public CateViewHolder(@NonNull View itemView) {
            super(itemView);
            cbProduct = itemView.findViewById(R.id.cbProduct) ;
            tvProductID = itemView.findViewById(R.id.tvProductID) ;
            tvProductName = itemView.findViewById(R.id.tvProductName) ;
            tvCategory = itemView.findViewById(R.id.tvCategory) ;
            tvCreateDate = itemView.findViewById(R.id.tvCreateDate) ;
            tvQuantity = itemView.findViewById(R.id.tvQuantity) ;
            tvPrice = itemView.findViewById(R.id.tvPrice) ;
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    final AlertDialog.Builder dialogXoa = new AlertDialog.Builder(v.getContext());
                    dialogXoa.setMessage("Ban co muon xoa item nay khong ? ");
                    dialogXoa.setPositiveButton("CO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(v.getContext(), "123", Toast.LENGTH_SHORT).show();


                        }
                    }) ;
                    dialogXoa.setNegativeButton("KHONG", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialogXoa.show();
                    return true;
                }
            });
        }
    }
}
