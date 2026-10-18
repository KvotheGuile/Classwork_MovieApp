package mar.frias.movieapp3

import android.R
import android.icu.text.CaseMap
import android.telecom.Call
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mar.frias.movieapp3.ui.theme.MovieApp3Theme

@Composable
fun DetailScreen(movieId: Int, onBack: () -> Unit){
    val movie = movies.first { it.id == movieId }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        Image(
            painter = painterResource(movie.image),
            contentDescription = "Poster of ${movieId}",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )

        Text(
            text = movie.title,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "${movie.year} - ${movie.duration} min - ${movie.gender}"
        )
        Text(
            text = "Director: ${movie.director}"
        )

        Text(
            text = "\nSynopsis",
            style = MaterialTheme.typography.titleMedium
        )

        Text(text = movie.summary)

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    MovieApp3Theme{
        DetailScreen(movieId = 4, onBack = {})
    }
}