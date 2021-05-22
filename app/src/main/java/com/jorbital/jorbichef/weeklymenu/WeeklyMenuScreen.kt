package com.jorbital.jorbichef.weeklymenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jorbital.jorbichef.design.JorbichefTheme

@Composable
fun WeeklyMenuScreen() {
    val viewModel: WeeklyMenuViewModel = viewModel()
    val menuItems: List<MenuItem> by viewModel.listItems.observeAsState(emptyList())
    WeeklyMenuList(menuItems = menuItems, buttonClicked = { viewModel.shuffleList() })
}

@Composable
fun WeeklyMenuList(
    menuItems: List<MenuItem>,
    buttonClicked: () -> Unit,
) {
    LazyColumn {
        items(menuItems) { item ->
            WeeklyMenuItem(
                menuItem = item,
                buttonClicked = buttonClicked
            )
        }
    }
}

@Composable
fun WeeklyMenuItem(
    menuItem: MenuItem,
    buttonClicked: () -> Unit,
) {
    Card(
        modifier = Modifier
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
fun PreviewMenuList() {
    JorbichefTheme {
        WeeklyMenuList(menuItems = WeeklyMenuViewModel.staticList, buttonClicked = { })
    }
}