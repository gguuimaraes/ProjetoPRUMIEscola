package persistencia;

import entidade.ENota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.AnoLetivo;
import util.Query;
import util.Conexao;

public class PNota {

    public void incluir(ENota parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_NOTA);
            if (rs.next()) {
                parametro.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            PreparedStatement prd = cnn.prepareStatement(Query.INSERT_NOTA);
            prd.setInt(1, parametro.getCodigo());
            prd.setDouble(2, parametro.getBimestre1());
            prd.setDouble(3, parametro.getBimestre2());
            prd.setDouble(4, parametro.getBimestre3());
            prd.setDouble(5, parametro.getBimestre4());
            prd.setDouble(6, parametro.getRecuperacaoParcial());
            prd.setDouble(7, parametro.getRecuperacaoFinal());
            prd.setInt(8, parametro.getTurma().getCodigo());
            prd.setInt(9, parametro.getDocente().getMatricula());
            prd.setInt(10, parametro.getDiscente().getMatricula());
            prd.execute();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public void alterar(ENota parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.UPDATE_NOTA);
            prd.setDouble(1, parametro.getBimestre1());
            prd.setDouble(2, parametro.getBimestre2());
            prd.setDouble(3, parametro.getBimestre3());
            prd.setDouble(4, parametro.getBimestre4());
            prd.setDouble(5, parametro.getRecuperacaoParcial());
            prd.setDouble(6, parametro.getRecuperacaoFinal());
            prd.setInt(7, parametro.getTurma().getCodigo());
            prd.setInt(8, parametro.getDocente().getMatricula());
            prd.setInt(9, parametro.getDiscente().getMatricula());
            prd.setInt(10, parametro.getCodigo());
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
            PreparedStatement prd = cnn.prepareStatement(Query.DELETE_NOTA);
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

    public List<ENota> listarPorTurma(int codigoTurma) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_NOTA_BY_TURMA);
        List<ENota> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            ENota objeto = new ENota();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setBimestre1(rs.getFloat("BIMESTRE1"));
            objeto.setBimestre2(rs.getFloat("BIMESTRE2"));
            objeto.setBimestre3(rs.getFloat("BIMESTRE3"));
            objeto.setBimestre4(rs.getFloat("BIMESTRE4"));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }
}
