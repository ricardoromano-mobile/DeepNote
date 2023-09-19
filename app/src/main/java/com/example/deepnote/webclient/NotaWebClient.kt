package com.example.deepnote.webclient

import android.util.Log
import com.example.deepnote.model.Nota
import com.example.deepnote.webclient.model.NotaRequisicao
import com.example.deepnote.webclient.services.NotaService

private const val TAG = "NotaWebClient"

class NotaWebClient {

    private val notaService: NotaService =
        RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
        return try {
            val notasResposta = notaService
                .buscaTodas()
            notasResposta.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            Log.e(TAG, "buscaTodas: ", e)
            null
        }
    }

    suspend fun salva(nota: Nota): Boolean {
        try {
            val resposta = notaService.salva(nota.id, NotaRequisicao(
                titulo = nota.titulo,
                descricao = nota.descricao,
                imagem = nota.imagem
            )
            )
            return resposta.isSuccessful
        } catch (e: Exception) {
            Log.e(TAG, "salva: falha ao tentar salvar", e)
        }
        return false
    }

    suspend fun remove(id: String): Boolean {
        try {
            notaService.remove(id)
            return true
        } catch (e: Exception) {
            Log.e(TAG, "remove: falha ao tentar remover nota", e)
        }
        return false
    }

}