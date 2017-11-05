package persistencia;

import entidade.EDisciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.AnoLetivo;
import util.Query;
import util.Conexao;
import util.Sexo;

public class PDisciplina {

    public void incluir(EDisciplina parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_DISCIPLINA);
            if (rs.next()) {
                parametro.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            PreparedStatement prd = cnn.prepareStatement(Query.INSERT_DISCIPLINA);
            prd.setInt(1, parametro.getCodigo());
            prd.setString(2, parametro.getDescricao());
            prd.setInt(3, parametro.getAnoLetivo().getId());
            prd.setInt(4, parametro.getCargaHoraria());
            prd.execute();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.close();
        }
    }

    public void alterar(EDisciplina parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.UPDATE_DISCIPLINA);
            prd.setString(1, parametro.getDescricao());
            prd.setInt(2, parametro.getAnoLetivo().getId());
            prd.setInt(3, parametro.getCargaHoraria());
            prd.setInt(4, parametro.getCodigo());
            prd.executeUpdate();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.close();
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.DELETE_DISCIPLINA);
            prd.setInt(1, codigo);
            prd.execute();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.close();
        }
    }

    public EDisciplina consultar(int codigo) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(Query.SELECT_DISCIPLINA);
        prd.setInt(1, codigo);
        ResultSet rs = prd.executeQuery();
        EDisciplina objeto = null;
        if (rs.next()) {
            objeto = new EDisciplina();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setDescricao(rs.getString("DESCRICAO"));
            objeto.setAnoLetivo(AnoLetivo.valueOf(rs.getInt("ANOLETIVO")));
            objeto.setCargaHoraria(rs.getInt("CARGAHORARIA"));
        }
        prd.close();
        rs.close();
        cnn.close();
        return objeto;
    }

    public ArrayList<EDisciplina> listar() throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_DISCIPLINA);
        ArrayList<EDisciplina> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            EDisciplina objeto = new EDisciplina();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setDescricao(rs.getString("DESCRICAO"));
            objeto.setAnoLetivo(AnoLetivo.valueOf(rs.getInt("ANOLETIVO")));
            objeto.setCargaHoraria(rs.getInt("CARGAHORARIA"));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        cnn.close();
        return lista;
    }
}
