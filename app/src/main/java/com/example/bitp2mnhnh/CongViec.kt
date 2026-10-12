package com.example.bitp2mnhnh

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Parcelable