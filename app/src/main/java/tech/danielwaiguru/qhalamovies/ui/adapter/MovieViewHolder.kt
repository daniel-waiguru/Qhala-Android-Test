package tech.danielwaiguru.qhalamovies.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.qhalamovies.common.extensions.loadImage
import tech.danielwaiguru.qhalamovies.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindMovieItem(movie: Movie) {
        with(binding) {
            movieTitle.text = movie.title
            movieGenre.text = movie.originalTitle
            moviePoster.loadImage(movie.poster)
        }
    }
}