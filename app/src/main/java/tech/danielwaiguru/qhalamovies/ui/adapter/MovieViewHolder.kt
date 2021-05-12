package tech.danielwaiguru.qhalamovies.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.common.extensions.loadImage
import tech.danielwaiguru.qhalamovies.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindMovieItem(movie: Movie, context: Context) {
        with(binding) {
            movieTitle.text = movie.title
            movieDate.text = movie.releaseDate
            this.voteCount.text = context.getString(R.string.ratings, movie.voteAverage.toString())
            this.popularity.text = context.getString(R.string.language, movie.language)
            moviePoster.loadImage(movie.posterPath)
        }
    }
}