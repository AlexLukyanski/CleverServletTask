package by.clever.servlet.dao.proxy;

import by.clever.servlet.dao.MusicBandDAO;
import by.clever.servlet.dao.impl.MusicBandDAOImpl;

import java.lang.reflect.Proxy;

/**
 * Proxy for MusicBandDAO
 */
public class MusicBandDAOProxy {

    private MusicBandDAOProxy() {

    }

    public static MusicBandDAO getInstance() {

        return MusicBandDAOProxyHelper.proxyMusicBandDAO;
    }

    private static class MusicBandDAOProxyHelper {
        private final static MusicBandDAO musicBandDAO = new MusicBandDAOImpl();

        private static final MusicBandDAO proxyMusicBandDAO = (MusicBandDAO) Proxy.newProxyInstance(
                musicBandDAO.getClass().getClassLoader(),
                musicBandDAO.getClass().getInterfaces(),
                new MusicBandDAOInvocationHandler(musicBandDAO));
    }
}
