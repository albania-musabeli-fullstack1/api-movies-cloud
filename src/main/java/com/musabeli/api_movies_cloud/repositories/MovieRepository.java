package com.musabeli.api_movies_cloud.repositories;

import com.musabeli.api_movies_cloud.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {}
