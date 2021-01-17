package com.letuanhung.democalculator

import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class Calc {
    var expression=""
    var result = "0.0"
    var bracket = 0

    private fun addExpr(Text: String) {
        expression += Text
    }

    fun add(Text:String)
    {
        when (Text) {
            "=" -> {
                try {
                    var expr = ExpressionBuilder(processExpr()).build()
                    result = expr.evaluate().toString()
                }
                catch(E: Exception)
                {
                    result = "MATH ERROR"
                }
                expression=""
            }
            "AC"->DeleteText()
            "C"->Clear()
            else -> {
                if (checkText(Text)) {
                    if(Text=="(")
                        bracket++
                    if(Text!=")"||(Text==")"&&bracket-1>=0)){
                        if(Text==")")
                            bracket--
                        addExpr(Text)
                    }
                }
            }
        }
    }

    private fun processExpr():String{
        when(expression[0]){
            'x',':','+','-'->expression = result.toString()+expression
        }
        return expression.replace('x','*').replace(':','/')
    }

    private fun checkText(a: String): Boolean {
        if(expression.length==0)
            if (isNumber(a))
                return true
            else
                return when(a){
                    "+","-","x",":","√","(" -> true
                    else -> false
                }

        var temp = expression[expression.length - 1].toString()
        when (temp) {
            "." -> return if (isNumber(a)) true else false
            "x", ":", "+", "-", "^", "√", "(" -> return if (isNumber(a) || a == "(" || a == "√") true else false
            else -> {
                when (a) {
                    "x", ":", "+", "-", "^", ")" -> return true
                    else -> return if(isNumber(temp)&&a=="(") false else true
                }
            }
        }
    }

    private fun DeleteText()
    {
        if(expression.length>0) {
            if(expression[expression.length-1]=='(')
                bracket--
            else if(expression[expression.length-1]==')')
                bracket++
            expression = expression.removeRange(expression.length - 1, expression.length)
        }
    }

    private fun Clear()
    {
        expression=""
        result="0.0"
    }
    private fun isNumber(a:String):Boolean
    {
        try {
            a.toDouble()
            return true
        }
        catch(E: Exception)
        {
            return false
        }
    }
}
