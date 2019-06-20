package com.example.sunita.dbapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.sunita.dbapp.database.MyDatabase;

public class MainActivity extends AppCompatActivity {
    MyDatabase mdb=new MyDatabase(this);
    Cursor cursor;
    SimpleCursorAdapter sca;
    EditText etname,etadress,etsalary;
    Button btnInsert;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.editText);
        etadress=findViewById(R.id.editText2);
        etsalary=findViewById(R.id.editText5);
        lv=findViewById(R.id.ListviewEmployees);
        btnInsert=findViewById(R.id.button2);

        mdb.open();


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //string variables to store edittext values
                String stname= etname.getText().toString();
                String stadress=etadress.getText().toString();
                Integer stsalary= Integer.parseInt(etsalary.getText().toString());

                ContentValues cv=new ContentValues();

                cv.put("emp_name",stname);
                cv.put("emp_location",stadress);
                cv.put("emp_salary",stsalary);

                mdb.insertEmp(cv);

                //clear values
                etname.setText(null);
                etadress.setText(null);
                etsalary.setText(null);

                //next value
                cursor.requery();

            }
        });

        //fetch the data and display  on the listview
        cursor=mdb.getEmp();

        String[] dbref={"emp_name","emp_location","emp_salary"};
        int[] tbref={R.id.textViewName,R.id.textViewAdress,R.id.textViewSalary};
        sca=new SimpleCursorAdapter(this,R.layout.row,cursor,dbref,tbref);

        lv.setAdapter(sca);
        //notify the user that data has channged
        sca.notifyDataSetChanged();
        cursor.requery();
    }
}
