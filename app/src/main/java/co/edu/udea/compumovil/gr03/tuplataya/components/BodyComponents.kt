package co.edu.udea.compumovil.gr03.tuplataya.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
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
fun CustomImageVector(description: String, icon: ImageVector = Icons.Default.Person) {
    Icon(imageVector = icon, contentDescription = description)
}

@Composable
fun CustomPainter(description: String, icon: Painter) {
    Icon(
        painter = icon, contentDescription = description,
        tint = colorScheme.primary
    )
}

@Composable
fun Title1(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 25.sp,
        color = colorScheme.primary,
        modifier = modifier
    )
}

@Composable
fun Title2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 20.sp,
        color = colorScheme.primary,
        modifier = modifier
    )
}

@Composable
fun Title3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 16.sp,
        color = colorScheme.primary,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun Title4(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 14.sp,
        color = colorScheme.primary,
        modifier = modifier
    )
}

@Composable
fun CustomDivider(color: Color){
    Divider(modifier = Modifier.padding(10.dp),
        color = color, thickness = 1.dp)
}
@Composable
fun Title4(name: String) {
    Text(text = name, fontSize = 15.sp, color = colorScheme.primary)
}
@Composable
fun SmallText(text: String)  {
    Text(text = text,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        color = colorScheme.primary,
    )
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
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
    ) {
        Text(text = name)
    }
}


@Composable
fun TextAndIcon(text: String, icon: Painter) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Title4(name = text)
        CustomPainter(description = "Icon", icon = icon)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        //  leadingIcon = leadingIcon,
        label = { Text(text = label) },
        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
    )
}

@Composable
fun CustomSlider(
    value: Float,
    valueRange: () -> ClosedFloatingPointRange<Float>,
    onValueChange: (Float) -> Unit,
) {
    Slider(
        value = value,
        valueRange = valueRange(),
        onValueChange = onValueChange,
        colors = SliderDefaults.colors(
            thumbColor = colorScheme.secondary,
            activeTrackColor = colorScheme.secondary,
            inactiveTrackColor = colorScheme.secondaryContainer,
        ),
    )
}

