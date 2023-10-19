package co.edu.udea.compumovil.gr03.tuplataya.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.udea.compumovil.gr03.tuplataya.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TitleBar(name: String) {
    Text(text = name, fontSize = 35.sp, color = MaterialTheme.colorScheme.onPrimary)
}

// ToDo Validar uso
@Composable
fun ActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add new item")
    }
}

// ToDo Validar uso
@Composable
fun MainIconButton(icon: ImageVector, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopBarWithTitle(navController: NavController) {
    CenterAlignedTopAppBar(
        title = { TitleBar(name = stringResource(R.string.app_name)) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            MainIconButton(icon = Icons.Default.ArrowBack) {
                navController.popBackStack()
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopBarHome(scope: CoroutineScope, drawerState: DrawerState) {
    TopAppBar(
        title = { TitleBar(name = stringResource(R.string.app_name)) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
}