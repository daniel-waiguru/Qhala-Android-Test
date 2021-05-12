package tech.danielwaiguru.qhalamovies.ui.views.movie_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.common.extensions.showToast
import tech.danielwaiguru.qhalamovies.databinding.FragmentMovieBinding
import tech.danielwaiguru.qhalamovies.models.ResultWrapper
import tech.danielwaiguru.qhalamovies.ui.adapter.MovieAdapter
import tech.danielwaiguru.qhalamovies.ui.viewmodels.MovieViewModel


class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter()
    }
    private val movieViewModel: MovieViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_movie, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribers()
    }
    private fun subscribers() {
        movieViewModel.responseState.observe(viewLifecycleOwner, { responseState ->
            when (responseState) {
                is ResultWrapper.Success -> {
                    movieAdapter.submitList(responseState.data)
                    binding.moviesRv.adapter = movieAdapter
                }
                is ResultWrapper.Loading -> {

                }
                is ResultWrapper.Error -> {
                    requireContext().showToast(responseState.errorMessage.toString())
                }
            }
        })
    }
}