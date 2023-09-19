package com.example.deepnote.webclient.services

import com.example.deepnote.webclient.model.NotaRequisicao
import com.example.deepnote.webclient.model.NotaResposta
import retrofit2.Response
import retrofit2.http.*

interface NotaService {

    @GET("notas")
    suspend fun buscaTodas(): List<NotaResposta>

    @PUT("notas/{id}")
    suspend fun salva(@Path("id") id: String,
              @Body nota: NotaRequisicao
    ): Response<NotaResposta>

    @DELETE("notas/{id}")
    suspend fun remove(@Path("id") id: String): Response<Void>

}