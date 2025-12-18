package com.example.act8_localrestapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.act8_localrestapi.modeldata.DataSiswa
import com.example.act8_localrestapi.repositori.RepositoriDataSiswa
import kotlinx.coroutines.launch
import okio.IOException

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

    fun loadSiswa(){
        viewModelScope.launch {
            listSiswa = StatusUiSiswa.Loading
            listSiswa = try {
                StatusUiSiswa.Success(repositoriDataSiswa.getDataSiswa())
            } catch (e: IOException) {
                StatusUiSiswa.Error
            }
        }
    }
}