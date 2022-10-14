package tech.danielwaiguru.qhalamovies.ui.movie_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.databinding.FragmentMoviesBinding
import tech.danielwaiguru.qhalamovies.ui.movie_list.adapter.MovieAdapter

@AndroidEntryPoint
class MoviesFragment : Fragment(), MovieAdapter.MovieClickListener {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter(this)
    }
    private val moviesViewModel: MoviesViewModel by viewModels()
    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_movies, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initBinders()
        subscribers()
    }

    private fun initBinders() {
        binding.movieAdapter = movieAdapter
    }

    private fun subscribers() {
        viewLifecycleOwner.lifecycleScope.launch {
            moviesViewModel.getPopularMovies()
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    movieAdapter.submitData(it)
                }
        }
    }

    override fun onMovieClicked(mId: Int) {
        navToDetailsScreen(mId)
    }

    private fun navToDetailsScreen(mId: Int) {
        findNavController().navigate(
            MoviesFragmentDirections.actionMovieFragmentToMovieDetailsFragment(mId)
        )
    }
}