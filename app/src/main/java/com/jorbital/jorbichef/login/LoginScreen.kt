package com.jorbital.jorbichef.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jorbital.jorbichef.R
import com.jorbital.jorbichef.design.JorbichefTheme

@Composable
fun LoginScreen(signInCallback: () -> Unit) {
    Surface {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.SemiBold, color = Color.White),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            )
            Button(onClick = signInCallback) {
                Text(stringResource(id = R.string.sign_in))
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    JorbichefTheme {
        LoginScreen {}
    }
}
