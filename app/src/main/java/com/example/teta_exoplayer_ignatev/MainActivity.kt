package com.example.teta_exoplayer_ignatev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teta_exoplayer_ignatev.databinding.ActivityMainBinding
import com.example.teta_exoplayer_ignatev.loaderrorhandling.LoadErrorHandlingFactoryImpl
import com.example.teta_exoplayer_ignatev.mediasource.MediaSourceFactoryImpl
import com.example.teta_exoplayer_ignatev.player.PlayerFactoryImpl

private const val STREAM_URL = "https://bitmovin-a.akamaihd.net/content/MI201109210084_1/mpds/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.mpd"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val factory by lazy {
        PlayerFactoryImpl(
            this,
            MediaSourceFactoryImpl(this, LoadErrorHandlingFactoryImpl())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exoplayer = factory.create(STREAM_URL)
        binding.playerView.player = exoplayer
    }
}