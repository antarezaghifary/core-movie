package com.example.coremovie.presentation.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.coremovie.R
import com.example.coremovie.databinding.FragmentHomeBinding
import com.example.coremovie.domain.model.popular.PopularResponse
import com.example.coremovie.presentation.home.viewmodel.HomeViewModel
import com.example.coremovie.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPopularMovies()
        initStateApi()
    }

    private fun initStateApi(){
        viewModel.popularMoviesState.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    showLoadingIndicator()
                }
                is Resource.Success -> {
                    resource.data?.let { popularResponse ->
                        showPopularMovies(popularResponse)
                    }
                }
                is Resource.Error -> {
                    showError(resource.errMsg)
                }
            }
        }
    }

    private fun showLoadingIndicator() {

    }

    private fun showPopularMovies(popularResponse: PopularResponse) {
    }

    private fun showError(message: String?) {
        Toast.makeText(context, message ?: "Unknown error", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Prevent memory leaks
    }
}