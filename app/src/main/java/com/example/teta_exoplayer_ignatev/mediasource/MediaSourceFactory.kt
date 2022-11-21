package com.example.teta_exoplayer_ignatev.mediasource

import com.google.android.exoplayer2.source.MediaSource

interface MediaSourceFactory {
    fun create(url: String): MediaSource
}