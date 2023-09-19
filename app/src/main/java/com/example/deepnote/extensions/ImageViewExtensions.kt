package com.example.deepnote.extensions

import android.widget.ImageView

import coil.load
import com.example.deepnote.R

fun ImageView.tentaCarregarImagem(
    url: String? = null,
    fallback: Int = R.drawable.imagem_padrao
) {
    load(url) {
        placeholder(R.drawable.placeholder)
        error(R.drawable.erro)
        fallback(fallback)
    }
}