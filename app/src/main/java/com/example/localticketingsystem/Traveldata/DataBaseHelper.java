package com.example.localticketingsystem.Traveldata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DataBaseName="regester.db";
    public DataBaseHelper(Context context) {
        super(context,DataBaseName, null, VERSION);
    }

    public static int C2I(String s){
        return Integer.parseInt(s);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String RegisterCreateTable=
                "create table " + DatabaseSchma.RegesterationTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        DatabaseSchma.RegesterationTable.Cols.UUID + " integer unique, " +
                        DatabaseSchma.RegesterationTable.Cols.NAME+" not null, "+
                        DatabaseSchma.RegesterationTable.Cols.PASSWORD+" not null, "+
                        DatabaseSchma.RegesterationTable.Cols.ADDRESS+" not null, "+
                        DatabaseSchma.RegesterationTable.Cols.AGE+" not null, "+
                        DatabaseSchma.RegesterationTable.Cols.MOBILENO+" integer unique not null, "+
                        DatabaseSchma.RegesterationTable.Cols.CARDNO+" integer unique not null"+
                        ");";

        String CREATE_BOOKING_TABLE =
                "CREATE TABLE " + DatabaseSchma.BookingTable.NAME + "( " +
                        " _id integer primary key autoincrement, " +
                        DatabaseSchma.BookingTable.Cols.ticketId + " INTEGER unique, " +
                        DatabaseSchma.BookingTable.Cols.lineType + " TEXT, " +
                        DatabaseSchma.BookingTable.Cols.fromStation + " TEXT, " +
                        DatabaseSchma.BookingTable.Cols.toStation + " TEXT, " +
                        DatabaseSchma.BookingTable.Cols.ticketCost + " INTEGER, " +
                        DatabaseSchma.BookingTable.Cols.journyType + " TEXT, " +
                        DatabaseSchma.BookingTable.Cols.total + " INTEGER, " +
                        DatabaseSchma.BookingTable.Cols.balance + " INTEGER, " +
                        DatabaseSchma.BookingTable.Cols.date + " TEXT " +
                        " );";

        db.execSQL(RegisterCreateTable);
        db.execSQL(CREATE_BOOKING_TABLE);
        Log.v(DataBaseHelper.class.getSimpleName(),"DataBase Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

