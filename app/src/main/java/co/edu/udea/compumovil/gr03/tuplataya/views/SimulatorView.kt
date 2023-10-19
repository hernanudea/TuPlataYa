package co.edu.udea.compumovil.gr03.tuplataya.views

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import co.edu.udea.compumovil.gr03.tuplataya.R
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomButton
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomDivider
import co.edu.udea.compumovil.gr03.tuplataya.components.CustomSlider
import co.edu.udea.compumovil.gr03.tuplataya.components.ScaffoldTopBarHome
import co.edu.udea.compumovil.gr03.tuplataya.components.SmallText
import co.edu.udea.compumovil.gr03.tuplataya.components.SpaceV
import co.edu.udea.compumovil.gr03.tuplataya.components.Title1
import co.edu.udea.compumovil.gr03.tuplataya.components.Title2
import co.edu.udea.compumovil.gr03.tuplataya.components.Title3
import co.edu.udea.compumovil.gr03.tuplataya.components.Title4
import co.edu.udea.compumovil.gr03.tuplataya.model.SimulatorStateModel
import kotlinx.coroutines.launch


val valuesList: List<Int> =
    listOf(100000, 200000, 300000, 500000, 700000, 1000000, 1200000, 1500000, 1800000, 2000000)
val daysList: List<Int> = listOf(1, 5, 10, 15, 30, 60, 90, 120, 150, 180)
var showAmountRequested = 0f
var showRate = 0f
var showInterest = 0f
var showCommission = 0f
var showDiscount = 0f
var showTotalPrice = 0f
var showTotalDays = 0
var showState = ""
const val ratePercentage = 2.4f
const val comisionPercentage = 5f
const val discountInterestPercentage = 20f


data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
    val path: String
)


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeSimulatorView(navController: NavController) {
    val items = listOf(
        NavigationItem(
            title = stringResource(id = R.string.menu_simulator),
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            path = "simulator",
        ),
        NavigationItem(
            title = stringResource(id = R.string.menu_register),
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            path = "addUser",
        ),
        NavigationItem(
            title = stringResource(id = R.string.menu_request_state),
            selectedIcon = Icons.Filled.CheckCircle,
            unselectedIcon = Icons.Outlined.CheckCircle,
            path = "responseState",
        ),
        NavigationItem(
            title = stringResource(id = R.string.menu_credit_state),
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            path = "creditState",
        ),
        NavigationItem(
            title = stringResource(id = R.string.menu_exit),
            selectedIcon = Icons.Filled.ExitToApp,
            unselectedIcon = Icons.Outlined.ExitToApp,
            path = "simulator",
        ),
    )

    val stateViewModel: SimulatorStateModel = viewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    SpaceV(16.dp)
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                selectedItemIndex = index
                                scope.launch {
                                    drawerState.close()
                                }
                                navController.navigate(item.path)
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },
                            badge = {
                                item.badgeCount?.let {
                                    Text(text = item.badgeCount.toString())
                                }
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = { ScaffoldTopBarHome(scope, drawerState) }
            ) {
                ContentSimulatorView(
                    navController = navController,
                    isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT,
                    state = stateViewModel
                )
            }
        }
    }
}


@Composable
fun ContentSimulatorView(
    navController: NavController,
    isPortrait: Boolean,
    state: SimulatorStateModel
) {
    calculateCreditValues(state.indexValue.toInt(), state.indexDays.toInt())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SpaceV(90.dp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SpaceV(20.dp)
            Title1(name = stringResource(id = R.string.simulator_new_credit))
            SpaceV()

            Text(text = stringResource(id = R.string.simulator_amount_request) + " ${valuesList[state.indexValue.toInt()]}")
            CustomSlider(
                value = state.indexValue,
                valueRange = { 0f..(valuesList.size - 1).toFloat() },
                onValueChange = {
                    state.indexValue = it
                    calculateCreditValues(
                        state.indexValue.toInt(),
                        state.indexDays.toInt()
                    )
                }
            )

            SpaceV(10.dp)

            Text(text = stringResource(id = R.string.simulator_total_days) + " ${daysList[state.indexDays.toInt()]}")
            CustomSlider(
                value = state.indexDays,
                valueRange = { 0f..(daysList.size - 1).toFloat() },
                onValueChange = {
                    state.indexDays = it
                    calculateCreditValues(
                        state.indexValue.toInt(),
                        state.indexDays.toInt()
                    )
                },
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            CustomButton(
                isEnable = true,
                name = stringResource(id = R.string.simulator_buton_save),
                backColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary
            ) {
                println("Simulator Clicked")
                showState = "APROBADO"
                navController.navigate("login")
            }
            SmallText(text = stringResource(id = R.string.simulator_advertence))
            CustomDivider(color = MaterialTheme.colorScheme.primary)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title2(
                    name = stringResource(id = R.string.simulator_total_price),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title1(
                    name = "$ $showTotalPrice",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            CustomDivider(color = MaterialTheme.colorScheme.primary)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.simulator_amount_request),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$ $showAmountRequested",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.simulator_interest),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$ $showInterest",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.simulator_interest_rate),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$showRate%",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.simulator_total_days),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$showTotalDays",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.simulator_commission),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$ $showCommission",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.simulator_discount),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$ $showDiscount",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.simulator_total_price),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$ $showTotalPrice",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}

fun calculateCreditValues(valueIndex: Int, daysIndex: Int) {
    showAmountRequested = formatToTwoDecimals(valuesList[valueIndex])
    showTotalDays = daysList[daysIndex]
    showRate = formatToTwoDecimals(ratePercentage)
    showInterest = formatToTwoDecimals(showAmountRequested * showRate / 100 / 30 * showTotalDays)
    showCommission = formatToTwoDecimals(showAmountRequested * comisionPercentage / 100)
    showDiscount = if (showAmountRequested >= 1000000) {
        formatToTwoDecimals(showInterest * -discountInterestPercentage / 100)
    } else {
        0f
    }
    showTotalPrice =
        formatToTwoDecimals(showAmountRequested + showInterest + showCommission + showDiscount)

//    println("showAmountRequested: $showAmountRequested")
//    println("showTotalDays: $showTotalDays")
//    println("showRate: $showRate")
//    println("showInterest: $showInterest")
//    println("showCommission: $showCommission")
//    println("showDiscount: $showDiscount")
//    println("showTotalPrice: $showTotalPrice")
}

fun formatToTwoDecimals(value: Int): Float {
    val formattedValue = String.format("%.2f", value.toFloat())
    return formattedValue.toFloat()
}

fun formatToTwoDecimals(value: Float): Float {
    val formattedValue = String.format("%.2f", value)
    return formattedValue.toFloat()
}

