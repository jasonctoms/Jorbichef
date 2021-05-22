package com.jorbital.jorbichef

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeeklyMenuViewModel : ViewModel() {

    private val _listItems = MutableLiveData<List<MenuItem>>(emptyList())
    val listItems: LiveData<List<MenuItem>> = _listItems

    init {
        setItems(staticList)
    }

    private fun setItems(items: List<MenuItem>) {
        _listItems.value = items
    }

    fun shuffleList() {
        val newList = staticList.toMutableList()
        newList.shuffle()
        setItems(newList.toList())
    }

    companion object {
        val staticList = listOf(
            MenuItem("First", 1),
            MenuItem("Second", 2),
            MenuItem("Third", 3),
            MenuItem("Fourth", 4),
            MenuItem("Fifth", 5)
        )
    }
}

data class MenuItem(val name: String, val number: Int)
