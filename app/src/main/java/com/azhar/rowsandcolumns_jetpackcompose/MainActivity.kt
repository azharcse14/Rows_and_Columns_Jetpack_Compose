package com.azhar.rowsandcolumns_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azhar.rowsandcolumns_jetpackcompose.ui.theme.RowsAndColumnsJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowsAndColumnsJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildColumn()
                }
            }
        }
    }
}

@Composable
fun RowScope.CustomRowItem(weight: Float = 1f, color: Color = MaterialTheme.colorScheme.primary) {
    Surface(
        modifier = Modifier
            .width(50.dp)
            .height(200.dp)
            .weight(weight),
        color = color,
    ) {}
}

@Composable
fun BuildRow() {
    Row (
        modifier = Modifier.height(200.dp),
    ){
        CustomRowItem(3f,MaterialTheme.colorScheme.tertiary)
        CustomRowItem()
        CustomRowItem(3f,MaterialTheme.colorScheme.tertiary)

    }
}

@Composable
fun ColumnScope.CustomColumnItem(weight: Float = 1f, color: Color = MaterialTheme.colorScheme.primary) {
    Surface(
        modifier = Modifier
            .width(360.dp)
            .height(50.dp)
            .weight(weight),
        color = color,
    ) {}
}

@Composable
fun BuildColumn() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        BuildRow()
        CustomColumnItem()
        BuildRow()
        CustomColumnItem(3f,MaterialTheme.colorScheme.secondary)
        CustomColumnItem()
        CustomColumnItem(3f,MaterialTheme.colorScheme.secondary)
        CustomColumnItem()

    }
}

@Preview(showBackground = true)
@Composable
fun ColumnRowPreview() {
    RowsAndColumnsJetpackComposeTheme {
        BuildColumn()
    }
}