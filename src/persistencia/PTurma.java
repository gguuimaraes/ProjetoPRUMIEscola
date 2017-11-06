package persistencia;

import entidade.ETurma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.AnoLetivo;
import util.Query;
import util.Conexao;
import util.StatusTurma;

public class PTurma {

    public void incluir(ETurma parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_TURMA);
            if (rs.next()) {
                parametro.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            PreparedStatement prd = cnn.prepareStatement(Query.INSERT_TURMA);
            prd.setInt(1, parametro.getCodigo());
            prd.setInt(2, parametro.getAnoLetivo().getId());
            prd.setInt(3, parametro.getLetra());
            prd.setString(4, parametro.getAnoAtual());
            prd.setInt(5, parametro.getNumeroVagas());
            prd.setInt(6, parametro.getStatus().getId());
            prd.execute();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public void alterar(ETurma parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.UPDATE_TURMA);
            prd.setInt(1, parametro.getAnoLetivo().getId());
            prd.setInt(2, parametro.getLetra());
            prd.setString(3, parametro.getAnoAtual());
            prd.setInt(4, parametro.getNumeroVagas());
            prd.setInt(5, parametro.getStatus().getId());
            prd.setInt(6, parametro.getCodigo());
            prd.executeUpdate();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.DELETE_TURMA);
            prd.setInt(1, codigo);
            prd.execute();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public ETurma consultar(int codigo) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(Query.SELECT_TURMA);
        prd.setInt(1, codigo);
        ResultSet rs = prd.executeQuery();
        ETurma objeto = null;
        if (rs.next()) {
            objeto = new ETurma();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setAnoLetivo(AnoLetivo.valueOf(rs.getInt("ANOLETIVO")));
            objeto.setLetra(rs.getString("LETRA").charAt(0));
            objeto.setAnoAtual(rs.getString("ANOATUAL"));
            objeto.setNumeroVagas(rs.getInt("NUMEROVAGAS"));
            objeto.setStatus(StatusTurma.valueOf(rs.getInt("STATUS")));
        }
        prd.close();
        rs.close();
        return objeto;
    }

    public ArrayList<ETurma> listar() throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_TURMA);
        ArrayList<ETurma> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            ETurma objeto = new ETurma();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setAnoLetivo(AnoLetivo.valueOf(rs.getInt("ANOLETIVO")));
            objeto.setLetra(rs.getString("LETRA").charAt(0));
            objeto.setAnoAtual(rs.getString("ANOATUAL"));
            objeto.setNumeroVagas(rs.getInt("NUMEROVAGAS"));
            objeto.setStatus(StatusTurma.valueOf(rs.getInt("STATUS")));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }
}
