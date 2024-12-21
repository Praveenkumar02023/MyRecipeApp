package com.praveen.myrecipeapp



import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(viewState : MainViewModel.recipeState,navigateToDetail: (Category) -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(text = "Error Occurred", modifier = Modifier.align(Alignment.Center))
            }

            else -> {
                CategoriesList(categoryList = viewState.list,navigateToDetail)
            }
        }


    }
}

@Composable
fun CategoriesList(categoryList : List<Category>, navigateToDetail: (Category) -> Unit){
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categoryList){
            categoryItem -> CategoryItem(category = categoryItem,navigateToDetail)
        }
    }
}

@Composable
fun CategoryItem(category: Category,navigateToDetail: (Category) -> Unit){

    Column(modifier = Modifier.padding(8.dp).clickable {
        navigateToDetail(category)
    },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier =  Modifier.aspectRatio(1f)
        )

        Text(
            text = category.strCategory,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}

