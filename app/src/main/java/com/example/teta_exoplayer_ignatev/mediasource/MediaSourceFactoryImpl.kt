package com.example.teta_exoplayer_ignatev.mediasource

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.teta_exoplayer_ignatev.listener.MediaSourceEventLogger
import com.example.teta_exoplayer_ignatev.loaderrorhandling.LoadErrorHandlingFactory
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.upstream.DefaultDataSource

class MediaSourceFactoryImpl(
    private val context: Context,
    private val loadErrorHandlingFactory: LoadErrorHandlingFactory
) : MediaSourceFactory {

    override fun create(url: String): MediaSource {
        val mediaItem = MediaItem.fromUri(url)

        val loadErrorHandlingPolicy = loadErrorHandlingFactory.create()

        val manifestDataSourceFactory = DefaultDataSource.Factory(context)
        val chunkDataSourceFactory = DefaultDataSource.Factory(context)
        val dashChunkSourceFactory = DefaultDashChunkSource.Factory(chunkDataSourceFactory)

        val mediaSourceFactory = DashMediaSource.Factory(
            dashChunkSourceFactory,
            manifestDataSourceFactory
        ).apply {
            setLoadErrorHandlingPolicy(loadErrorHandlingPolicy)
        }

        return mediaSourceFactory.createMediaSource(mediaItem).apply {
            addEventListener(Handler(Looper.getMainLooper()), MediaSourceEventLogger())
        }
    }
}