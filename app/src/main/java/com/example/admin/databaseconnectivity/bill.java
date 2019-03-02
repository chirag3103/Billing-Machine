package com.example.admin.databaseconnectivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class bill extends AppCompatActivity {
    ListView bill_l;
    //Button billg=(Button)findViewById(R.id.billg);



    public void trialclick(View v)
    {
        SQLiteDatabase sqLiteDatabase= getBaseContext().openOrCreateDatabase("sqlite-bill.db",MODE_PRIVATE,null);
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM bill_tab", null);
        int c=query.getCount();
        String [] myStringArray=new String[c];
        int i=0;
        if(query.moveToFirst())
        {
            do {
                String Item_Name = query.getString(0);
                String Quantity = query.getString(1);
                String Price = query.getString(2);
                String Amount = query.getString(3);
                String s=i+1+"            " + Item_Name + "             " + Quantity + "  *  " + Price + "   =       " + Amount;
                //Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
                //String[]  myStringArray={s,"B","C"};
                myStringArray[i]=s;
                ArrayAdapter<String> myAdapter=new
                        ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        myStringArray);
                bill_l=(ListView) findViewById(R.id.bill_l);
                bill_l.setAdapter(myAdapter);
                i++;
            }while (query.moveToNext()&&(i<=query.getCount()));

        }else
        {
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_LONG).show();
        }


        sqLiteDatabase.close();
    }

    public void total(View view)
    {
        SQLiteDatabase sqLiteDatabase= getBaseContext().openOrCreateDatabase("sqlite-bill.db",MODE_PRIVATE,null);
        TextView total=(TextView)findViewById(R.id.total);
        //total.setText("sqLiteDatabase.execSQL(SELECT sum(Amount) from bill_tab)");
        //sqLiteDatabase.execSQL("SELECT sum(Amount) as total from bill_tab");
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM bill_tab", null);
        int Total=0;
        //for(int i=0;i<=query.getCount();i++)
        //{
            //String Amount = query.getString(3);
            //Total=Integer.parseInt(query.getString(3));
        //}
        if(query.moveToFirst()) {
            do {
                Total+=Integer.parseInt(query.getString(3));

            } while (query.moveToNext());
        }

        String message = "" + Total + "";
        total.setText(message);

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }
    }
