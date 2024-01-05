package by.clever.servlet.dao.proxy;

import by.clever.servlet.dao.MusicBandDAO;
import by.clever.servlet.dao.impl.MusicBandDAOImpl;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * Proxy for MusicBandDAO
 */
@Component
public class MusicBandDAOProxy {

    private final MusicBandDAO musicBandDAO = new MusicBandDAOImpl();

    @Getter
    private final MusicBandDAO proxyMusicBandDAO = (MusicBandDAO) Proxy.newProxyInstance(
            musicBandDAO.getClass().getClassLoader(),
            musicBandDAO.getClass().getInterfaces(),
            new MusicBandDAOInvocationHandler(musicBandDAO));
}
