package br.com.map.appflix.implementation


import android.util.Log
import br.com.map.appflix.framework.api.MovieRestApiTask
import br.com.map.appflix.data.MovieDataSouce
import br.com.map.appflix.domain.Movie


class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask) : MovieDataSouce {
    companion object{
        const val TAG = "MovieRepository"
    }
    private val movieList = arrayListOf<Movie>()
    override fun getAllMovies(): List<Movie> {
        val  request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful){

            request.body()?.let {
                movieList.addAll(it)

            }
        }else{
            request.errorBody()?.let {
                Log.d(TAG,it.toString())
            }

        }


        return movieList
    }


}