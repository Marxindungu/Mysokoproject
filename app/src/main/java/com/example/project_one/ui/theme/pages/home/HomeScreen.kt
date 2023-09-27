package com.example.project_one.ui.theme.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.project_one.R
import com.example.project_one.data.ProductRepository
import com.example.project_one.navigation.ROUTE_ADD_PRODUCTS
import com.example.project_one.navigation.ROUTE_VIEW_PRODUCTS
import com.example.project_one.ui.theme.Project_OneTheme
import com.example.project_one.ui.theme.Purple40

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current

        var productRepository = ProductRepository(navController,context)

        Text(text = "Welcome to home page")

        Text(text = "CLOCK O'CLOCK", fontFamily = FontFamily.SansSerif, color = Purple40)

        Image(painter = painterResource(R.drawable.watch),
            contentDescription = null)

        Button(onClick = {
            navController.navigate(ROUTE_ADD_PRODUCTS)
        }) {
            Text(text = "Add products")
        }

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_PRODUCTS)
        }) {
            Text(text = "View products")
        }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreview() {
    Project_OneTheme {
        HomeScreen(rememberNavController())
    }
}
