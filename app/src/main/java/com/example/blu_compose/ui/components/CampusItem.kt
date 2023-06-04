package com.example.blu_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blu_compose.R
import com.example.blu_compose.ui.theme.BLU_ComposeTheme

@Composable
fun CampusItem(
    image: Int,
    title: String,
    rangeUkt: String,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
        ){
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(Shapes.Full)
                    .padding(8.dp)
            )
            Column (modifier = modifier.padding(12.dp,32.dp,0.dp,0.dp)){
                Text(
                    text = title,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = rangeUkt,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun RewardItemPreview() {
    BLU_ComposeTheme {
        CampusItem(R.drawable.itb, "Institut Teknologi Bandung", "Rp. 1.000.000 – 25.000.000")
    }
}