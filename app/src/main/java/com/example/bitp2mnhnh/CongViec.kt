package com.example.bitp2mnhnh

import android.os.Parcel
import android.os.Parcelable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false,
    var maCongViec: String = ""
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: ""
    )

    fun laDaHoanThanh(): Boolean {
        return trangThai
    }

    fun layTrangThaiChu(): String {
        return if (laDaHoanThanh()) "Đã hoàn thành" else "Chưa hoàn thành"
    }

    fun layThongTin(): String {
        return "Mã: $maCongViec\nTên công việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: ${layTrangThaiChu()}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tenCongViec)
        parcel.writeString(moTa)
        parcel.writeByte(if (trangThai) 1 else 0)
        parcel.writeString(maCongViec)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CongViec> {
        override fun createFromParcel(parcel: Parcel): CongViec = CongViec(parcel)
        override fun newArray(size: Int): Array<CongViec?> = arrayOfNulls(size)
    }
}