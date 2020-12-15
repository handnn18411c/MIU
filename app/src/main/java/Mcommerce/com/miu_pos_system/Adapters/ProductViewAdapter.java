package Mcommerce.com.miu_pos_system.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import Mcommerce.com.miu_pos_system.Models.Product;
import Mcommerce.com.miu_pos_system.R;
import butterknife.internal.ListenerClass;
import lombok.SneakyThrows;

public class ProductViewAdapter extends ArrayAdapter<Product> {
    public ProductViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> objects) {
        super(context, resource, objects);
    }
    @SneakyThrows
    public View getView(int position, View convertView, ViewGroup parent){
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_product,null);

        ImageView imgProduct=v.findViewById(R.id.imgProduct);
        TextView tvProductName=v.findViewById(R.id.tvProductName);
        TextView tvPrice=v.findViewById(R.id.tvPrice);

        Product product=getItem(position);
        tvProductName.setText(product.getProductName());
        tvPrice.setText("$ "+product.getPrice());
//        imgProduct.setImageResource(R.drawable.jacket);
        if(product.getImgProduct()==null)
        {
            imgProduct.setImageResource(R.drawable.ic_baseline_add_24);
            imgProduct.setPadding(0, 20,0,0);
            tvPrice.setVisibility(View.INVISIBLE);
            tvProductName.setVisibility(View.INVISIBLE);
        }
        else{
            Glide.with(v.getContext())
                    .asBitmap()
                    .placeholder(R.drawable.jacket)
                    .load("http://placeimg.com/640/360")
                    .into(imgProduct);
        }

        return v;
    }
}
