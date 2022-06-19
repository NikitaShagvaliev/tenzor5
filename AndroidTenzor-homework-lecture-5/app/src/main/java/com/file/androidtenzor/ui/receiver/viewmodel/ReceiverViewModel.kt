package com.file.androidtenzor.ui.receiver.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverViewModel : ViewModel() {

    private val mutableMessage = MutableLiveData<String>()

    val message: LiveData<String> = mutableMessage

    fun setMessage(value: String) = mutableMessage.postValue(value)
}
