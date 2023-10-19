package co.edu.udea.compumovil.gr03.tuplataya.views

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import co.edu.udea.compumovil.gr03.tuplataya.R
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomButton
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomOutlinedTextField
import co.edu.udea.compumovil.gr03.tuplataya.components.ScaffoldTopBarWithTitle
import co.edu.udea.compumovil.gr03.tuplataya.components.SpaceV
import co.edu.udea.compumovil.gr03.tuplataya.components.TextAndIcon
import co.edu.udea.compumovil.gr03.tuplataya.components.Title1
import co.edu.udea.compumovil.gr03.tuplataya.model.LoginStateModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeLoginView(navController: NavController) {
    val stateViewModel: LoginStateModel = viewModel()

    Scaffold(topBar = { ScaffoldTopBarWithTitle(navController) }
    ) {
        val isPortrait =
            LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
        ContentLoginView(navController, isPortrait, stateViewModel)
    }
}

@Composable
fun ContentLoginView(
    navController: NavController,
    isPortrait: Boolean,
    appStateViewModel: LoginStateModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        SpaceV(260.dp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            //.border(
            //    border = BorderStroke(3.dp, Color.Green),
            //    shape = CutCornerShape(5.dp)
            //)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpaceV(30.dp)
            Title1(name = stringResource(id = R.string.login_who_are))
            SpaceV()

            CustomOutlinedTextField(
                value = appStateViewModel.username,
                onValueChange = {
                    appStateViewModel.username = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.login_email)
            )
            SpaceV(10.dp)
            CustomOutlinedTextField(
                value = appStateViewModel.password,
                onValueChange = {
                    appStateViewModel.password = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.login_password)
            )
            SpaceV(60.dp)
            CustomButton(
                isEnable = true,
                name = stringResource(id = R.string.login_sesion),
                backColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary
            ) {
                appStateViewModel.isLogined = true
                println("Usuario: ${appStateViewModel.username} Contraseña: ${appStateViewModel.password}")
                navController.navigate("addUser")
            }
            SpaceV(30.dp)
            TextAndIcon(
                text = stringResource(id = R.string.login_new_account),
                icon = painterResource(id = R.drawable.person_add_alt_1_24)
            )
        }
    }
}
