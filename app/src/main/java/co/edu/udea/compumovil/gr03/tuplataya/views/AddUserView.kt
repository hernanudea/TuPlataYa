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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import co.edu.udea.compumovil.gr03.tuplataya.R
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomButton
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomOutlinedTextField
import co.edu.udea.compumovil.gr03.tuplataya.components.ScaffoldTopBarWithTitle
import co.edu.udea.compumovil.gr03.tuplataya.components.SmallText
import co.edu.udea.compumovil.gr03.tuplataya.components.SpaceV
import co.edu.udea.compumovil.gr03.tuplataya.components.Title1
import co.edu.udea.compumovil.gr03.tuplataya.model.AddUserStateModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeAddUserView(navController: NavController) {
    val stateViewModel: AddUserStateModel = viewModel()
    Scaffold(topBar = { ScaffoldTopBarWithTitle(navController) }
    ) {
        val isPortrait =
            LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
        ContentAddUserView(navController, isPortrait, stateViewModel)
    }
}

@Composable
fun ContentAddUserView(
    navController: NavController,
    isPortrait: Boolean,
    appStateViewModel: AddUserStateModel
) {
    var messageValidatePassword = ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        SpaceV(70.dp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title1(name = stringResource(id = R.string.add_user_new_user))
            CustomOutlinedTextField(
                value = appStateViewModel.name,
                onValueChange = {
                    appStateViewModel.name = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_name)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.lastName,
                onValueChange = {
                    appStateViewModel.lastName = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_last_name)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.middleName,
                onValueChange = {
                    appStateViewModel.middleName = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_middle_name)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.id,
                onValueChange = {
                    appStateViewModel.id = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_id)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.phone,
                onValueChange = {
                    appStateViewModel.phone = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_phone)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.address,
                onValueChange = {
                    appStateViewModel.address = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_address)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.email,
                onValueChange = {
                    appStateViewModel.email = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_email)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.password,
                onValueChange = {
                    appStateViewModel.password = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_password)
            )
            CustomOutlinedTextField(
                value = appStateViewModel.repetPassword,
                onValueChange = {
                    appStateViewModel.repetPassword = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                    autoCorrect = false
                ),
                //  leadingIcon = { CustomPersonIcon() },
                label = stringResource(R.string.add_user_repet_password)
            )
            if (appStateViewModel.password.isNotEmpty() && appStateViewModel.password != appStateViewModel.repetPassword) {
                messageValidatePassword =
                    stringResource(id = R.string.add_user_passwords_dont_match)
            }
            SmallText(text = messageValidatePassword)

            CustomButton(
                isEnable = true,
                name = stringResource(id = R.string.add_user_buton_save),
                backColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary
            ) {
                println("Add User Clicked")
                println("""
                    Nombres: ${appStateViewModel.name}
                    Apellidos: ${appStateViewModel.lastName} ${appStateViewModel.middleName} 
                    ID: ${appStateViewModel.id}
                    Telefono: ${appStateViewModel.phone}
                    Direccion: ${appStateViewModel.address}
                    Email: ${appStateViewModel.email}
                    Contraseña: ${appStateViewModel.password}
                    Repetir Contraseña: ${appStateViewModel.repetPassword}
                    
                """.trimIndent())
                navController.navigate("responseState")
            }
        }
    }
}
