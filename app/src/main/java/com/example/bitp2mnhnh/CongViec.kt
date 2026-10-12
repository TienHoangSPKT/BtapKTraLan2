package com.example.bitp2mnhnh

import android.os.Parcel
import android.os.Parcelable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    fun layTrangThaiChu(): String {
        return if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
    }

    fun layThongTin(): String {
        return "Tên công việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: ${layTrangThaiChu()}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tenCongViec)
        parcel.writeString(moTa)
        parcel.writeByte(if (trangThai) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CongViec> {
        override fun createFromParcel(parcel: Parcel): CongViec = CongViec(parcel)
        override fun newArray(size: Int): Array<CongViec?> = arrayOfNulls(size)
    }
}