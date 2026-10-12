package com.example.bitp2mnhnh

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTa: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTa = findViewById(R.id.edtMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        btnXemDanhSach.setOnClickListener {
            Toast.makeText(this, "Chức năng đang phát triển", Toast.LENGTH_SHORT).show()
        }

        btnTaoCongViec.setOnClickListener {
            val congViec = CongViec(
                tenCongViec = edtTenCongViec.text.toString(),
                moTa = edtMoTa.text.toString()
            )

            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("CONG_VIEC", congViec)
            startActivity(intent)
        }
    }
}