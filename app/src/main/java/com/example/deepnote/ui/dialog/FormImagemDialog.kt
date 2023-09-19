package com.example.deepnote.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.deepnote.databinding.FormImagemBinding
import com.example.deepnote.extensions.tentaCarregarImagem

class FormImagemDialog(private val context: Context) {

    fun mostra(
        urlPadrao: String? = null,
        quandoImagemCarragada: (imagem: String) -> Unit
    ) {
        FormImagemBinding.inflate(LayoutInflater.from(context)).apply {

                urlPadrao?.let {
                    formImagemImageview.tentaCarregarImagem(it)
                    formImagemUrl.setText(it)
                }

                formImagemBotaoCarregar.setOnClickListener {
                    val url = formImagemUrl.text.toString()
                    formImagemImageview.tentaCarregarImagem(url)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val url = formImagemUrl.text.toString()
                        quandoImagemCarragada(url)
                    }
                    .setNegativeButton("Cancelar") { _, _ ->

                    }
                    .show()
            }


    }

}