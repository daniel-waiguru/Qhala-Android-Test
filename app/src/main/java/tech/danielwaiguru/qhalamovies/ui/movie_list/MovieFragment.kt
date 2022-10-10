package tech.danielwaiguru.qhalamovies.ui.movie_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.common.extensions.gone
import tech.danielwaiguru.qhalamovies.common.extensions.showToast
import tech.danielwaiguru.qhalamovies.common.extensions.visible
import tech.danielwaiguru.qhalamovies.databinding.FragmentMovieBinding
import tech.danielwaiguru.domain.common.ResultWrapper
import tech.danielwaiguru.qhalamovies.ui.movie_list.adapter.MovieAdapter

@AndroidEntryPoint
class MovieFragment : Fragment(), MovieAdapter.MovieClickListener {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter(this)
    }
    private val movieViewModel: MovieViewModel by viewModels()
    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
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
        with(binding) {
            movieViewModel.responseState.observe(viewLifecycleOwner, { responseState ->
                when (responseState) {
                    is ResultWrapper.Success -> {
                        loadingProgress.gone()
                        movieAdapter.submitList(responseState.data)
                        moviesRv.adapter = movieAdapter
                    }
                    is ResultWrapper.Loading -> {
                        loadingProgress.visible()
                    }
                    is ResultWrapper.Error -> {
                        loadingProgress.gone()
                        requireContext().showToast(responseState.errorMessage.toString())
                    }
                }
            })
        }
    }

    override fun onMovieClicked(mId: Int) {
        navToDetailsScreen(mId)
    }

    private fun navToDetailsScreen(mId: Int) {
        findNavController().navigate(
            MovieFragmentDirections.actionMovieFragmentToMovieDetailsFragment(mId)
        )
    }
}