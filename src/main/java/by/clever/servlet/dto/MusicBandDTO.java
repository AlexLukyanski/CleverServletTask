package by.clever.servlet.dto;

import by.clever.servlet.entity.constant.MusicGenre;
import java.time.LocalDate;
import java.util.UUID;

public record MusicBandDTO(

        UUID id,
        String name,
        MusicGenre genre,
        LocalDate creationDate,
        String workPhoneNumber,
        String workEmail
) {
}
