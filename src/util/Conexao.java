package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao;

    private Conexao() {
    }

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = conectar();
            }
        } catch (SQLException e) {
            System.err.print(e.toString());
        }
        return conexao;
    }

    private static Connection conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@" 
                    + Propriedades.getProp("db.host") 
                    + ":1521:xe", 
                    Propriedades.getProp("db.user"), 
                    Propriedades.getProp("db.password"));
        } catch (Exception e) {
            System.err.print(e.toString());
            return null;
        }
    }
}
