package br.com.map.appflix.usecase

import br.com.map.appflix.data.MovieRepository

class MoviesListUseCase(private val movieRepository:MovieRepository) {
    operator fun invoke() = movieRepository.getAllMoviesFromDataSouce()

}