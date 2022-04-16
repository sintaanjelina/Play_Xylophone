package com.example.playmusic

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // api android 21
    private val soundPool = SoundPool.Builder().setMaxStreams(8).build()

    private val sounds = listOf(
        Pair(R.id.textView, R.raw.note1),
        Pair(R.id.textView2, R.raw.note2),
        Pair(R.id.textView3, R.raw.note3),
        Pair(R.id.textView4, R.raw.note4),
        Pair(R.id.textView5, R.raw.note5),
        Pair(R.id.textView6, R.raw.note6),
        Pair(R.id.textView7, R.raw.note7),
        Pair(R.id.textView8, R.raw.note8)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sounds.forEach { play(it)}
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }

    private fun play(pitch: Pair<Int, Int>) {
        val soundId = soundPool.load(this, pitch.second, 1)
        findViewById<TextView>(pitch.first).setOnClickListener {
            soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }
}