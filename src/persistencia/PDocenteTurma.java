package persistencia;

import entidade.EPessoaTurma;
import entidade.ETurma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Query;
import util.StatusPessoaTurma;

public class PDocenteTurma {

    public void incluir(EPessoaTurma parametro, Connection cnn) throws SQLException, Exception {
        PreparedStatement prd = cnn.prepareStatement(Query.INSERT_DOCENTETURMA);
        prd.setInt(1, parametro.getPessoa().getMatricula());
        prd.setInt(2, parametro.getTurma().getCodigo());
        prd.setInt(3, parametro.getStatus().getId());
        prd.execute();
    }
    
    public void excluirPorTurma(int codigoTurma, Connection cnn) throws SQLException {
        PreparedStatement prd = cnn.prepareStatement(Query.DELETE_DOCENTETURMA_BY_TURMA);
        prd.setInt(1, codigoTurma);
        prd.execute();
    }

    public List<EPessoaTurma> listarPorTurma(int codigoTurma, Connection cnn) throws SQLException, Exception {
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_DOCENTETURMA_BY_TURMA);
        List<EPessoaTurma> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            EPessoaTurma objeto = new EPessoaTurma();
            objeto.setPessoa(new PDocente().consultar(rs.getInt("MAT_DOCENTE")));
            ETurma turma = new ETurma();
            turma.setCodigo(rs.getInt("COD_TURMA"));
            objeto.setTurma(turma);
            objeto.setStatus(StatusPessoaTurma.valueOf(rs.getInt("STATUS")));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }
}
