package com.example.teta_exoplayer_ignatev.listener

import android.util.Log
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener

private const val TAG = "MediaSourceEventLogger"

class MediaSourceEventLogger : MediaSourceEventListener {

    override fun onLoadCompleted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "onLoadCompleted")
        super.onLoadCompleted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)
    }
}