package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao;

    private Conexao() {
    }

    public static Connection getConexao() throws SQLException, Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = conectar();
            }
        } catch (SQLException e) {
            throw e;
        }
        return conexao;
    }

    private static Connection conectar() throws Exception {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@"
                    + Propriedades.getProp("db.host")
                    + ":1521:xe",
                    Propriedades.getProp("db.user"),
                    Propriedades.getProp("db.password"));
        } catch (Exception e) {
            throw e;
        }
    }
}
