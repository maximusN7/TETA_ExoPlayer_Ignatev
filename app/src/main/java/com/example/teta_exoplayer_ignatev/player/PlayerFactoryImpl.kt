package com.example.teta_exoplayer_ignatev.player

import android.content.Context
import com.example.teta_exoplayer_ignatev.mediasource.MediaSourceFactory
import com.google.android.exoplayer2.ExoPlayer

class PlayerFactoryImpl(
    private val context: Context,
    private val mediaSourceFactory: MediaSourceFactory
) : PlayerFactory {

    override fun create(streamUrl: String): ExoPlayer {
        val mediaSource = mediaSourceFactory.create(streamUrl)
        return ExoPlayer.Builder(context)
            .build().apply {
                setMediaSource(mediaSource)
            }
    }
}