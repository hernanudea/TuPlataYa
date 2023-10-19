package co.edu.udea.compumovil.gr03.tuplataya.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr03.tuplataya.R
import co.edu.udea.compumovil.gr03.tuplataya.views.showAmountRequested
import co.edu.udea.compumovil.gr03.tuplataya.views.showCommission
import co.edu.udea.compumovil.gr03.tuplataya.views.showDiscount
import co.edu.udea.compumovil.gr03.tuplataya.views.showInterest
import co.edu.udea.compumovil.gr03.tuplataya.views.showRate
import co.edu.udea.compumovil.gr03.tuplataya.views.showState
import co.edu.udea.compumovil.gr03.tuplataya.views.showTotalDays
import co.edu.udea.compumovil.gr03.tuplataya.views.showTotalPrice


var currentCapital = 2000000f
var paymenValue = 54000f
var currentInterest = 32000f
var interestArrears = 0f
var nextPaymentDate = "19/11/2023"
var disbursementDate = "19/10/2023"
@Composable
fun CustomCardCreditResponse(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Title2(name = stringResource(id = R.string.credit_response_message))
            if (showState.equals("APROBADO")) {
                Title3(name = showState)
            }
//            ShowSummary()
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
//            ShowSummary()
        }
        Title3(name = stringResource(id = R.string.credit_response_indicator))

    }
}

@Composable
fun CustomCardCreditState(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_disbursement_date),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$ $disbursementDate",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_current_capital),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = "$ $currentCapital",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            CustomDivider(color = MaterialTheme.colorScheme.onPrimary)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_next_payment_date),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = nextPaymentDate,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_current_capital),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = currentCapital.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_next_payment_value),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = paymenValue.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_current_interest),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = currentInterest.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_interest_arrears),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = interestArrears.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_balance_in_arrears),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = interestArrears.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title4(
                    name = stringResource(id = R.string.credit_state_other_charges),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Title3(
                    name = interestArrears.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            CustomDivider(color = MaterialTheme.colorScheme.onPrimary)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            ) {
                Title1(
                    name = stringResource(id = R.string.credit_state_make_payment),
                    modifier = Modifier.align(Alignment.Center)
                )
            }





        }

    }
}