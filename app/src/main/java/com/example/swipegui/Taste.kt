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
import kotlinx.android.synthetic.main.fragment_5.*
import kotlinx.android.synthetic.main.fragment_6.*


class Taste : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_6, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textview7.text = "Loss of Taste/Smell"
    }
}