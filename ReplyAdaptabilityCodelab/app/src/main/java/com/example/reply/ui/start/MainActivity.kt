package com.example.reply.ui.start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import com.example.reply.ui.DevicePosture
import com.example.reply.ui.ReplyHomeViewModel
import com.example.reply.ui.isBookPosture
import com.example.reply.ui.isTableTopPosture
import com.example.reply.ui.isSeparating
import com.example.reply.ui.theme.ReplyTheme
import com.example.reply.ui.rememberWindowSizeClass
import com.example.reply.ui.start.ReplyApp
import com.example.reply.ui.WindowSize
import com.example.reply.ui.ReplyHomeUIState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted

class MainActivity : ComponentActivity() {

    private val viewModel: ReplyHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReplyTheme {
                val uiState = viewModel.uiState.collectAsState().value
                ReplyApp(uiState)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReplyTheme {
        ReplyApp(replyHomeUIState = ReplyHomeUIState())
    }
}