package com.example.baitap_su_ly_su_kien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText PTT, PTSDT, PTCT;
    Button BTDY, BTH;
    RadioButton RBTN, RBTN2;
    Spinner SNQT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTDY = (Button) findViewById(R.id.BTDY);
        BTH = (Button) findViewById(R.id.BTH);
        PTT = (EditText) findViewById(R.id.PTT);
        PTSDT = (EditText) findViewById(R.id.PTSDT);
        PTCT = (EditText) findViewById(R.id.PTCT);
        RBTN = (RadioButton) findViewById(R.id.RBTN);
        RBTN2 = (RadioButton) findViewById(R.id.RBTN2);
        SNQT = (Spinner) findViewById(R.id.SNQT);
        List<String> list = new ArrayList<String>();
        list.add("Việt Nam");
        list.add("USA");
        list.add("Nhật Bản");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SNQT.setAdapter(dataAdapter);
    }

    public void BTDY(View view) {
        String msg = "Tên: " + PTT.getText().toString() +
                System.getProperty("line.separator") +
                "SDT: " + PTSDT.getText().toString()  +"\n";
        if(RBTN.isChecked())
            msg +="Giới Tính : "+ RBTN.getText().toString();
        else
            msg +="Giới Tính : " + RBTN2.getText().toString() +"\n";

        msg += System.getProperty("line.separator") + "Quốc Tịch: " +
                SNQT.getSelectedItem().toString() + "\n";
        msg+= "Chú Thích : " +PTCT.getText().toString();
        info(view,msg);
        PTT.setText("");
        PTSDT.setText("");
        RBTN.setChecked(false);
        RBTN2.setChecked(false);
    }

    public void info(View v, String msg) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thông Báo");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    public void BTH(View view) {
        System.exit(0);
    }
}
