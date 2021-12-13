package br.com.map.appflix.data

import br.com.map.appflix.domain.Movie

interface MovieDataSouce {

    fun getAllMovies():List<Movie>
}