package com.praveen.myrecipeapp


import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeDetailScreen(category: Category) {
    Column(
        modifier =  Modifier.fillMaxSize()
            .padding(top =  50.dp , bottom = 16.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {

        Text(
            text = category.strCategory,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} Thumbnail",
            modifier =  Modifier.aspectRatio(1f)
                .fillMaxSize()
                .padding( top   =  40.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp) // Set height for the scrollable area
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = category.strCategoryDescription,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(top = 25.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RecipeScreenPreview(){
    RecipeDetailScreen(
        category = Category(idCategory = "1" ,
            strCategory = "Rice" ,
            strCategoryThumb = "" ,
            strCategoryDescription = ""
        )
    )
}