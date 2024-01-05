package by.clever.servlet.mapper;

import by.clever.servlet.dto.MusicBandDTO;
import by.clever.servlet.entity.MusicBand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MusicBandMapper {

    MusicBand toMusicBand(MusicBandDTO bandDTO);

    MusicBandDTO toMusicBandDTO(MusicBand band);
}
