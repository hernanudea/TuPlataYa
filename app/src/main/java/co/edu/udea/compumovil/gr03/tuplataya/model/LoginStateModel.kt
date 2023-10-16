package co.edu.udea.compumovil.gr03.tuplataya.model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginStateModel : ViewModel() {

    // Login View
    var username by mutableStateOf("")
    var password by mutableStateOf("")

    // Register View

}