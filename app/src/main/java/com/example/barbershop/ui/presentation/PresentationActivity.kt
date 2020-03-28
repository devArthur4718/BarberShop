package com.example.barbershop.ui.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.barbershop.R
import com.example.barbershop.data.items.Slide
import com.example.barbershop.data.adapter.SliderAdapter
import com.example.barbershop.ui.schedules.MainActivity
import kotlinx.android.synthetic.main.activity_presentation.*

class PresentationActivity : AppCompatActivity() {

    private lateinit var adapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)
        initViews()
        setupIndicators()
        setCurrentIndicator(0)
        viewPagerIntro.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
    }

    private fun initViews() {

        var slides = listOf<Slide>(
            Slide(
                getString(R.string.craete_your_profile),
                getString(R.string.text_presentation_1),
                R.drawable.ic_person_add_black_24dp, R.drawable.slide
            ),
            Slide(
                getString(R.string.local_service),
                getString(R.string.text_presentation_2),
                R.drawable.ic_add_location_black_24dp, R.drawable.slide1
            ),
            Slide(
                getString(R.string.arriive_on_time),
                getString(R.string.text_presentation_3),
                R.drawable.ic_timer_white_24dp, R.drawable.slide3
            )
        )

        adapter = SliderAdapter()
        adapter.data = slides
        viewPagerIntro.adapter = adapter



    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)

        for(i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable
                        (applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index : Int){
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount){
                val imageView = indicatorContainer[i] as ImageView
            if(i == index){
                imageView.setImageDrawable( ContextCompat.getDrawable
                    (applicationContext,
                    R.drawable.indicator_active
                ))
            }else{

                imageView.setImageDrawable( ContextCompat.getDrawable
                    (applicationContext,
                    R.drawable.indicator_inactive
                ))

            }
        }

    }

    fun openCoreActivity(view: View) {
        if(view.id == R.id.btnStartCore){
            val intent = Intent(this@PresentationActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
