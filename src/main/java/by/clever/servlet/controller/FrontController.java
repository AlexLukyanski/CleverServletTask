package by.clever.servlet.controller;

import by.clever.servlet.controller.constant.RequestParam;
import by.clever.servlet.dao.connectionpool.ConnectionPool;
import by.clever.servlet.dao.connectionpool.ConnectionPoolException;
import by.clever.servlet.dao.constant.ApplicationYMLParam;
import by.clever.servlet.dao.exception.DAOException;
import by.clever.servlet.script.SqlScriptUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serial;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class FrontController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 111126817858529649L;
    private final Logger log = LogManager.getRootLogger();
    private final CommandFactory commandFactory = new CommandFactory();

    public FrontController() {

    }

    @Override
    public void init() {

        initializeConnectionPool();
        boolean initParam = readInitParameter();

        if (initParam) {
            createAndInitializeDB();
        }
    }

    @Override
    public void destroy() {
        dropDB();
        clearConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        executeRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        executeRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        executeRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        executeRequest(request, response);
    }

    private void executeRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final String contentType = "text/html";
        response.setContentType(contentType);

        String name = request.getParameter(RequestParam.FRONT_CONTROLLER_ATTRIBUTE);
        Command command = commandFactory.getCommand(name);
        command.execute(request, response);
    }

    private void initializeConnectionPool() {
        try {
            ConnectionPool instance = ConnectionPool.getInstance();
            instance.initPoolData();

        } catch (ConnectionPoolException e) {
            log.log(Level.ERROR, "ConnectionPool broken", e);
        }
    }

    private void clearConnectionPool() {
        try {
            ConnectionPool instance = ConnectionPool.getInstance();
            instance.clearConnectionQueue();
        } catch (ConnectionPoolException e) {
            log.log(Level.ERROR, "ConnectionPool broken", e);
        }
    }

    private void createAndInitializeDB() {

        try (Connection connection = ConnectionPool.getInstance().takeConnection()) {

            String path = new File(ClassLoader.getSystemClassLoader().getResource("create-and-init-db.sql").getFile())
                    .toPath()
                    .toString();
            SqlScriptUtility.runScript(path, connection);

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void dropDB() {

        final String dropDbSql = "DROP TABLE IF EXISTS public.music_band_test";

        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(dropDbSql);

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    private boolean readInitParameter() {

        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(ApplicationYMLParam.YML_FILE_NAME);
        Map<String, Object> mapYML = yaml.load(inputStream);

        boolean initParam = (boolean) mapYML.get(ApplicationYMLParam.INIT_DB);
        return initParam;
    }
}