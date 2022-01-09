package com.jorbital.jorbichef.recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorbital.jorbichef.backend.repository.SyncRepository
import kotlinx.coroutines.launch

class RecipesViewModel(private val syncRepository: SyncRepository) : ViewModel() {

}