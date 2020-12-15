package Mcommerce.com.miu_pos_system.Views.Dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import Mcommerce.com.miu_pos_system.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddCustomerDialog extends DialogFragment {

    private static final String KEY_DIALOG_NAME = "key_dialog_name";
    private static final String KEY_DIALOG_ID = "key_dialog_id";
    private static final String KEY_DIALOG_EMAIL = "key_dialog_email";
    private static final String KEY_DIALOG_GROUP = "key_dialog_group";
    private static final String KEY_DIALOG_PHONE = "key_dialog_phone";
    private static final String KEY_DIALOG_STATUS = "key_dialog_status";
    private static final String KEY_DIALOG_NOTE = "key_dialog_note";
    private static final String KEY_DIALOG_TITLE = "key_dialog_title";
    private static final String KEY_DIALOG_BUTTON = "key_dialog_button";


    @BindView(R.id.edtCustomerID)
    EditText edtCustomerID;
    @BindView(R.id.edtCustomerName)
    EditText edtCustomerName;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPhone)
    EditText edtPhone;
    @BindView(R.id.spnGroup)
    Spinner spnGroup;
    @BindView(R.id.spnStatus)
    Spinner spnStatus;
    @BindView(R.id.edtNote)
    EditText edtNote;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView((R.id.btnSave))
    Button btnSave;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_customer, null);

        ButterKnife.bind(this, view);
        bindingData();

        builder.setView(view);
        Dialog dialog = builder.create();

        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        return dialog;
    }

    public static AddCustomerDialog newInstance(String title, String name, String id, String email,
                                                String phone, String group, String status, String note,
                                                String buttonName){
        AddCustomerDialog frag = new AddCustomerDialog();
        Bundle args = new Bundle();

        args.putString(KEY_DIALOG_TITLE, title);
        args.putString(KEY_DIALOG_NAME, name);
        args.putString(KEY_DIALOG_ID, id);
        args.putString(KEY_DIALOG_EMAIL, email);
        args.putString(KEY_DIALOG_PHONE, phone);
        args.putString(KEY_DIALOG_NOTE, note);
        args.putString(KEY_DIALOG_BUTTON, buttonName);

        int index = convertGroupStatusToIndex(group);
        args.putInt(KEY_DIALOG_GROUP, index);

        index = convertGroupStatusToIndex(status);
        args.putInt(KEY_DIALOG_STATUS, index);

        frag.setArguments(args);
        return frag;
    }

    public static AddCustomerDialog newInstance(){
        AddCustomerDialog frag = new AddCustomerDialog();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    private void bindingData() {
        String title = getArguments().getString(KEY_DIALOG_TITLE, "Add New Customer");
        String name = getArguments().getString(KEY_DIALOG_NAME, "");
        String id = getArguments().getString(KEY_DIALOG_ID, "");
        String email = getArguments().getString(KEY_DIALOG_EMAIL, "");
        String phone = getArguments().getString(KEY_DIALOG_PHONE, "");
        String note = getArguments().getString(KEY_DIALOG_NOTE, "");
        String buttonName = getArguments().getString(KEY_DIALOG_BUTTON, "Add");
        int group = getArguments().getInt(KEY_DIALOG_GROUP, 0);
        int status = getArguments().getInt(KEY_DIALOG_STATUS, 0);

        edtCustomerName.setText(name);
        edtCustomerID.setText(id);
        edtEmail.setText(email);
        edtPhone.setText(phone);
        edtNote.setText(note);
        spnGroup.setSelection(group);
        spnStatus.setSelection(status);
        tvTitle.setText(title);
        btnSave.setText(buttonName);

    }

    public static int convertGroupStatusToIndex(String str) {
        switch (str) {
            case "Retail":
            case "Trading":
                return 0;
            case "VIP":
            case "Delivered":
                return 1;
        }
        return 0;
    }

    @OnClick(R.id.btnSave)
    public void updateCustomer(){
        String name = edtCustomerName.getText().toString();
        String id = edtCustomerID.getText().toString();
        String phone = edtPhone.getText().toString();

        if(name.compareTo("")==0 || id.compareTo("")==0  || phone.compareTo("")==0 ){
            Toast.makeText(getContext(), "Please fill all required field", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
        }
    }

}
