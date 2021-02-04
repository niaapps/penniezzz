package com.cunyhack.penniezzz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class CharityDialog extends AppCompatDialogFragment {

    private CharityDialogListener listener;
    ListView lvCause, lvO;
    String [] causeList;
    String[] wList;
    AlertDialog.Builder secondBuilder;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        causeList = getActivity().getResources().getStringArray(R.array.causesOptions);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.cause_dialog, null);
        ArrayAdapter<String> adapterC= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,causeList);
        builder.setTitle("Choose a Cause");
        lvCause = view.findViewById(R.id.lvCause);
        lvCause.setAdapter(adapterC);
        builder.setView(view);
        AlertDialog alert = builder.create();
        lvCause.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) parent.getItemAtPosition(position);

                if(value.equals("Women's Rights")){
                    wList = getActivity().getResources().getStringArray(R.array.womensOptions);

                    showSecondDialog(wList);
                    alert.dismiss();



                }
            }
        });


        return alert;
    }
    public interface CharityDialogListener {
        void onYesClicked();
        void applyTexts(String a);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (CharityDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implement ExampleDialogListener");
        }
    }

    public void showSecondDialog(String[] a){
        secondBuilder = new android.app.AlertDialog.Builder(getActivity());
        secondBuilder.setTitle("Choose an Organization");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.org_dialog, null);

        ArrayAdapter<String> adapterW= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,a);
        lvO = view.findViewById(R.id.lvOrg);
        lvO.setAdapter(adapterW);
        secondBuilder.setView(view);
        AlertDialog alert = secondBuilder.create();
        lvO.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String choice = adapterW.getItem(position);
                listener.applyTexts(choice);
                alert.dismiss();
            }
        });
        alert.show();

    }
}
