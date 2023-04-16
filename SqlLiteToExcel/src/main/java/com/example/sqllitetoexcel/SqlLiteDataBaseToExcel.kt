package com.example.sqllitetoexcel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.apache.poi.hssf.usermodel.HSSFWorkbook

open class SqlLiteDataBaseToExcel(private val activity: AppCompatActivity?, private val fragment: Fragment?, private val cursor: Cursor, private val name : String,private val context: Context) {

    private var launcher : ActivityResultLauncher<Intent>? = null
    init {
        launcher = activity?.registerForActivityResult(ActivityResultContracts.StartActivityForResult()
        ) {
            it.data?.data?.let { uri -> writeCSV(uri) }
        }
            ?: fragment?.registerForActivityResult(ActivityResultContracts.StartActivityForResult()
            ) {
                it.data?.data?.let { uri -> writeCSV(uri) }
            }
    }

    fun createExcel(){
        try {
            val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.putExtra(Intent.EXTRA_TITLE,"${name}7.xls")
            intent.type = "application/xls"
            launcher?.launch(intent)

        }catch (e : java.lang.Exception){
            println(e.message)
        }

    }
    private fun writeCSV(uri : Uri){
        try {
            val colName = cursor.columnNames
            val workBook = HSSFWorkbook()
            val sheet = workBook.createSheet("a")
            var rowCount = 0
            var row = sheet.createRow(rowCount)
            cursor.moveToFirst()
            for ((col, text) in colName.withIndex()){
                val cell = row.createCell(col)
                cell.setCellValue(text)
            }
            while (cursor.moveToNext()){
                rowCount++
                row = sheet.createRow(rowCount)
                var colCount = 0
                while (colCount < cursor.columnCount){
                    val cell = row.createCell(colCount)
                    cell.setCellValue(cursor.getString(colCount))
                    colCount++
                }
            }

            if (activity != null)
                workBook.write(activity.contentResolver.openOutputStream(uri))
            else if(fragment != null)
                workBook.write(fragment.activity?.contentResolver?.openOutputStream(uri))

        }catch (e : java.lang.Exception){
            println(e.message)
        }

    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK)
            data?.data?.let { writeCSV(it) }
    }
}