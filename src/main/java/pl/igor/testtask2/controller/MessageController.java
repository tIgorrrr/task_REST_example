package pl.igor.testtask2.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.igor.testtask2.model.GeoDataDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("geolocation")
public class MessageController {

    private final CrudRepository<GeoDataDto, Long> geoDataDtoLongCrudRepository;

    public MessageController(CrudRepository<GeoDataDto, Long> geoDataDtoLongCrudRepository) {
        this.geoDataDtoLongCrudRepository = geoDataDtoLongCrudRepository;
    }

    @GetMapping
    public ResponseEntity<Collection<GeoDataDto>>  getAll() {

        List<GeoDataDto> geoDataList = new ArrayList<>();

        geoDataDtoLongCrudRepository.findAll().forEach(geoDataList::add);

        if (geoDataList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(geoDataList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeoDataDto> getById(@PathVariable Long id) {
        return geoDataDtoLongCrudRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GeoDataDto> create(@RequestBody GeoDataDto oneData) {

        if (oneData.getDeviceId() == null || oneData.getLatitude() == 0 || oneData.getLongitude() == 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(geoDataDtoLongCrudRepository.save(oneData));
    }
}
