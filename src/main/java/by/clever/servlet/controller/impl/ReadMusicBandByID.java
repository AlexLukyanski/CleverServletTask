package by.clever.servlet.controller.impl;

import by.clever.servlet.adapter.LocalDateTimeJsonAdapter;
import by.clever.servlet.controller.Command;
import by.clever.servlet.controller.constant.RequestParam;
import by.clever.servlet.dto.MusicBandDTO;
import by.clever.servlet.service.MusicBandService;
import by.clever.servlet.service.proxy.MusicBandServiceProxy;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.UUID;

public class ReadMusicBandByID implements Command {

    private final static MusicBandService musicBandService = MusicBandServiceProxy.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stringID = request.getParameter(RequestParam.BAND_ID);
        UUID bandID = UUID.fromString(stringID);
        MusicBandDTO musicBandDTO = musicBandService.getByID(bandID);

        String json = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTimeJsonAdapter())
                .create()
                .toJson(musicBandDTO);

        try (PrintWriter out = response.getWriter()) {
            out.write(json);
        }
    }
}
