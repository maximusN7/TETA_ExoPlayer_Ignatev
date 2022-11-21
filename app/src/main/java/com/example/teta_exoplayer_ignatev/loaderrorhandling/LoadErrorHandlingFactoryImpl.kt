package com.example.teta_exoplayer_ignatev.loaderrorhandling

import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy

class LoadErrorHandlingFactoryImpl : LoadErrorHandlingFactory {

    override fun create(): LoadErrorHandlingPolicy {
        return object : DefaultLoadErrorHandlingPolicy() {

            override fun getRetryDelayMsFor(loadErrorInfo: LoadErrorHandlingPolicy.LoadErrorInfo): Long {
                return if (loadErrorInfo.errorCount >= 4) {
                    C.TIME_UNSET
                } else {
                    loadErrorInfo.errorCount + loadErrorInfo.loadEventInfo.elapsedRealtimeMs
                }
            }

            override fun getMinimumLoadableRetryCount(dataType: Int): Int {
                return 4
            }
        }
    }
}