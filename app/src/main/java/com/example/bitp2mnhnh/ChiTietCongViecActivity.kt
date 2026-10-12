package com.example.bitp2mnhnh

import android.content.Intent
import android.os.Build
import android.graphics.Color
import android.widget.CheckBox
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTa: TextView
    private lateinit var btnChinhSua: Button
    private lateinit var tvTrangThai: TextView
    private lateinit var cbHoanThanh: CheckBox

    private lateinit var congViec: CongViec

    private val trinhChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == RESULT_OK) {
            val congViecMoi = layCongViec(ketQua.data)
            if (congViecMoi != null) {
                congViec = congViecMoi
                hienThiThongTin()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTa = findViewById(R.id.tvMoTa)
        btnChinhSua = findViewById(R.id.btnChinhSua)
        tvTrangThai = findViewById(R.id.tvTrangThai)
        cbHoanThanh = findViewById(R.id.cbHoanThanh)
        tvMaCongViec = findViewById(R.id.tvMaCongViec)
        btnHoanThanh = findViewById(R.id.btnHoanThanh)

        congViec = layCongViec(intent) ?: CongViec("", "")
        hienThiThongTin()

        btnChinhSua.setOnClickListener {
            val intentChinhSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentChinhSua.putExtra("CONG_VIEC", congViec)
            trinhChinhSua.launch(intentChinhSua)

        }

        btnHoanThanh.setOnClickListener {
            congViec.trangThai = true
            hienThiThongTin()
        }
    }

    private fun layCongViec(duLieu: Intent?): CongViec? {
        if (duLieu == null) return null
        return if (Build.VERSION.SDK_INT >= 33) {
            duLieu.getParcelableExtra("CONG_VIEC", CongViec::class.java)
        } else {
            @Suppress("DEPRECATION")
            duLieu.getParcelableExtra("CONG_VIEC")
        }
    }

    private fun hienThiThongTin() {
        tvTenCongViec.text = congViec.tenCongViec
        tvMaCongViec.text = "Mã công việc: ${congViec.maCongViec}"
        tvMoTa.text = congViec.moTa
        tvTrangThai.text = "Trạng thái: ${congViec.layTrangThaiChu()}"
        tvTrangThai.setTextColor(
            if (congViec.trangThai) Color.parseColor("#2E7D32") else Color.parseColor("#C62828")
        )

        cbHoanThanh.setOnCheckedChangeListener(null)
        cbHoanThanh.isChecked = congViec.trangThai
        cbHoanThanh.setOnCheckedChangeListener { _, daChon ->
            congViec.trangThai = daChon
            hienThiThongTin()
        }
    }
}