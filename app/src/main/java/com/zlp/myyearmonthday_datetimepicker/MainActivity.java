package com.zlp.myyearmonthday_datetimepicker;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends FragmentActivity implements View.OnClickListener,
        DateTimeDialogOnlyYMD.MyOnDateSetListener, DateTimeDialogOnlyTime.MyOnDateSetListener, DateTimeDialog.MyOnDateSetListener {
    private Button mButton1, mButton2, mButton3, mButton4, mButton5;
    private TextView time;
    // 日期 格式化 工具
    private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
    private DateTimeDialogOnlyYMD dateTimeDialogOnlyYM;
    private DateTimeDialogOnlyYMD dateTimeDialogOnlyYMD;
    private DateTimeDialogOnlyYMD dateTimeDialogOnlyYear;
    private DateTimeDialogOnlyYMD dateTimeDialogOnlyMonth;
    private DateTimeDialogOnlyYMD dateTimeDialogOnlyDay;
    private DateTimeDialogOnlyTime dateTimeDialogOnlyTimeHMS;
    private DateTimeDialog dateTimeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        time = (TextView) findViewById(R.id.time);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);

        dateTimeDialogOnlyYMD = new DateTimeDialogOnlyYMD(this, this, true, true, true);
        dateTimeDialogOnlyYM = new DateTimeDialogOnlyYMD(this, this, false, true, true);
        dateTimeDialogOnlyYear = new DateTimeDialogOnlyYMD(this, this, false, false, true);
        dateTimeDialogOnlyMonth = new DateTimeDialogOnlyYMD(this, this, false, true, false);
        dateTimeDialogOnlyDay = new DateTimeDialogOnlyYMD(this, this, true, false, false);
        dateTimeDialogOnlyTimeHMS = new DateTimeDialogOnlyTime(this, this, true, false, false);


        dateTimeDialog = new DateTimeDialog(this, null, this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                showYMD();
                break;
            case R.id.button2:
                showYM();
                break;
            case R.id.button3:
                showYear();
                break;
            case R.id.button4:
                showMonth();
                break;
            case R.id.button5:
                showDay();
                break;
            case R.id.button6:
                showHourMinuteSecond();
                break;
            case R.id.button7:
                showAll();
                break;

        }
    }

    private void showAll() {
        dateTimeDialog.hideOrShow();
    }

    private void showHourMinuteSecond() {
        dateTimeDialogOnlyTimeHMS.hideOrShow();
    }

    private void showDay() {
        dateTimeDialogOnlyDay.hideOrShow();
    }

    private void showMonth() {
        dateTimeDialogOnlyMonth.hideOrShow();
    }

    private void showYear() {
        dateTimeDialogOnlyYear.hideOrShow();
    }


    private void showYM() {
        dateTimeDialogOnlyYM.hideOrShow();
    }


    private void showYMD() {
        dateTimeDialogOnlyYMD.hideOrShow();
    }


    @Override
    public void onDateSet(Date date) {
        time.setText(mFormatter.format(date) + "");
    }
}

