package co.edu.udea.compumovil.gr03.tuplataya.views

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import co.edu.udea.compumovil.gr03.tuplataya.R
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomButton
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomOutlinedTextField
import co.edu.udea.compumovil.gr03.tuplataya.components.SpaceV
import co.edu.udea.compumovil.gr03.tuplataya.components.Title1
import co.edu.udea.compumovil.gr03.tuplataya.components.TitleBar
import co.edu.udea.compumovil.gr03.tuplataya.model.AppStateViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeLoginView(navController: NavController) {
    val appStateViewModel: AppStateViewModel = viewModel()
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { TitleBar(name = stringResource(R.string.app_name)) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }
    ) {
        val isPortrait =
            LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
        ContentLoginView(navController, isPortrait, appStateViewModel)
    }
}

@Composable
fun ContentLoginView(
    navController: NavController,
    isPortrait: Boolean,
    appStateViewModel: AppStateViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
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
            Title1(name = stringResource(id = R.string.login_who_are))
            SpaceV()

            CustomOutlinedTextField(
                value = appStateViewModel.username,
                onValueChange = {
                    appStateViewModel.username = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.login_email)
            )

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
            
            CustomButton(isEnable = true,
                name = stringResource(id = R.string.login_sesion),
                backColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary ) {
                println("Usuario: ${appStateViewModel.username} Contraseña: ${appStateViewModel.password}")
            }
        }
    }
}
