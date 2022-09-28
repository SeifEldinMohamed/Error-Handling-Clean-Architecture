package com.seif.errorhandlingcleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seif.errorhandlingcleanarchitecture.presentation.ui.theme.ErrorHandlingCleanArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErrorHandlingCleanArchitectureTheme {
                val viewModel = viewModel<MainViewModel>()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = viewModel.email,
                        onValueChange = viewModel::onEmailChanged,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = viewModel::submitEmail,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Submit")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (viewModel.error != null) {
                        Text(text = viewModel.error ?: "")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ErrorHandlingCleanArchitectureTheme {

    }
}