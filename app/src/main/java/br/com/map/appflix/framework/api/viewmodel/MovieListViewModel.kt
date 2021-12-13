package br.com.map.appflix.framework.api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.map.appflix.domain.Movie
import br.com.map.appflix.framework.api.MovieRestApiTask
import br.com.map.appflix.data.MovieRepository
import br.com.map.appflix.implementation.MovieDataSourceImplementation

import br.com.map.appflix.usecase.MoviesListUseCase
import kotlin.concurrent.thread

class MovieListViewModel:ViewModel(){

    companion object{
        const val TAG = "MovieRepository"
    }



  private val movieRestApiTask = MovieRestApiTask()
    private val  movieDataSouce = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSouce)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)


    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList



     fun init() {
getAllMovies()
     }
    private fun getAllMovies() {
        thread{
            try {
                _moviesList.postValue(moviesListUseCase.invoke())

            }catch (exception:Exception){
                Log.d(TAG, exception.message.toString())
            }
        }

    }
}