package com.example.navigationdrawer.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigationdrawer.ui.Event

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    private val _goSlideshowEvent = MutableLiveData<Event<Boolean>>()
    val goSlideshowEvent: LiveData<Event<Boolean>> = _goSlideshowEvent

    fun onGoSlideshowButtonClick() {
        _goSlideshowEvent.value = Event(true)
    }
}