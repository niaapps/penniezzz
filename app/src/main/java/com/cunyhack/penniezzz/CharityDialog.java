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
    String[] hList;
    String[] jList;
    String[] eduList;
    String[] cList;
    String[] envList;
//comment
    AlertDialog.Builder secondBuilder;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        causeList = getActivity().getResources().getStringArray(R.array.causesOptions);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()); //alert dialog builder
        LayoutInflater inflater = getActivity().getLayoutInflater(); //this is the pop up on the screen
        View view = inflater.inflate(R.layout.cause_dialog, null); //creates view for the user
        ArrayAdapter<String> adapterC= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,causeList); //the layout of listview
        builder.setTitle("Choose a Cause");
        lvCause = view.findViewById(R.id.lvCause);
        lvCause.setAdapter(adapterC);
        builder.setView(view); //shows view to builder
        AlertDialog alert = builder.create();
        lvCause.setOnItemClickListener(new AdapterView.OnItemClickListener() { //OnClickListener tells button what to do
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //Item listener

                String value = (String) parent.getItemAtPosition(position);

                if(value.equals("Women's Rights")){
                    wList = getActivity().getResources().getStringArray(R.array.womensOptions);

                    showSecondDialog(wList);
                    alert.dismiss();
                }

                if(value.equals("Health")){
                    hList = getActivity().getResources().getStringArray(R.array.healthOptions);

                    showSecondDialog(hList);
                    alert.dismiss();
                }

                if(value.equals("Justice")){
                    jList = getActivity().getResources().getStringArray(R.array.justiceOptions);

                    showSecondDialog(jList);
                    alert.dismiss();
                }

                if(value.equals("Education")){
                    eduList = getActivity().getResources().getStringArray(R.array.eduOptions);

                    showSecondDialog(eduList);
                    alert.dismiss();
                }

                if(value.equals("Covid-19")){
                    cList = getActivity().getResources().getStringArray(R.array.covidOptions);

                    showSecondDialog(cList);
                    alert.dismiss();
                }

                if(value.equals("Environment")){
                    envList = getActivity().getResources().getStringArray(R.array.envOptions);

                    showSecondDialog(envList);
                    alert.dismiss();
                }

            }
        });


        return alert;
    }
    public interface CharityDialogListener {
        void onYesClicked();
        void getOrg(String a);

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
                listener.getOrg(choice);
                alert.dismiss();
            }
        });
        alert.show();

    }
}
