package co.edu.udea.compumovil.gr03.tuplataya.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpaceH(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun SpaceV(size: Dp = 5.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun Title1(name: String) {
    Text(text = name, fontSize = 25.sp, color = MaterialTheme.colorScheme.primary)
}

@Composable
fun CustomButton(
    isEnable: Boolean,
    name: String,
    backColor: Color,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor
        ), enabled = isEnable,
        modifier = modifier.fillMaxWidth().padding(10.dp)
    ) {
        Text(text = name)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions,
    //leadingIcon: @Composable (() -> Unit)
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
      //  leadingIcon = leadingIcon,
        label = { Text(text = label) }
    )
}