package com.example.act8_localrestapi.repositori

import com.example.act8_localrestapi.apiservice.ServiceApiSiswa
import com.example.act8_localrestapi.modeldata.DataSiswa

interface RepositoriDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
    //suspend fun getSatuSiswa(id: Int,dataSiswa: DataSiswa)
    //suspend fun editSatuSiswa(id: Int,dataSiswa: DataSiswa):retrofit2.Response<Void>
    //suspend fun deleteSatuSiswa(id: Int,dataSiswa: DataSiswa):retrofit2.Response<Void>

    class JaringanRepositoryDataSiswa(
        private val serviceApiSiswa: ServiceApiSiswa
    ):RepositoriDataSiswa{
        override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
        override suspend fun postDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
    }
}