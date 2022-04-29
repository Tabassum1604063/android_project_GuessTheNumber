package com.example.guessthenumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assinnubertobuttons()

        btnleft.setOnClickListener{
            checkanswer(isleftbtnselected = true)
            assinnubertobuttons()

        }
        btnright.setOnClickListener{
            checkanswer(isleftbtnselected=false)
            assinnubertobuttons()
        }


    }

    private fun checkanswer(isleftbtnselected: Boolean) {
        val leftnum = btnleft.text.toString().toInt()
        val rightnum = btnright.text.toString().toInt()
        val isAnswerCorrect = if (isleftbtnselected) leftnum>rightnum else rightnum>leftnum
        if(isAnswerCorrect)
        {
            Toast.makeText(this,"Correct!!",Toast.LENGTH_SHORT).show()
            backgroundView.setBackgroundColor(Color.BLUE)

        }
        else
        {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
            backgroundView.setBackgroundColor(Color.YELLOW)
        }
    }

    private fun assinnubertobuttons() {
        val r = Random()
        val leftnum = r.nextInt(10)
        var rightnum = r.nextInt(10)
        while(leftnum==rightnum)
        {
            var rightnum=r.nextInt(10)
        }
        btnleft.text= leftnum.toString()
        btnright.text= rightnum.toString()
    }

}

