package com.example.android_music_player

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.android_music_player.ui.theme.AndroidMusicPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidMusicPlayerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MusicPlayerScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MusicPlayerScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    // Manage MediaPlayer state in Compose
    var mediaPlayer by remember {
        mutableStateOf(MediaPlayer.create(context, R.raw.piano).also {
            if (it == null) Log.e("MusicPlayer", "Failed to create MediaPlayer for R.raw.piano")
            else Log.d("MusicPlayer", "MediaPlayer created successfully")
        })
    }

    // Clean up MediaPlayer when Composable is disposed
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
            mediaPlayer = null
            Log.d("MusicPlayer", "MediaPlayer released")
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                try {
                    if (mediaPlayer != null && !mediaPlayer!!.isPlaying) {
                        mediaPlayer!!.start()
                        Log.d("MusicPlayer", "Playing audio")
                    } else {
                        Log.w("MusicPlayer", "MediaPlayer is null or already playing")
                    }
                } catch (e: Exception) {
                    Log.e("MusicPlayer", "Error playing audio: ${e.message}")
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Play")
        }
        Button(
            onClick = {
                try {
                    if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                        mediaPlayer!!.pause()
                        Log.d("MusicPlayer", "Audio paused")
                    }
                } catch (e: Exception) {
                    Log.e("MusicPlayer", "Error pausing audio: ${e.message}")
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Pause")
        }
        Button(
            onClick = {
                try {
                    if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                        mediaPlayer!!.stop()
                        mediaPlayer!!.release()
                        mediaPlayer = MediaPlayer.create(context, R.raw.piano)
                        Log.d("MusicPlayer", "Audio stopped and MediaPlayer reset")
                    }
                } catch (e: Exception) {
                    Log.e("MusicPlayer", "Error stopping audio: ${e.message}")
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Stop")
        }
    }
}