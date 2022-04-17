package com.jorbital.jorbichef.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.jorbital.jorbichef.backend.repository.SyncRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class MainScreenViewModel(private val syncRepository: SyncRepository) : ViewModel() {
    val currentUser by lazy { FirebaseAuth.getInstance().currentUser }

    val downloadFlow = syncRepository.downloadFromFirestore

    fun initialSync() {
        viewModelScope.launch {
            if (syncRepository.isDatabaseEmpty()) {
                downloadFlow.collectLatest {
                    if (it.isFailure) {
                        Timber.e(it.exceptionOrNull())
                    }
                }
            }
        }
    }
}