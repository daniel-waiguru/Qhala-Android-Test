package tech.danielwaiguru.qhalamovies.ui.views.movie_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_movie, container, false)
        return binding.root
    }
}