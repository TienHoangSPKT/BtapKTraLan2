package com.example.bitp2mnhnh

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTa: TextView
    private lateinit var btnChinhSua: Button

    private var tenCongViec: String = ""
    private var moTa: String = ""

    private val trinhChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == RESULT_OK) {
            tenCongViec = ketQua.data?.getStringExtra("TEN_CONG_VIEC") ?: tenCongViec
            moTa = ketQua.data?.getStringExtra("MO_TA") ?: moTa
            tvTenCongViec.text = tenCongViec
            tvMoTa.text = moTa
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTa = findViewById(R.id.tvMoTa)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        tenCongViec = intent.getStringExtra("TEN_CONG_VIEC") ?: ""
        moTa = intent.getStringExtra("MO_TA") ?: ""
        tvTenCongViec.text = tenCongViec
        tvMoTa.text = moTa

        btnChinhSua.setOnClickListener {
            val intentChinhSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentChinhSua.putExtra("TEN_CONG_VIEC", tenCongViec)
            intentChinhSua.putExtra("MO_TA", moTa)
            trinhChinhSua.launch(intentChinhSua)
        }
    }
}