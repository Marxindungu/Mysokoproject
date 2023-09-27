package com.example.project_one.ui.theme.pages.about

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.project_one.ui.theme.Project_OneTheme

@Composable
fun AboutScreen(navController: NavHostController) {
    Text(text = "Welcome to about screen")
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AboutScreenPreview() {
    Project_OneTheme {
        AboutScreen(rememberNavController())
    }
}