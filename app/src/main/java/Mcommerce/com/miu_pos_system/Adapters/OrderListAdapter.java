package Mcommerce.com.miu_pos_system.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Mcommerce.com.miu_pos_system.Models.Category;
import Mcommerce.com.miu_pos_system.Models.Order;
import Mcommerce.com.miu_pos_system.Models.Product;
import Mcommerce.com.miu_pos_system.R;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    private ArrayList<Order> mOrders;
    private Context mContext;

    public OrderListAdapter(Context mContext, ArrayList<Order> mOrders) {
        this.mOrders = mOrders;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.tvProduct.setText(mOrders.get(position).getProductName());
        holder.tvDetail.setText(mOrders.get(position).getProductDetail());
        holder.tvPrice.setText("$ "+mOrders.get(position).getPrice());
        holder.tvQuantity.setText(mOrders.get(position).getQuantity()+"");

    }

    @Override
    public int getItemCount() {
        return mOrders.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgProduct;
        TextView tvProduct;
        TextView tvDetail;
        TextView tvPrice;
        TextView tvQuantity;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProductOrder);
            tvProduct = itemView.findViewById(R.id.tvProduct);
            tvDetail = itemView.findViewById(R.id.tvDetail);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }
}
