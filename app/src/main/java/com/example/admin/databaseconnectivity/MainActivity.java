package com.example.admin.databaseconnectivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends bill {

    EditText name_et,quan_et,rate_et;
    //ListView name_l;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_et=(EditText) findViewById(R.id.name_et);
        quan_et=(EditText) findViewById(R.id.quan_et);
        rate_et=(EditText) findViewById(R.id.rate_et);


        //SQLiteDatabase sqLiteDatabase1=getBaseContext().openOrCreateDatabase("bill",MODE_PRIVATE,null);
        SQLiteDatabase sqLiteDatabase= getBaseContext().openOrCreateDatabase("sqlite-bill.db",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("DROP TABLE bill_tab");

        sqLiteDatabase.execSQL("CREATE TABLE bill_tab (Item_Name VARCHAR2,Quantity INTEGER, Price INTEGER, Amount INTEGER)");

    }

    /*public void check(View view){
        SQLiteDatabase sqLiteDatabase= getBaseContext().openOrCreateDatabase("sqlite-bill.db",MODE_PRIVATE,null);
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM bill_tab", null);
        if(query.moveToFirst())
        {
            do {
                String Item_Name = query.getString(0);
                String Quantity = query.getString(1);
                String Price = query.getString(2);
                String Amount = query.getString(3);
                Toast.makeText(getBaseContext(), "Item= " + Item_Name + "Quantity= " + Quantity + "Price= " + Price + "Amount= " + Amount, Toast.LENGTH_LONG).show();
            }while (query.moveToNext());
        }else
        {
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_LONG).show();
        }
        sqLiteDatabase.close();

    }*/



    //public final static String EXTRA_MESSAGE="label";

    public void bill(View view)
    {
        Intent intent=new Intent(this,bill.class);
        startActivity(intent);
    }


    /*public void bill(View view) {

        //Intent intent = new Intent(this, bill.class);
        //String EXTRA_MESSAGE="label";
        //intent.putExtra(EXTRA_MESSAGE,"message to be passed");

        //Intent intentl = new Intent(this, bill.class);
//        int l=0;
//        String [] name=new String[25];
//        String [] quant=new String[25];
//        String [] rat=new String[25];
//        String [] amnt=new String[25];
        SQLiteDatabase sqLiteDatabase= getBaseContext().openOrCreateDatabase("sqlite-bill.db", MODE_PRIVATE, null);
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM bill_tab", null);
        if(query.moveToFirst())
        {
            do {
                String Item_Name = query.getString(0);
                String Quantity = query.getString(1);
                String Price = query.getString(2);
                String Amount = query.getString(3);
                Toast.makeText(getBaseContext(), "Item= " + Item_Name + " Quantity= " + Quantity + " Price= " + Price + " Amount= " + Amount, Toast.LENGTH_LONG).show();
//                name[l]=Item_Name;
//                quant[l]=Quantity;
//                rat[l]=Price;
//                amnt[l]=Amount;
                //intent.putExtra(EXTRA_MESSAGE,"  "+ Item_Name +"  "+ Quantity +"  "+ Price +"  "+ Amount+" ");
                //l++;
            }while(query.moveToNext());
        }else
        {
            Toast.makeText(getBaseContext(),"Error retrieving data", Toast.LENGTH_LONG).show();
        }
        //startActivity(intent);
    }*/

    public void clear(View view) {
        name_et.setText("");
        rate_et.setText("");
        quan_et.setText("");
    }

    public void submit(View view) {
        SQLiteDatabase sqLiteDatabase= getBaseContext().openOrCreateDatabase("sqlite-bill.db", MODE_PRIVATE, null);
        String name=name_et.getText().toString();
        String quan=quan_et.getText().toString();
        String rate=rate_et.getText().toString();
        int amt=Integer.parseInt(quan)*Integer.parseInt(rate);
        if(name.equals("")||quan.equals("")||rate.equals("")||(amt==0)){
            Toast.makeText(getBaseContext(),"Please Enter Data In Each Field Or Enter Correct Data",Toast.LENGTH_LONG).show();
            return;
        }
        sqLiteDatabase.execSQL("INSERT INTO bill_tab VALUES ('" + name + "','" + quan + "','" + rate + "','" + amt + "')");
        Toast.makeText(getBaseContext(), "Item= " + name + " Quantity= " + quan + " Price= " + rate + " Amount= " + amt, Toast.LENGTH_LONG).show();
        sqLiteDatabase.close();

    }














}

