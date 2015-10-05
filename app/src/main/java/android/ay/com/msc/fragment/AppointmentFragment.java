package android.ay.com.msc.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.ay.com.msc.R;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class AppointmentFragment extends DialogFragment implements View.OnClickListener {

    private Spinner doctorsNameSpinner;
    static final int DATE_PICKER_ID = 1111;
    private int year;
    private int month;
    private int day;
    private View view;
    private EditText appoinmentDateEditText;
    private Button appointmentButton;

    public AppointmentFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {

            view = inflater.inflate(R.layout.fragment_appointment, container, false);


            final Calendar c = Calendar.getInstance();
            year  = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day   = c.get(Calendar.DAY_OF_MONTH);


            UIInitialize();

            return view;

        }catch (Exception w){
            w.printStackTrace();
            return null;
        }

    }

    private void UIInitialize()throws Exception{
        try {

            doctorsNameSpinner     = (Spinner) view.findViewById(R.id.doctorsNameSpinner);
            appoinmentDateEditText = (EditText) view.findViewById(R.id.appoinmentDateEditText);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    getActivity(), R.array.doctors, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            doctorsNameSpinner.setAdapter(adapter);

            appoinmentDateEditText.setOnClickListener(this);


            appointmentButton = (Button) view.findViewById(R.id.appointmentButton);
            appointmentButton.setOnClickListener(this);

        }catch (Exception e){
            throw  e;
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appoinmentDateEditText :


                DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {

                        year  = selectedYear;
                        month = selectedMonth;
                        day   = selectedDay;

                        String monthVal,dayVal;

                        if ((day) < 10){
                            dayVal = "0"+(day);
                        }else{
                            dayVal = ""+(day);
                        }

                        if ((month + 1) < 10){
                            monthVal = "0"+(month + 1);
                        }else{
                            monthVal = ""+(month + 1);
                        }

                        appoinmentDateEditText.setText(new StringBuilder().append(year)
                                .append("-").append(monthVal).append("-").append(dayVal)
                                .append(" "));

                    }
                },year, month, day);
                mDatePicker.getDatePicker().setCalendarViewShown(false);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();


                break;

            case R.id.appointmentButton :

                String date = appoinmentDateEditText.getText().toString();

                if (doctorsNameSpinner.getSelectedItemPosition() == 0){

                    Toast.makeText(getActivity(),"Please select doctor",
                            Toast.LENGTH_LONG).show();

                }else if(date.isEmpty()){

                    Toast.makeText(getActivity(),"Please enter date",
                            Toast.LENGTH_LONG).show();

                }else{

                    showAlert((String)doctorsNameSpinner.getSelectedItem(),date);

                }

                break;

            default:
                break;
        }
    }


    private void showAlert(String doctor,String date) {
        try {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    getActivity());

            alertDialogBuilder.setTitle("Appointment Confirm");
            alertDialogBuilder
                    .setMessage("Doctor : "+doctor+"\nDate : "+date)
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();




        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;

            String monthVal,dayVal;

            if ((day) < 10){
                dayVal = "0"+(day);
            }else{
                dayVal = ""+(day);
            }

            if ((month + 1) < 10){
                monthVal = "0"+(month + 1);
            }else{
                monthVal = ""+(month + 1);
            }

            appoinmentDateEditText.setText(new StringBuilder().append(year)
                    .append("-").append(monthVal).append("-").append(dayVal)
                    .append(" "));

        }
    };
}
