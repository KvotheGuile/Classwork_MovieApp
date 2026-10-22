package mar.frias.movieapp3

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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import mar.frias.movieapp3.ui.theme.MovieApp3Theme

@Composable
fun RegisterScreen(
    onRegisterOk: () -> Unit,
    onCancel: () -> Unit
) {
    var correo by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var confirmacion by rememberSaveable { mutableStateOf("") }
    var mensajeError by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign up",
            style = MaterialTheme.typography.headlineLarge
        )

        OutlinedTextField(
            value = confirmacion,
            onValueChange = { confirmacion = it },
            label = { Text("Confirmar contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (mensajeError.isNotEmpty()) {
            Text(
                text = mensajeError,
                color = MaterialTheme.colorScheme.error
            )
        }
        Button(
            onClick = {
                mensajeError = validarRegistro(correo, contrasena, confirmacion)
                if (mensajeError.isEmpty()) {
                    Firebase.auth.createUserWithEmailAndPassword(correo.trim(), contrasena)
                        .addOnCompleteListener { tarea ->
                            if (tarea.isSuccessful) {
                                onRegisterOk()
                            } else {
                                mensajeError = tarea.exception?.message ?: "Error"
                            }
                        }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }

        TextButton(onClick = onCancel) {
            Text("I already have an account.")
        }

    }
}

fun validarRegistro(
    correo: String,
    contrasena: String,
    confirmacion: String
): String {
    if (correo.isBlank() || contrasena.isBlank() || confirmacion.isBlank()) {
        return "Fill all fields."
    }
    if (contrasena.length < 6) {
        return "Password must have at least 6 characters."
    }
    if (contrasena != confirmacion) {
        return "Password doesn't match"
    }
    return ""
}

@Preview
@Composable
fun RegisterScreenPreview(){
    MovieApp3Theme() {
        RegisterScreen( onRegisterOk = {}, onCancel = {} )
    }
}

