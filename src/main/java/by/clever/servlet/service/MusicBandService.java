package by.clever.servlet.service;


import by.clever.servlet.dto.MusicBandDTO;

import java.util.List;
import java.util.UUID;

public interface MusicBandService {

    UUID create(MusicBandDTO bandDTO);

    MusicBandDTO getByID(UUID id);

    List<MusicBandDTO> getAllBands(int pageSize, int pageNumber);

    UUID update(MusicBandDTO bandDTO);

    void delete(UUID id);
}
