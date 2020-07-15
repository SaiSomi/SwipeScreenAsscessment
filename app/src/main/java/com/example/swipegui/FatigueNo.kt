package com.example.swipegui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_1.*
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.fragment_3.*
import kotlinx.android.synthetic.main.fragment_4.*


class FatigueNo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textview5.text = ""
        textview90.text = "No"
        fragment4.setBackgroundColor(Color.GREEN)
    }
}