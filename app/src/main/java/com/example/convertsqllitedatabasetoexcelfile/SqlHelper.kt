package com.example.convertsqllitedatabasetoexcelfile

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.sqllitetoexcel.SqlLiteDataBaseToExcel
import org.apache.commons.collections.CursorableLinkedList.Cursor

@RequiresApi(Build.VERSION_CODES.P)
open class SqlHelper(
    val context: Context?,
    val name: String?,
    val version: Int
) : SQLiteOpenHelper(context,name,null,version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val st = "Create Table Student('name' TEXT, 'rollNo' Email)"
        p0?.execSQL(st)
    }

    fun write(p0 : SQLiteDatabase){
        val value = ContentValues()
        value.put("name","Vipul")
        value.put("rollNo","andypat57@gmail.com")
        println(p0.insert("Student",null,value))
    }

    fun getData(p0 : SQLiteDatabase) : android.database.Cursor? {
        val st = "Select * From Student"
        return  p0.rawQuery(st,null)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}