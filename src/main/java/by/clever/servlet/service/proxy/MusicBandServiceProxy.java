package by.clever.servlet.service.proxy;

import by.clever.servlet.service.MusicBandService;
import by.clever.servlet.service.impl.MusicBandServiceImpl;

import java.lang.reflect.Proxy;

public class MusicBandServiceProxy {

    private MusicBandServiceProxy() {

    }

    public static MusicBandService getInstance() {

        return MusicBandServiceProxyHelper.proxyMusicBandService;
    }

    private static class MusicBandServiceProxyHelper {

        private final static MusicBandService musicBandService = new MusicBandServiceImpl();

        private static final MusicBandService proxyMusicBandService = (MusicBandService) Proxy.newProxyInstance(
                musicBandService.getClass().getClassLoader(),
                musicBandService.getClass().getInterfaces(),
                new MusicBandServiceInvocationHandler(musicBandService));
    }
}