package com.example.swipegui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileWriter
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Self-Assessment")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        val adapter2 = MyViewPagerAdapter(supportFragmentManager)
        val adapter3 = MyViewPagerAdapter(supportFragmentManager)
        val adapter4 = MyViewPagerAdapter(supportFragmentManager)
        val adapter5 = MyViewPagerAdapter(supportFragmentManager)
        val adapter6 = MyViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(AchesNo(), " One ")
        adapter.addFragment(Aches(), " Two ")
        adapter.addFragment(AchesYes(), " Three ")
        adapter2.addFragment(BreathingNo(), " Four ")
        adapter2.addFragment(Fragment4(), " Five ")
        adapter2.addFragment(Breathingyes(), " Six ")
        adapter3.addFragment(CoughingNo(), " Seven ")
        adapter3.addFragment(Coughing(), " Eight ")
        adapter3.addFragment(CoughingYes(), " Nine ")
        adapter4.addFragment(FatigueNo(), " Ten ")
        adapter4.addFragment(Fatigue(), " Eleven ")
        adapter4.addFragment(FatigueYes(), " Twelve ")
        adapter5.addFragment(AppetiteNo(), " Thirteen ")
        adapter5.addFragment(Appetite(), " Fourteen ")
        adapter5.addFragment(AppetiteYes(), " Fifteen ")
        adapter6.addFragment(TasteNo(), " Sixteen ")
        adapter6.addFragment(Taste(), " Seventeen ")
        adapter6.addFragment(TasteYes(), " Eighteen ")


        ViewPager4.adapter = adapter4
        ViewPager.adapter = adapter
        ViewPager5.adapter = adapter5
        ViewPager2.adapter = adapter2
        ViewPager3.adapter = adapter3
        ViewPager6.adapter = adapter6

        ViewPager6.setCurrentItem(1)
        ViewPager2.setCurrentItem(1)
        ViewPager.setCurrentItem(1)
        ViewPager3.setCurrentItem(1)
        ViewPager4.setCurrentItem(1)
        ViewPager5.setCurrentItem(1)

        val sdf = SimpleDateFormat("ss.SSS")
        val currentDate = sdf.format(Date())

        button.setOnClickListener {
            val clickDate = sdf.format(Date())
            val responseTime = clickDate.toFloat()-currentDate.toFloat()
            val decimal = BigDecimal(responseTime.toDouble()).setScale(3, RoundingMode.HALF_EVEN)

            var file = FileWriter(
                File(applicationContext.getExternalFilesDir(null), "responsetime.txt"),
                true)
            if (File(applicationContext.getExternalFilesDir(null), "responsetime.txt").exists()) {
                file.write("$decimal\n")
                file.close()
            } else {
                File(
                    applicationContext.getExternalFilesDir(null),
                    "responsetime.txt"
                ).createNewFile()

                File(
                    applicationContext.getExternalFilesDir(null),
                    "responsetime.txt"
                ).writeText("ResponseTime:$decimal")
        }
    }
    }

    class MyViewPagerAdapter (manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()


        override fun getPageWidth(position: Int): Float {
            if ( position == 0 ) {
                return(0.3f)
            }
            if ( position == 2 ) {
                return(0.3f)
            }
            return(1f)
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }

}
