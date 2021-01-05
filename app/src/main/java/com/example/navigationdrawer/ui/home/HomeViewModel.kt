package com.example.navigationdrawer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _goGallery = MutableLiveData(false)
    val goGallery: LiveData<Boolean> = _goGallery

    fun endGoGallery() {
        _goGallery.value = false
    }

    fun onGoGalleryButtonClick() {
        _goGallery.value = true
    }
}