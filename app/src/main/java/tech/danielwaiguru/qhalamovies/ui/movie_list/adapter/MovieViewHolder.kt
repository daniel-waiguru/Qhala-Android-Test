package tech.danielwaiguru.qhalamovies.ui.movie_list.adapter

import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.common.extensions.loadImage
import tech.danielwaiguru.qhalamovies.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindMovieItem(movie: Movie, clickListener: MovieAdapter.MovieClickListener) {
        with(binding) {
            root.setOnClickListener { clickListener.onMovieClicked(movie.id) }
            val context = root.context
            movieTitle.text = movie.title
            movieDate.text = context.getString(R.string.release_date, movie.releaseDate)
            this.voteCount.text = context.getString(R.string.ratings, movie.voteAverage.toString())
            this.popularity.text = context.getString(R.string.language, movie.language)
            moviePoster.loadImage(movie.posterPath)
        }
    }
}