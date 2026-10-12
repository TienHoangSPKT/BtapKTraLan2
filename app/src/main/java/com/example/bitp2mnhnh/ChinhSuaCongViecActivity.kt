package com.example.bitp2mnhnh

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtTenMoi: EditText
    private lateinit var edtMoTaMoi: EditText
    private lateinit var btnLuu: Button

    private lateinit var congViec: CongViec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtTenMoi = findViewById(R.id.edtTenMoi)
        edtMoTaMoi = findViewById(R.id.edtMoTaMoi)
        btnLuu = findViewById(R.id.btnLuu)

        congViec = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("CONG_VIEC", CongViec::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("CONG_VIEC")
        } ?: CongViec("", "")

        edtTenMoi.setText(congViec.tenCongViec)
        edtMoTaMoi.setText(congViec.moTa)

        btnLuu.setOnClickListener {
            congViec.tenCongViec = edtTenMoi.text.toString()
            congViec.moTa = edtMoTaMoi.text.toString()

            val ketQua = Intent()
            ketQua.putExtra("CONG_VIEC", congViec)
            setResult(RESULT_OK, ketQua)
            finish()
        }
    }
}