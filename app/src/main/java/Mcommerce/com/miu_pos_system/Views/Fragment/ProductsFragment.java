package Mcommerce.com.miu_pos_system.Views.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Mcommerce.com.miu_pos_system.Adapters.RecyclerViewProductAdapter;
import Mcommerce.com.miu_pos_system.Models.ProductTab;
import Mcommerce.com.miu_pos_system.R;

public class ProductsFragment extends Fragment {
    View view ;
    RecyclerView recyclerViewProduct ;
    RecyclerViewProductAdapter adapter ;
    ArrayList<ProductTab> productTabs = new ArrayList<>() ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_product, container, false);
         mapping();
         for(int i = 0 ; i<10 ; i++){
             productTabs.add(new ProductTab(i+"","blue skrit"+i ,"skrit" ,"15/12/2020",100 , 250000));

         }
         adapter = new RecyclerViewProductAdapter(getContext() , productTabs) ;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProduct.setLayoutManager(linearLayoutManager);

         recyclerViewProduct.setAdapter(adapter);


        return view;
    }

    private void mapping() {
        recyclerViewProduct = view.findViewById(R.id.rvProduct) ;

    }

}
