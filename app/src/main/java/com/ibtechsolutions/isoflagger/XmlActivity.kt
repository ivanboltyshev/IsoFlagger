package com.ibtechsolutions.isoflagger

import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ibtechsolutions.isoflagger.databinding.ActivityXmlBinding
import com.ibtechsolutions.isoflagger.xml.Flagger
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class XmlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlBinding

    private var changeDelay = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDelaySeekBar()
        runAutoPreview()
    }

    private fun setupDelaySeekBar() {

        val min = 50
        val max = 3000
        val step = 50

        binding.sbDelay.max = (max - min) / step

        binding.sbDelay.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                val value = min + (progress * step)

                binding.tvPreviewDelayValue.text = "$value ms"

                changeDelay = value.toLong()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        binding.sbDelay.progress = (changeDelay.toInt() - min) / step
    }

    private fun runAutoPreview() {
        lifecycleScope.launch {
            Flagger.supportedCountryCodes().forEach {
                Flagger.country()
                    .code(it)
                    .loadInto(binding.ivFlag)
                    .load()

                binding.tvCountryCode.text = it

                delay(changeDelay)
            }
        }

    }
}