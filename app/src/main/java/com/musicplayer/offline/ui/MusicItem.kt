package com.musicplayer.offline.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.musicplayer.offline.model.Music

@Composable
fun MusicItem(
    music: Music,
    onPlayClick: (Music) -> Unit,
    onDeleteClick: (Music) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onPlayClick(music) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = music.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = music.artist,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Text(
                    text = "Size: ${music.fileSize / (1024 * 1024)} MB",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Duration: ${music.duration / 1000}s",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}