package tech.danielwaiguru.qhalamovies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.qhalamovies.R

class MovieAdapter(
    private val clickListener: MovieClickListener): ListAdapter<Movie, MovieViewHolder>(MovieDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bindMovieItem(movie, holder.itemView.context)
        holder.itemView.setOnClickListener {
            clickListener.onMovieClicked(movie.id)
        }
    }

    object MovieDiffCallback: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }
    interface MovieClickListener {
        fun onMovieClicked(mId: Int)
    }
}