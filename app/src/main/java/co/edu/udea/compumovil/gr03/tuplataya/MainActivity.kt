package co.edu.udea.compumovil.gr03.tuplataya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.edu.udea.compumovil.gr03.tuplataya.navigation.NavManager
import co.edu.udea.compumovil.gr03.tuplataya.ui.theme.TuPlataYaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuPlataYaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TuPlataYaTheme {
        NavManager()
    }
}

/*
    a. AddUserView -> Diseñar las pantallas y los servicios necesarios para que un cliente pueda darse de alta dentro de la aplicación.
    b. LoginView -> Diseñar una ventana donde el usuario pueda realizar el login.
    c. SimulatorView -> Diseñar una ventana donde el usuario pueda simular las condiciones de su crédito e iniciar la solicitud de este.
    d. CreditResponseView -> Diseñar una ventana donde el usuario reciba respuesta a su solicitud de crédito y ver el estado de las solicitudes.
    e. CreditStateView -> Diseñar una ventana donde el usuario pueda visualizar el estado del crédito, cuotas pendientes y canceladas.
    f. Desarrollar back-end en spring para soportar la app, incluye persistencia.
*/