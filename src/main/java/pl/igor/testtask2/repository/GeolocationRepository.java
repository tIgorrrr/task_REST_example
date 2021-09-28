package pl.igor.testtask2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.igor.testtask2.model.GeoDataDto;

@Repository
public interface GeolocationRepository extends CrudRepository<GeoDataDto, Long> {
}
