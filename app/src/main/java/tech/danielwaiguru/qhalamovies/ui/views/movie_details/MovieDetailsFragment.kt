package tech.danielwaiguru.qhalamovies.ui.views.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.common.extensions.gone
import tech.danielwaiguru.qhalamovies.common.extensions.showToast
import tech.danielwaiguru.qhalamovies.common.extensions.visible
import tech.danielwaiguru.qhalamovies.databinding.FragmentMovieDetailsBinding
import tech.danielwaiguru.qhalamovies.models.ResultWrapper
import tech.danielwaiguru.qhalamovies.ui.viewmodels.MovieDetailViewModel
import tech.danielwaiguru.qhalamovies.ui.viewmodels.MovieDetailViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding
    @Inject
    lateinit var detailViewModelFactory: MovieDetailViewModelFactory
    private val detailViewModel: MovieDetailViewModel by viewModels { detailViewModelFactory }
    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_movie_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribers()
        fetchMovieDetails()
    }
    private fun fetchMovieDetails() {
        detailViewModel.fetchMovieDetails(getArgs())
    }
    private fun getArgs(): Int {
        val args: MovieDetailsFragmentArgs by navArgs()
        return args.mId
    }
    private fun subscribers() {
        detailViewModel.movieState.observe(viewLifecycleOwner, { response ->
            when(response) {
                is ResultWrapper.Error -> {
                    binding.loadingProgress.gone()
                }
                is ResultWrapper.Loading -> {
                    binding.loadingProgress.visible()
                }
                is ResultWrapper.Success -> {
                    binding.loadingProgress.gone()
                    binding.movie = response.data
                }
            }
        })
    }
}