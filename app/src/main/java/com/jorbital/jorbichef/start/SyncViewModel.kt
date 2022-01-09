package com.jorbital.jorbichef.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorbital.jorbichef.backend.repository.SyncRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class SyncViewModel(private val syncRepository: SyncRepository) : ViewModel() {
    fun initialSync() {
        viewModelScope.launch {
            if (syncRepository.isDatabaseEmpty()) {
                syncRepository.downloadFromFirestore.collectLatest {
                    if (it.isFailure) {
                        Timber.e(it.exceptionOrNull())
                    }
                }
            }
        }
    }
}