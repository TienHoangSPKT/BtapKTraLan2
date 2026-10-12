package com.example.bitp2mnhnh

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTa: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTa = findViewById(R.id.tvMoTa)

        tvTenCongViec.text = intent.getStringExtra("TEN_CONG_VIEC")
        tvMoTa.text = intent.getStringExtra("MO_TA")
    }
}