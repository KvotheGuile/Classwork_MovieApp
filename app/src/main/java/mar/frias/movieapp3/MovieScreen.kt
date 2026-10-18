package mar.frias.movieapp3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun MoviesScreen(onMovieClicked: (Int) -> Unit){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Movies",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies){ movie ->
                MovieItem(
                    movie = movie,
                    onClick = { onMovieClicked(movie.id) }
                    )
            }
        }

    }
}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit){
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Image(
                painter = painterResource(movie.image),
                contentDescription = "Poster of ${movie.title}",
                contentScale = ContentScale.Crop,
                modifier =
                    Modifier
                        .size(width = 60.dp, height = 90.dp)
                        .clip(RoundedCornerShape(8.dp))
            )

            Column() {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge
                    // modifier = Modifier.padding(12.dp)
                )
                Text(
                    text = "${movie.year} - ${movie.gender}",
                    style = MaterialTheme.typography.bodyMedium
                    // modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview(){
    MovieApp3Theme() {
        MoviesScreen(onMovieClicked = { })
    }
}