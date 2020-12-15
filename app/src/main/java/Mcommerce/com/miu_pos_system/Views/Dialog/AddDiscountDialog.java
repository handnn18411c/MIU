package Mcommerce.com.miu_pos_system.Views.Dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import Mcommerce.com.miu_pos_system.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AddDiscountDialog extends DialogFragment {

    private static final String KEY_DIALOG_TITLE = "key_dialog_title";

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_discount, null);

        ButterKnife.bind(this, view);
        bindingData();

        builder.setView(view);
        Dialog dialog = builder.create();


        dialog.setCanceledOnTouchOutside(true);

        return dialog;
    }

    public static AddDiscountDialog newInstance(String title){
        AddDiscountDialog frag = new AddDiscountDialog();
        Bundle args = new Bundle();

        args.putString(KEY_DIALOG_TITLE, title);

        frag.setArguments(args);
        return frag;
    }

    public static AddDiscountDialog newInstance(){
        AddDiscountDialog frag = new AddDiscountDialog();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    private void bindingData() {
        String title = getArguments().getString(KEY_DIALOG_TITLE, tvTitle.getText().toString());

        tvTitle.setText(title);
    }

}
