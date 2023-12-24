package by.clever.servlet.script;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.sql.Connection;

public class SqlScriptUtility {

    public static void runScript(String path, Connection connection) throws Exception {
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setSendFullScript(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.runScript(new java.io.FileReader(path));
    }
}
