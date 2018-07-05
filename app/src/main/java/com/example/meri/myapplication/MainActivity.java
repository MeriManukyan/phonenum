package com.example.meri.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final  String Name="name";
    final  String Number="number";
    Intent intent;
    Cursor cursor11;
    ListView listView;
SimpleAdapter adapter;
    ArrayList<String> name=new ArrayList<>();
        ArrayList<String> number=new ArrayList<>();
        List<Map<String,String>> data=new ArrayList<>();
        Map<String,String >map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name.add("fgugf");
        name.add("guguytgu");
        number.add("87689");
        number.add("67568");
        for(int i=0;i<name.size();i++){
            map=new HashMap<>();
            map.put(Name,name.get(i));
            map.put(Number,number.get(i));
            data.add(map);
        }
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent=new Intent(getApplicationContext(),Main2Activity.class);
                 startActivity(intent);
            }
        });

        listView=findViewById(R.id.y);

        db a=new db(this);
int i=0;
 ContentValues cv=new ContentValues();
 SQLiteDatabase sql=a.getWritableDatabase();
 cv.put(db.a,"ghkjhk");
 cv.put("phone","7987");
 sql.insert("mytable",null,cv);

 //b.setText(i+"");
 cursor11=sql.query("mytable", null, null, null, null, null, null);
       String from1[]={db.a,db.b};
       int to1[]={R.id.name,R.id.number};
      // sql=a.getReadableDatabase();
        if(cursor11.moveToFirst() ){
            SimpleCursorAdapter sa = new SimpleCursorAdapter(this, R.layout.mm, cursor11, from1, to1);
listView.setAdapter(sa);
//
        }
//
 String from[]={Name,Number};
        int to[]={R.id.name,R.id.number};
        adapter=new SimpleAdapter(this,data,R.layout.mm, from,to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String number=((TextView)view.findViewById(R.id.number)).getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        })  ;


    }
}
