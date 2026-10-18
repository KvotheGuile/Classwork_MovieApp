package mar.frias.movieapp3

import android.R
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mar.frias.movieapp3.ui.theme.MovieApp3Theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun LoginScreen(onLoginOk: () -> Unit) {
    var user by rememberSaveable{ mutableStateOf("") }
    var password by rememberSaveable{ mutableStateOf("") }
    var errorExists by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Movies",
            style = MaterialTheme.typography.headlineLarge
        )

        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("Enter your name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            isError = errorExists
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth(),
            isError = errorExists
        )

        if (errorExists){
            Text(
                text = "Username or password is wrong",
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {
                if (user.trim() == "root"
                    && password == "rootpass"){
                    onLoginOk()
                } else {
                  errorExists = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enter")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    MovieApp3Theme() {
        LoginScreen(onLoginOk = { })
    }
}