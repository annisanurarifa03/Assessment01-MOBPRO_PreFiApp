package org.d3if6706201141.assessment1_prefiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if6706201141.assessment1_prefiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { prefiApp() }
        binding.button2.setOnClickListener { reset()
        }
    }
    private fun prefiApp() {
        val gaji = binding.gajiInp.text.toString()
        if (TextUtils.isEmpty(gaji)) {
            Toast.makeText(this, R.string.gaji_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val kHidup = gaji.toFloat() * 0.4
        binding.kebutuhanHidup.text = getString(R.string.kebutuhanHidup_x, kHidup)

        val kSarana = gaji.toFloat() * 0.3
        binding.kebutuhanSarana.text = getString(R.string.kebutuhanSarana_x, kSarana)

        val tabungan = gaji.toFloat() * 0.2
        binding.tabung.text = getString(R.string.tabung_x, tabungan)

        val sedekah = gaji.toFloat() * 0.1
        binding.amal.text = getString(R.string.amal_x, sedekah)
    }

    private fun reset(){
        val gaji = binding.gajiInp.text.toString()

        binding.gajiInp.setText("")
        binding.kebutuhanHidup.setText("")
        binding.kebutuhanSarana.setText("")
        binding.tabung.setText("")
        binding.amal.setText("")

        binding.gajiInp.requestFocus()
        binding.gajiInp.clearFocus()

    }
}