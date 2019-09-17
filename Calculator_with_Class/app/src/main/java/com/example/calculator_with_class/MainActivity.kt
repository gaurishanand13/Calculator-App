package com.example.calculator_with_class

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private var firstNum = 0.0
    private  var secondNum = 0.0
    private var currOp = '$'
    // This is the object of the calculator class we created so That we can use it.
    private val calcLogic = CalcLogic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachListeners()
        btnClr.setOnLongClickListener{
            firstNum = 0.0
            secondNum = 0.0
            currOp = '$'
            firstNumber.text = null
            secondNumber.text = null
            operationTextView.text = null

        }
    }
    private fun attachListeners(){
        //we could have easily done this. But always try to do in a more faster way and make sure your code is not so long
        /*btnClr.setOnClickListener(this)
        btnEq.setOnClickListener(this)
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMul.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)*/
        val arr = arrayOf(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnClr,btnDiv,btnSub,btnEq,btnMul)
        for(btn in arr)
        {
            btn.setOnClickListener(this);
        }
    }


    private fun displayNum(currNum:Int){
        if (currOp != '$'){
            secondNum = secondNum*10 + currNum
            secondNumber.text = secondNum.toString()
        }else{
            firstNum = firstNum*10 + currNum
            firstNumber.text = firstNum.toString()
        }
    }
    private fun displayOp(ch:Char)
    {
        if(currOp=='$')
        {
            operationTextView.text = ch.toString()
            currOp = ch
        }
        else
        {
            firstNumber.text = AnswerTextView.text
            secondNumber.text = null
            operationTextView.text = ch.toString()
            currOp = ch
            AnswerTextView.text = null
            firstNum = firstNumber.text.toString().toDouble()
            secondNum = 0.0
        }
    }
    override fun onClick(p0: View) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        when(p0.id){
            R.id.btn0 -> displayNum(0)
            R.id.btn1 -> displayNum(1)
            R.id.btn2 -> displayNum(2)
            R.id.btn3 -> displayNum(3)
            R.id.btn4 -> displayNum(4)
            R.id.btn5 -> displayNum(5)
            R.id.btn6 -> displayNum(6)
            R.id.btn7 ->displayNum(7)
            R.id.btn8 -> displayNum(8)
            R.id.btn9 -> displayNum(9)
            R.id.btnAdd -> displayOp('+')
            R.id.btnSub -> displayOp('-')
            R.id.btnMul -> displayOp('*')
            R.id.btnDiv -> displayOp('/')
            R.id.btnEq->{
                val result = calcLogic.evaluate(firstNum, secondNum,currOp)
                AnswerTextView.text = result.toString()
            }
            R.id.btnClr->{
                if (currOp != '$' && secondNum>0){
                    secondNum = secondNum/10
                    secondNumber.text = secondNum.toString()
                }else{
                    if(firstNum>0)
                    {
                        firstNum = firstNum/10
                        firstNumber.text = firstNum.toString()
                    }
                }
            }

        }
    }
}
