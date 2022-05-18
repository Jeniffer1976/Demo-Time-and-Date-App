package sg.edu.rp.c346.id21025290.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate, btnDisplayTime, btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        btnReset = findViewById(R.id.buttonReset);
        tvDisplay = findViewById(R.id.textViewDisplay);

        btnDisplayTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String displayTime;
                if(tp.getCurrentMinute() < 10){
                    displayTime = "Time is "+tp.getCurrentHour().toString()+":0"+tp.getCurrentMinute().toString();
                } else {
                    displayTime = "Time is " + tp.getCurrentHour().toString() + ":" + tp.getCurrentMinute().toString();
                }
                tvDisplay.setText(displayTime);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayDate = "Date is "+dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear();
                tvDisplay.setText(displayDate);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,0,1);
            }
        });
    }

}