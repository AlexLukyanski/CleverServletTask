package by.clever.servlet.dao;

import by.clever.servlet.entity.MusicBand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MusicBandDAO {

    UUID save(MusicBand band);

    Optional<MusicBand> readByID(UUID id);

    List<MusicBand> readAll(int pageSize, int pageNumber);

    UUID update(MusicBand band);

    void delete(UUID id);
}
