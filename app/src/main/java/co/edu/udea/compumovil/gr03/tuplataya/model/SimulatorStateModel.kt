package co.edu.udea.compumovil.gr03.tuplataya.model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel

class SimulatorStateModel : ViewModel() {
    var indexValue by mutableStateOf(4f)
    var indexDays by mutableStateOf(4f)
    var state by mutableStateOf("SOLICITADO")
}