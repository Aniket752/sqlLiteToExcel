package com.example.convertsqllitedatabasetoexcelfile

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.sqllitetoexcel.SqlLiteDataBaseToExcel

class MainActivity : AppCompatActivity() {
    lateinit var sqlLiteDataBaseToExcel: SqlLiteDataBaseToExcel
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sql = SqlHelper(this,"Student",3)
        sql.write(sql.writableDatabase)
        val data = sql.getData(sql.readableDatabase)
        data?.let {
           sqlLiteDataBaseToExcel = SqlLiteDataBaseToExcel(this,null, it,"Student")
            sqlLiteDataBaseToExcel.createExcel()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            sqlLiteDataBaseToExcel.onActivityResult(requestCode, resultCode, data)
    }
}