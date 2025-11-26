package com.example.test_lab_week_12.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.test_lab_week_12.model.Movie
import com.example.test_lab_week_12.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    init {
        fetchPopularMovies()
    }

    val popularMovies: LiveData<List<Movie>> = repository.movies
    val error: LiveData<String> = repository.error

    private fun fetchPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchMovies()
        }
    }
}
