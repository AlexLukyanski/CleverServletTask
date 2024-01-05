package by.clever.servlet.service.proxy;

import by.clever.servlet.service.MusicBandService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MusicBandServiceInvocationHandler implements InvocationHandler {

    private final MusicBandService musicBandService;

    public MusicBandServiceInvocationHandler(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(musicBandService, args);
    }
}
