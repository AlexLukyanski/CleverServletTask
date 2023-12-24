package by.clever.servlet.controller.impl;

import by.clever.servlet.controller.Command;
import by.clever.servlet.controller.constant.RequestParam;
import by.clever.servlet.dto.MusicBandDTO;
import by.clever.servlet.entity.MusicBand;
import by.clever.servlet.entity.constant.MusicGenre;
import by.clever.servlet.mapper.MusicBandMapper;
import by.clever.servlet.mapper.MusicBandMapperImpl;
import by.clever.servlet.service.MusicBandService;
import by.clever.servlet.service.proxy.MusicBandServiceProxy;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.UUID;

public class CreateMusicBand implements Command {

    private final static MusicBandService musicBandService = MusicBandServiceProxy.getInstance();
    private final static MusicBandMapper mapper = new MusicBandMapperImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MusicBand musicBand = setMusicBand(request);
        MusicBandDTO musicBandDTO = mapper.toMusicBandDTO(musicBand);

        UUID bandID = musicBandService.create(musicBandDTO);
        String json = new Gson().toJson(bandID);
        try (PrintWriter out = response.getWriter()) {
            out.write(json);
        }
    }

    private MusicBand setMusicBand(HttpServletRequest request) {

        MusicBand musicBand = new MusicBand();
        musicBand.setName(request.getParameter(RequestParam.BAND_NAME));
        musicBand.setGenre(MusicGenre.valueOf(request.getParameter(RequestParam.BAND_GENRE)));
        musicBand.setCreationDate(LocalDate.parse(request.getParameter(RequestParam.BAND_CREATION_DATE)));
        musicBand.setWorkPhoneNumber(request.getParameter(RequestParam.BAND_PHONE));
        musicBand.setWorkEmail(request.getParameter(RequestParam.BAND_EMAIL));
        return musicBand;
    }
}
