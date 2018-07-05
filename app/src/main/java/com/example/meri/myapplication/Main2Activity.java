package com.example.meri.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;

public class Main2Activity extends AppCompatActivity {
    EditText editText,editText1;
    db ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f);
        ba=new db(this);
        editText=findViewById(R.id.editText);
        editText1=findViewById(R.id.editText2);
        Button b=findViewById(R.id.button9);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv=new ContentValues();
                SQLiteDatabase d=ba.getWritableDatabase();
                cv.put(db.a,editText.getText().toString());
                cv.put(db.b,editText1.getText().toString());
                d.insert("mytable",null,cv);
                finish();
            }
        });
    }
}
