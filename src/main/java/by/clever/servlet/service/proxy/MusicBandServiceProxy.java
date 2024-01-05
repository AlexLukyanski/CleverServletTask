package by.clever.servlet.service.proxy;

import by.clever.servlet.dao.proxy.MusicBandDAOProxy;
import by.clever.servlet.mapper.MusicBandMapper;
import by.clever.servlet.mapper.MusicBandMapperImpl;
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

        private final static MusicBandMapper mapper = new MusicBandMapperImpl();
        private final static MusicBandDAOProxy proxy = new MusicBandDAOProxy();
        private final static MusicBandService musicBandService = new MusicBandServiceImpl(mapper, proxy);

        private static final MusicBandService proxyMusicBandService = (MusicBandService) Proxy.newProxyInstance(
                musicBandService.getClass().getClassLoader(),
                musicBandService.getClass().getInterfaces(),
                new MusicBandServiceInvocationHandler(musicBandService));
    }
}