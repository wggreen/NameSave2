package com.ebookfrenzy.namesave2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var input: String = ""
    var output: String = ""
    var outputNames: MutableList<String> = mutableListOf()

    fun addName(name: String) {
        if (name.isNotEmpty()) {
            outputNames.add(name)
            output = outputNames.joinToString("\n")
        }
    }

}