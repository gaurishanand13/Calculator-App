package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operationPerformed = "";
    var Number = 0
    var number_in_double = 0.0
    var NumberTyped = false;

    public fun clickFunction(v:View) {
        var a = textView.text.toString()
        var b= (v as Button).text.toString();
        textView.text = a + b
        NumberTyped = true
    }
    public fun operationFunction(v:View) {
        if(NumberTyped)
        {
            Number = textView.text.toString().toInt()
            textView.text = null
            operationPerformed = (v as Button).getTag().toString() //here we have first type casted the view as button
        }
    }
    public fun equalClick(v:View) {
        var b=textView.text.toString().toInt();
            if(operationPerformed.equals("1"))
            {
                Number =  Number + b;
            }
            if(operationPerformed.equals("2"))
            {
                Number =  Number - b;
            }
            if(operationPerformed.equals("3"))
            {
                Number =  Number * b;
            }
            if(operationPerformed.equals("4"))
            {
                if(b===0)
                {
                    Toast.makeText(applicationContext,"A number can't be divided by zero",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Number =  Number / b;
                }
            }
        textView.text = Number.toString()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cancel.setOnClickListener{
            var a = textView.text.toString()
            var size = a.length
            if(size == 0)
            {
                return@setOnClickListener
            }
            if(size == 1)
            {
                textView.text = null
                return@setOnClickListener
            }
            textView.text = a.substring(0,size-1)
        }
        cancel.setOnLongClickListener{
            textView.text = null
            false
        }
    }
}
