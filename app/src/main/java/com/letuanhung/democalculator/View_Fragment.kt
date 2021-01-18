package com.letuanhung.democalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import kotlinx.android.synthetic.main.view_fragment.*
import java.lang.Exception
import net.objecthunter.exp4j.ExpressionBuilder

class View_Fragment:Fragment() {

    private lateinit var txtExpr: TextView
    private lateinit var txtresult: TextView
    private var calc:Calc

    init{
        calc = Calc()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("Button"){
            key,bundle -> receive(bundle.getString("Text").toString())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.view_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtExpr = expression
        txtresult = result
    }

    fun receive(Text:String)
    {
        calc.add(Text)
        setView()
    }

    private fun setView()
    {
        txtExpr.setText(calc.expression)
        txtresult.setText(calc.result)
    }
}
