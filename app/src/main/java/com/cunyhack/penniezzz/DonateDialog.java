package com.cunyhack.penniezzz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DonateDialog extends AppCompatDialogFragment {
    EditText amount;
    TextView five;
    TextView ten;
    TextView twentyFive;
    private DonateDialog.DonateDialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose an Amount");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.donate_dialog_setup, null);
        builder.setView(view);

        five = view.findViewById(R.id.fiveButton);
        ten = view.findViewById(R.id.tenButton);
        twentyFive = view.findViewById(R.id.twentyfiveButton);
        amount = view.findViewById(R.id.donateInput);

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount.setText("5.00", TextView.BufferType.EDITABLE);
            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount.setText("10.00", TextView.BufferType.EDITABLE);
            }
        });
        twentyFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount.setText("25.00", TextView.BufferType.EDITABLE);
            }
        });

        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String amt = amount.getText().toString();
                listener.getDonation(amt);
                dialog.dismiss();
            }
        });
        builder .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        return builder.create();
    }
    public interface DonateDialogListener {
        void onYesClicked();
        void getDonation(String a);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DonateDialog.DonateDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implement DonateDialogListener");
        }
    }
}
