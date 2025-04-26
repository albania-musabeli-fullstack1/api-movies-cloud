package com.musabeli.api_movies_cloud.repositories;

import com.musabeli.api_movies_cloud.entities.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void saveMovieTest(){
        //Arrange
        Movie movie = Movie.builder()
                .title("Jurassic Park 3")
                .year(2001)
                .director("Steven Spielberg")
                .genre("Ciencia Ficcion")
                .synopsis("Historia de dinosaurios 3")
                .build();

        //Act
        Movie resultado = movieRepository.save(movie);

        //Assert
        assertNotNull(resultado.getId());
        assertEquals("Jurassic Park 3", resultado.getTitle());
    }


    @Test
    public void findMovieByIdTest(){
        // Arrange
        Movie movie = Movie.builder()
                .title("Matrix")
                .year(1999)
                .director("Lana Wachowski, Lilly Wachowski")
                .genre("Sci-Fi")
                .synopsis("Neo descubre el mundo real y detiene balas")
                .build();
        Movie newMovie = movieRepository.save(movie);

        // Act
        Movie movieById = movieRepository.findById(newMovie.getId()).orElse(null);

        // Assert
        assertNotNull(movieById);
        assertEquals(newMovie.getId(), movieById.getId());
    }
}