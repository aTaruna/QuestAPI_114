package com.example.act8_localrestapi.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.act8_localrestapi.modeldata.DataSiswa
import com.example.act8_localrestapi.repositori.RepositoriDataSiswa

sealed interface StatusUiSiswa {
    data class Success(val siswa: List<DataSiswa> = listOf()) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}
class HomeViewModel(private val repositoriDataSiswa : RepositoriDataSiswa) : ViewModel() {
    var listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set
    init{
        loadSiswa()
    }
}