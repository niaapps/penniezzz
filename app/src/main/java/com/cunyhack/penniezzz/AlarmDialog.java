package com.cunyhack.penniezzz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;


import androidx.appcompat.app.AppCompatDialogFragment;

public class AlarmDialog  extends AppCompatDialogFragment {

    private AlarmDialogListener listener;
    Button save;
    Spinner interval;
    TimePicker timePicker;
    String time = "";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Configure Alarm Settings");

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.alarm_dialog_setup, null);
        builder.setView(view);
        timePicker = view.findViewById(R.id.timePicker);


        save = view.findViewById(R.id.save);
        interval = view.findViewById(R.id.intervalSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.intervals));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interval.setAdapter(adapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Integer alarmHours = timePicker.getCurrentHour();
                Integer alarmMins = timePicker.getCurrentMinute();
                String mins ="0";
                if(alarmMins<10){mins = mins.concat(alarmMins.toString()); }
                else{ mins = alarmMins.toString();}
                if(alarmHours>12){
                    alarmHours = alarmHours-12;
                    time = alarmHours.toString().concat(":").concat(mins).concat(" PM");
                }else if(alarmHours == 12){
                    time = alarmHours.toString().concat(":").concat(mins).concat(" PM");
                }else{
                    time = alarmHours.toString().concat(":").concat(mins).concat(" AM");
                }
                listener.applyTexts(time, interval.getSelectedItem().toString());
                dismiss();
            }
        });


        return builder.create();
    }



    public interface AlarmDialogListener {
        void onYesClicked();
        void applyTexts(String a, String b);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (AlarmDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implement AlarmDialogListener");
        }
    }
}
