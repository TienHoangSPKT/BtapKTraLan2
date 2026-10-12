package com.example.bitp2mnhnh

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtTenMoi: EditText
    private lateinit var edtMoTaMoi: EditText
    private lateinit var btnLuu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtTenMoi = findViewById(R.id.edtTenMoi)
        edtMoTaMoi = findViewById(R.id.edtMoTaMoi)
        btnLuu = findViewById(R.id.btnLuu)

        edtTenMoi.setText(intent.getStringExtra("TEN_CONG_VIEC"))
        edtMoTaMoi.setText(intent.getStringExtra("MO_TA"))
    }
}