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
        listBtn.add(button_dot)
        listBtn.add(button_0)
        listBtn.add(button_1)
        listBtn.add(button_2)
        listBtn.add(button_3)
        listBtn.add(button_4)
        listBtn.add(button_5)
        listBtn.add(button_6)
        listBtn.add(button_7)
        listBtn.add(button_8)
        listBtn.add(button_9)
        listBtn.add(button_multi)
        listBtn.add(button_div)
        listBtn.add(button_add)
        listBtn.add(button_minus)
        listBtn.add(button_equal)
        listBtn.add(button_exp)
        listBtn.add(button_open)
        listBtn.add(button_close)
        listBtn.add(button_ac)
        setonClick(listBtn)
        button_ac.setOnLongClickListener {
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
