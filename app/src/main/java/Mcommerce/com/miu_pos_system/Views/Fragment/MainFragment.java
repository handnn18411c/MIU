package Mcommerce.com.miu_pos_system.Views.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Mcommerce.com.miu_pos_system.Adapters.NavCateAdapter;
import Mcommerce.com.miu_pos_system.Adapters.OrderListAdapter;
import Mcommerce.com.miu_pos_system.Adapters.ProductViewAdapter;
import Mcommerce.com.miu_pos_system.Models.Category;
import Mcommerce.com.miu_pos_system.Models.Order;
import Mcommerce.com.miu_pos_system.Models.Product;
import Mcommerce.com.miu_pos_system.R;
import Mcommerce.com.miu_pos_system.Views.Dialog.AddCustomerDialog;
import Mcommerce.com.miu_pos_system.Views.Dialog.AddDiscountDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainFragment extends Fragment {

    private ArrayList<Category> mCates = new ArrayList<>();
    private ArrayList<Product> mProducts = new ArrayList<>();
    private ArrayList<Order> mOrders = new ArrayList<>();
    private NavCateAdapter navCateAdapter;
    private ProductViewAdapter productViewAdapter;
    private OrderListAdapter orderListAdapter;

    @BindView(R.id.rvCate)
    RecyclerView rvCate;
    @BindView(R.id.rvCart)
    RecyclerView rvCart;
    @BindView(R.id.gvProducts)
    GridView gvProducts;
    @BindView(R.id.lnAddCustomer)
    LinearLayout lnAddCustomer;
    @BindView(R.id.rlAddDiscount)
    RelativeLayout rlAddDiscount;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.tvCustomerName)
    TextView tvCustomerName;
    @BindView(R.id.tvEmailCustomer)
    TextView tvEmailCustomer;
    @BindView(R.id.tvPhoneCustomer)
    TextView tvPhoneCustomer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        initCategoryView();
        initProductView();
        initOrderView();
        return view;
    }

    @OnClick(R.id.lnAddCustomer)
    public void openCustomerInfoDialog() {
        String title = "Customer Info";
        String name = tvCustomerName.getText().toString();
        String id = "C01";
        String email = tvEmailCustomer.getText().toString();
        String phone = tvPhoneCustomer.getText().toString();
        String group = "Retail";
        String status = "Trading";
        String buttonName = "Save";
        String note = "Khách hàng A đặt trước 2 quần Jean xám";
        AddCustomerDialog dialog = AddCustomerDialog.newInstance(title, name, id, email, phone, group, status, note, buttonName);
        dialog.show(getFragmentManager(), "Add Customer Dialog");
    }

    @OnClick(R.id.imgAddCustomer)
    public void openAddCustomerDialog() {
        AddCustomerDialog dialog = AddCustomerDialog.newInstance();
        dialog.show(getFragmentManager(), "Add Customer Dialog");

    }

    @OnClick(R.id.rlAddDiscount)
    public void openDiscountDialog() {
        AddDiscountDialog dialog = AddDiscountDialog.newInstance();
        dialog.show(getFragmentManager(), "Add Discount Dialog");
    }

    @OnClick(R.id.btnSave)
    public void openOrderDetail() {
        Toast.makeText(getContext(), "Save success", Toast.LENGTH_SHORT).show();
    }

    public void initCategoryView() {
        Category cate;
        for (int i = 0; i < 10; i++) {
            cate = new Category("Cate" + i, "");
            mCates.add(cate);
        }
        navCateAdapter = new NavCateAdapter(getContext(), mCates);

        rvCate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvCate.setAdapter(navCateAdapter);
    }

    public void initProductView() {
        Product product;
        for (int i = 0; i < 10; i++) {
            if(i==0){
                product = new Product("Product " + i, 3.00, null);
            }
            else{
                product = new Product("Product " + i, 3.00, "http://placeimg.com/640/362");
            }
            mProducts.add(product);
        }
        productViewAdapter = new ProductViewAdapter(getContext(), R.layout.fragment_main, mProducts);
        productViewAdapter.notifyDataSetChanged();
        gvProducts.setAdapter(productViewAdapter);
    }

    public void initOrderView() {
        Order order;
        for (int i = 0; i < 5; i++) {
            order = new Order("P01", "Black Jack",
                    3.00, "", "Black Jacket, size XL", i + 1);
            mOrders.add(order);
        }
        orderListAdapter = new OrderListAdapter(getContext(), mOrders);

        rvCart.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvCart.setAdapter(orderListAdapter);
    }

}
