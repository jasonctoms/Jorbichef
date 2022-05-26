package com.jorbital.jorbichef.weeklymenu

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jorbital.jorbichef.design.JorbichefTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun WeeklyMenuScreen(viewModel: WeeklyMenuViewModel = getViewModel()) {
    val menuItems: List<MenuItem> by viewModel.listItems.observeAsState(emptyList())
    WeeklyMenuList(menuItems = menuItems, buttonClicked = { viewModel.shuffleList() })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeeklyMenuList(
    menuItems: List<MenuItem>,
    buttonClicked: () -> Unit,
) {
    Surface {
        LazyColumn {
            items(items = menuItems, key = { it.number }) { item ->
                WeeklyMenuItem(
                    modifier = Modifier.animateItemPlacement(),
                    menuItem = item,
                    buttonClicked = buttonClicked
                )
            }
        }
    }
}

@Composable
fun WeeklyMenuItem(
    modifier: Modifier = Modifier,
    menuItem: MenuItem,
    buttonClicked: () -> Unit,
) {
    Card(
        backgroundColor = MaterialTheme.colorScheme.surface,
        elevation = 4.dp,
        modifier = modifier
            .wrapContentSize()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = "${menuItem.name} - ${menuItem.number}"
            )
            Button(modifier = Modifier.padding(8.dp), onClick = { buttonClicked() }) {
                Text(text = "Shuffle")
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenuListLight() {
    JorbichefTheme {
        WeeklyMenuList(menuItems = WeeklyMenuViewModel.staticList, buttonClicked = { })
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewMenuListDark() {
    JorbichefTheme {
        WeeklyMenuList(menuItems = WeeklyMenuViewModel.staticList, buttonClicked = { })
    }
}
