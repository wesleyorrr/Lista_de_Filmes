package br.com.map.appflix.data

class MovieRepository(private val movieDataSouce: MovieDataSouce){
    fun getAllMoviesFromDataSouce() = movieDataSouce.getAllMovies()


}