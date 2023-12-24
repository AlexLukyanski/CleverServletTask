package by.clever.servlet.controller.impl;

import by.clever.servlet.controller.Command;
import by.clever.servlet.controller.constant.RequestParam;
import by.clever.servlet.dto.MusicBandDTO;
import by.clever.servlet.service.MusicBandService;
import by.clever.servlet.service.proxy.MusicBandServiceProxy;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReadAllMusicBands implements Command {

    private final static MusicBandService musicBandService = MusicBandServiceProxy.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageSizeString = request.getParameter(RequestParam.PAGE_SIZE);
        String pageNumberString = request.getParameter(RequestParam.PAGE_NUMBER);
        int pageSize = 0;
        int pageNumber = 1;

        if (pageSizeString != null) {
            pageSize = Integer.parseInt(pageSizeString);
        }
        if (pageNumberString != null) {
            pageNumber = Integer.parseInt(pageNumberString);
        }

        List<MusicBandDTO> musicBandDTOList = musicBandService.getAllBands(pageSize, pageNumber);
        String json = new Gson().toJson(musicBandDTOList);
        try (PrintWriter out = response.getWriter()) {
            out.write(json);
        }
    }
}
