package tech.danielwaiguru.qhalamovies.ui.views.movie_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import tech.danielwaiguru.qhalamovies.R
import tech.danielwaiguru.qhalamovies.databinding.FragmentMovieBinding
import tech.danielwaiguru.qhalamovies.ui.viewmodels.MovieDetailViewModel
import tech.danielwaiguru.qhalamovies.ui.viewmodels.MovieDetailViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding
    @Inject
    lateinit var detailViewModelFactory: MovieDetailViewModelFactory
    private val detailViewModel: MovieDetailViewModel by viewModels { detailViewModelFactory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_movie_details, container, false)
        return binding.root
    }
}