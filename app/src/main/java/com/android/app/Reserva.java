package com.android.app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Reserva extends AppCompatActivity implements View.OnClickListener {


   private  EditText selectdate,ehora1,ehora2,eti_patente;
   Button btnentrada,btnsalida,btnfecha,btn_cancelar,btnPago;





   private int hora1, minuto1,hora2,minuto2,dia,mes,ano;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        btnentrada=(Button)findViewById(R.id.btnentrada);
        btnfecha=(Button)findViewById(R.id.btnfecha);
        btnsalida=(Button)findViewById(R.id.btnsalida);
        btn_cancelar=(Button)findViewById(R.id.btn_cancelar);
        btnPago=(Button)findViewById(R.id.btnPago);

        selectdate = findViewById(R.id.selectdate);
        ehora1 = findViewById(R.id.ehora1);
        ehora2 = findViewById(R.id.ehora2);
        eti_patente = findViewById(R.id.eti_patente);


        btnentrada.setOnClickListener(this);
        btnsalida.setOnClickListener(this);
        btnfecha.setOnClickListener(this);
        btn_cancelar.setOnClickListener(this);
        btnPago.setOnClickListener(this);

        btnPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), pasarela_de_pago.class);
                startActivityForResult(intent, 0);
            }
        });



    }






    @Override
    public void onClick(View v) {
            if (v==btnfecha){
                final Calendar c = Calendar.getInstance();

                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano=c.get(Calendar.YEAR);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        selectdate.setText((dayOfMonth)+"/"+(monthOfYear+1)+"/"+year);

                    }

                }
                ,dia,mes,ano);


                Calendar calendarioMax = Calendar.getInstance();
                calendarioMax.add(Calendar.MONTH, +1);


                datePickerDialog.getDatePicker().setMaxDate(calendarioMax.getTimeInMillis() -1000);
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis()- 1000);


                datePickerDialog.show();





            }
            if(v==btnentrada) {
                final Calendar c=Calendar.getInstance();
                hora1=c.get(Calendar.HOUR_OF_DAY);
                minuto1=c.get(Calendar.MINUTE);


                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar tiempomin = Calendar.getInstance();

                        tiempomin.add(Calendar.HOUR_OF_DAY, +2);
                        tiempomin.add(Calendar.MINUTE,+2);


                        ehora1.setText(((hourOfDay > 12) ? hourOfDay : hourOfDay) + ":" + (minute < 10 ? ("0" + minute) : minute) + " " + ((hourOfDay >= 12) ? "PM" : "AM"));


                    }
                },hora1,minuto1,true);






                timePickerDialog.show();



            }
            if (v==btnsalida) {
                final Calendar c=Calendar.getInstance();
                hora2=c.get(Calendar.HOUR_OF_DAY);
                minuto2=c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ehora2.setText(((hourOfDay > 12) ? hourOfDay : hourOfDay) + ":" + (minute < 10 ? ("0" + minute) : minute) + " " + ((hourOfDay >= 12) ? "PM" : "AM"));







                    }
                },hora2,minuto2,true);
                timePickerDialog.show();





            }
            if (v==btn_cancelar){
                limpiart();


            }


    }
    private void limpiart() {
        ehora1.setText("");
        ehora2.setText("");
        selectdate.setText("");
        eti_patente.setText("");

    };





}
