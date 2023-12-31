package co.edu.udea.compumovil.gr03.tuplataya.model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginStateModel : ViewModel() {

    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var isLogined by mutableStateOf(false)
}