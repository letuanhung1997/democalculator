package com.letuanhung.democalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.button_fragment.*

class Button_Fragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.button_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listBtn: MutableList<Button> = ArrayList()
        listBtn.add(buttonDot)
        listBtn.add(button0)
        listBtn.add(button1)
        listBtn.add(button2)
        listBtn.add(button3)
        listBtn.add(button4)
        listBtn.add(button5)
        listBtn.add(button6)
        listBtn.add(button7)
        listBtn.add(button8)
        listBtn.add(button9)
        listBtn.add(buttonMulti)
        listBtn.add(buttonDiv)
        listBtn.add(buttonAdd)
        listBtn.add(buttonMinus)
        listBtn.add(buttonEqual)
        listBtn.add(buttonExp)
        listBtn.add(buttonOpen)
        listBtn.add(buttonClose)
        listBtn.add(buttonAC)
        setonClick(listBtn)
        buttonAC.setOnLongClickListener {
            SendText("C")
            true
        }
    }

    private fun SendText(Text:String)
    {
        setFragmentResult("Button", bundleOf("Text" to Text))
    }

    private fun setonClick(listBtn:MutableList<Button>) {
        for (item in listBtn!!)
            item.setOnClickListener {
                SendText(item.text.toString())
            }
    }
}
