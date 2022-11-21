package com.example.teta_exoplayer_ignatev.player

import com.google.android.exoplayer2.ExoPlayer

interface PlayerFactory {
    fun create(streamUrl: String): ExoPlayer
}