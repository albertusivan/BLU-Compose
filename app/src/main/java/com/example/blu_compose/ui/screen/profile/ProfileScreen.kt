package com.example.blu_compose.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.blu_compose.R

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = stringResource(id = R.string.about_page),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .align(Alignment.Center)
                        .size(180.dp)
                        .fillMaxWidth()
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.nama),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier.padding(0.dp,12.dp,0.dp,0.dp)
                )
                Text(
                    text = stringResource(id = R.string.email),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier.padding(0.dp,8.dp,0.dp,0.dp)
                )
                Text(
                    text = stringResource(id = R.string.profile_desc),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(0.dp,8.dp,0.dp,0.dp)
                )
            }
        }
    }

}