package by.clever.servlet.controller.impl;

import by.clever.servlet.controller.Command;
import by.clever.servlet.controller.constant.RequestParam;
import by.clever.servlet.service.MusicBandService;
import by.clever.servlet.service.proxy.MusicBandServiceProxy;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

public class DeleteMusicBand implements Command {

    private final static MusicBandService musicBandService = MusicBandServiceProxy.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stringID = request.getParameter(RequestParam.BAND_ID);
        UUID bandID = UUID.fromString(stringID);
        musicBandService.delete(bandID);
    }
}
