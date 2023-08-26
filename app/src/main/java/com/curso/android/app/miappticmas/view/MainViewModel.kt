package com.curso.android.app.miappticmas.view
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.miappticmas.model.Compare
import kotlinx.coroutines.launch
import java.util.Date


class MainViewModel : ViewModel() {

    private val _compare = MutableLiveData<Compare>()
    val compare: LiveData<Compare> get() = _compare

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message


    init {
        _compare.value = Compare(0, Date().time)
        _message.value = ""
    }

    fun compareNumbers(num1: Int, num2: Int) {
        _compare.value = Compare(if (num1 == num2) 1 else 0, Date().time)
        _message.value = if (_compare.value?.number == 1) "Los números son iguales" else "Los números son diferentes"
    }
}



