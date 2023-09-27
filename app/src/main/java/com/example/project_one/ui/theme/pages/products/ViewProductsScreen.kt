package com.example.project_one.ui.theme.pages.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.project_one.data.ProductRepository
import com.example.project_one.modules.Product
import com.example.project_one.navigation.ROUTE_UPDATE_PRODUCTS

@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = ProductRepository(navController, context)

        val emptyProductState = remember { mutableStateOf(Product("","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        name = it.name,
                        number = it.number,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(name:String, number:String, quantity:String, price:String, id:String,
                navController:NavHostController, productRepository:ProductRepository) {

    ScrollableTabRow(selectedTabIndex = 0,modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = number)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = quantity)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = price)
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}
