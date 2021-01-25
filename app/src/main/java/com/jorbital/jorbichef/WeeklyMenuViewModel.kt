package com.jorbital.jorbichef

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeeklyMenuViewModel : ViewModel() {

    private val _listItems = MutableLiveData<List<MenuItem>>(emptyList())
    val listItems: LiveData<List<MenuItem>> = _listItems

    private val _test = MutableLiveData(0)
    val test: LiveData<Int> = _test

    private var internalList = staticList.toMutableList()

    init {
        setItems(internalList)
    }

    private fun setItems(items: List<MenuItem>) {
        _listItems.value = items
        //_test.value = _test.value?.plus(1)
    }

    fun shuffleList() {
        internalList.shuffle()
        setItems(internalList)
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