package com.example.myroomsiswa.view.route

import com.example.act8_localrestapi.R
import com.example.act8_localrestapi.uicontroller.route.DestinasiNavigasi

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}