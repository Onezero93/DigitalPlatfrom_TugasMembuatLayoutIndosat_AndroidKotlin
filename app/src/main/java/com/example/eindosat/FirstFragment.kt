package com.example.eindosat

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.eindosat.databinding.FragmentFirstBinding
import com.example.eindosat.networking.Imagslid

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var adapter: AdapterSlid
    private  val list = ArrayList<Imagslid>()
    private lateinit var dots: ArrayList<TextView>
    private val binding get() = _binding!!

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.topUp.setOnClickListener{
            val i = Intent(this@FirstFragment.requireContext(), TopupActivity::class.java)
            startActivity(i)
        }
        binding.transfer.setOnClickListener{
            val i = Intent(this@FirstFragment.requireContext(), Transfer::class.java)
            startActivity(i)
        }
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable{
            var index = 0
            override fun run() {
                if (index == list.size)
                    index = 0
                Log.e("Runnable","$index")
                binding.viewPager.setCurrentItem(index)
                index++
                handler.postDelayed(this,2000)
            }
        }
        list.add(
            Imagslid(
                R.drawable.bgindosat
            )
        )
        list.add(
            Imagslid(
                R.drawable.bgindosat
            )
        )
        list.add(
            Imagslid(
                R.drawable.bgindosat
            )
        )
        adapter = AdapterSlid(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()
        binding.viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                SelectedDot(position)
                super.onPageSelected(position)
            }
        })
        return view
    }

    private fun SelectedDot(position: Int) {
         for (i in 0 until list.size){
             if (i == position)
                 dots[i].setTextColor(ContextCompat.getColor(requireContext(),android.R.color.holo_red_dark))
             else
                 dots[i].setTextColor(ContextCompat.getColor(requireContext(),R.color.purple_200))
         }
    }

    private fun setIndicator() {
        for (i in 0 until list.size){
            dots.add(TextView(context))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].text =Html.fromHtml("&#9679",Html.FROM_HTML_MODE_LEGACY).toString()
            }else{
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 10f
            binding.dotsindicator.addView(dots[i])
        }
    }

    override fun onStart() {
        super.onStart()
        handler.post(runnable)
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }
}