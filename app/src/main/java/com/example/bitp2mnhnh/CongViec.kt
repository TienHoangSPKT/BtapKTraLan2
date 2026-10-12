package com.example.bitp2mnhnh

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Parcelable {

    fun layTrangThaiChu(): String {
        return if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
    }

    fun layThongTin(): String {
        return "Tên công việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: ${layTrangThaiChu()}"
    }
}