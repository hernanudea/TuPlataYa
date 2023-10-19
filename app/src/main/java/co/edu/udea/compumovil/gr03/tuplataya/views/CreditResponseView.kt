package co.edu.udea.compumovil.gr03.tuplataya.views

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.udea.compumovil.gr03.tuplataya.R
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomButton
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomCardCreditResponse
import co.edu.udea.compumovil.gr03.tuplataya.components.ScaffoldTopBarWithTitle
import co.edu.udea.compumovil.gr03.tuplataya.components.SpaceV
import co.edu.udea.compumovil.gr03.tuplataya.components.Title1


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeCreditResponseView(navController: NavController) {

    Scaffold(topBar = { ScaffoldTopBarWithTitle(navController) },

    ) {
        val isPortrait =
            LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
        ContentCreditResponseView(navController, isPortrait)
    }
}

@Composable
fun ContentCreditResponseView(
    navController: NavController,
    isPortrait: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        SpaceV(90.dp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpaceV(30.dp)
            Title1(name = stringResource(id = R.string.credit_response_new_credit))
            SpaceV()

       CustomCardCreditResponse(
           Modifier
               .padding(20.dp)
               .fillMaxWidth()
       )


            CustomButton(
                isEnable = true,
                name = stringResource(id = R.string.credit_response_buton_save),
                backColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary
            ) {
                navController.navigate("creditState")
                println("Credit Response Clicked")
            }
        }
    }
}
