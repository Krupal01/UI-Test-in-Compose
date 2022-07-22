package com.example.composetesting

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import java.util.*
const val TEST_TAG_DATE_PICKER = "TEST TAG DATE PICKER"
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DatePicker(
    modifier : Modifier = Modifier,
    date : MutableState<Int> ,
    month : MutableState<Int>,
    year: MutableState<Int> ,
) {

    val calendar = Calendar.getInstance()
    val context = LocalContext.current
    val currentDate = calendar.get(Calendar.DATE)
    val currentMonth = calendar.get(Calendar.MONTH)
    val currentYear = calendar.get(Calendar.YEAR)

    val datePickerDialog = DatePickerDialog(
        context,{ _:DatePicker,year1 : Int ,month1:Int, dateOfMonth:Int->
            date.value = dateOfMonth
            month.value = month1
            year.value = year1

        },currentYear,currentMonth,currentDate
    )

    
    Button(
        modifier = modifier,
        onClick = {
            datePickerDialog.show()
        }
    ) {
        Text(text = "Open Date Picker ${date.value}/${month.value}/${year.value} ")
    }
    
}