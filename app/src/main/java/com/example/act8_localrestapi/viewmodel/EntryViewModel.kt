package com.example.act8_localrestapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.act8_localrestapi.modeldata.DetailSiswa
import com.example.act8_localrestapi.modeldata.UIStateSiswa
import com.example.act8_localrestapi.repositori.RepositoriDataSiswa

class EntryViewModel (private val repositoriDataSiswa: RepositoriDataSiswa):
        ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
    }
    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa =
    }
}