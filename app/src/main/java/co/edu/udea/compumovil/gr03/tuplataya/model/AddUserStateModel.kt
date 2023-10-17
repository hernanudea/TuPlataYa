package co.edu.udea.compumovil.gr03.tuplataya.model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddUserStateModel : ViewModel() {

    // Login View
    var name by mutableStateOf("")
    var lastName by mutableStateOf("")
    var middleName by mutableStateOf("")
    var id by mutableStateOf("")
    var phone by mutableStateOf("")
    var address by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var repetPassword by mutableStateOf("")


    // Register View

}