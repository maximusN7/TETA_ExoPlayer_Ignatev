package com.example.teta_exoplayer_ignatev.loaderrorhandling

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy

interface LoadErrorHandlingFactory {
    fun create(): LoadErrorHandlingPolicy
}