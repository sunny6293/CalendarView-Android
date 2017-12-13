package com.example.user.mycalendaview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.listeners.OnNavigationButtonClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar cal;
        List<EventDay> eList =new ArrayList<>();//維護需要標註日期的日子的清單

        //標註日期
        cal = Calendar.getInstance();
        cal.set(2017,12,5);
        eList.add(new EventDay(cal, R.drawable.aa));
        cal = Calendar.getInstance();
        cal.set(2017,12,4);
        eList.add(new EventDay(cal, R.drawable.aa));

        CalendarView mycld= (CalendarView) findViewById(R.id.myCalenader);
        mycld.setEvents(eList);

        mycld.setOnDayClickListener(mDay);//點選日期
        mycld.setOnForwardButtonClickListener(mNM);//點選下個月
        mycld.setOnPreviousButtonClickListener(mPM);//點選上個月

    }
    OnDayClickListener mDay =new OnDayClickListener() {
        @Override
        public void onDayClick(EventDay eventDay) {
            Calendar cid=eventDay.getCalendar();
            int yyy,mmm,ddd;
            yyy=cid.get(Calendar.YEAR);
            mmm=cid.get(Calendar.MONTH);
            ddd=cid.get(Calendar.DAY_OF_MONTH);
        }
    };
    OnNavigationButtonClickListener mNM= new OnNavigationButtonClickListener() {
        @Override
        public void onClick() {//下個月
            CalendarView mycld= (CalendarView) findViewById(R.id.myCalenader);
            Calendar cid= mycld.getCurrentPageDate();
            int mmm;
            mmm=cid.get(Calendar.MONTH);
        }
    };
    OnNavigationButtonClickListener mPM= new OnNavigationButtonClickListener() {
        @Override
        public void onClick() {

        }
    };
}
