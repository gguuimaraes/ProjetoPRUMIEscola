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

            PDiscenteTurma pDiscenteTurma = new PDiscenteTurma();
            for (EPessoaTurma discenteTurma : parametro.getDiscentes()) {
                pDiscenteTurma.incluir(discenteTurma, cnn);
            }

            PDocenteTurma pDocenteTurma = new PDocenteTurma();
            for (EPessoaTurma docenteTurma : parametro.getDocentes()) {
                pDocenteTurma.incluir(docenteTurma, cnn);
            }
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

            PDiscenteTurma pDiscenteTurma = new PDiscenteTurma();
            pDiscenteTurma.excluirPorTurma(parametro.getCodigo(), cnn);
            for (EPessoaTurma discenteTurma : parametro.getDiscentes()) {
                pDiscenteTurma.incluir(discenteTurma, cnn);
            }

            PDocenteTurma pDocenteTurma = new PDocenteTurma();
            pDocenteTurma.excluirPorTurma(parametro.getCodigo(), cnn);
            for (EPessoaTurma docenteTurma : parametro.getDocentes()) {
                pDocenteTurma.incluir(docenteTurma, cnn);
            }

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

            PDiscenteTurma pDiscenteTurma = new PDiscenteTurma();
            pDiscenteTurma.excluirPorTurma(codigo, cnn);

            PDocenteTurma pDocenteTurma = new PDocenteTurma();
            pDocenteTurma.excluirPorTurma(codigo, cnn);

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

            PDiscenteTurma pDiscenteTurma = new PDiscenteTurma();
            objeto.setDiscentes(pDiscenteTurma.listarPorTurma(codigo, cnn));

            PDocenteTurma pDocenteTurma = new PDocenteTurma();
            objeto.setDocentes(pDocenteTurma.listarPorTurma(codigo, cnn));

        }
        prd.close();
        rs.close();
        return objeto;
    }

    public List<ETurma> listar() throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_TURMA);
        ArrayList<ETurma> lista = null;
        PDiscenteTurma pDiscenteTurma = null;
        PDocenteTurma pDocenteTurma = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            if (pDiscenteTurma == null) {
                pDiscenteTurma = new PDiscenteTurma();
            }
            if (pDocenteTurma == null) {
                pDocenteTurma = new PDocenteTurma();
            }
            ETurma objeto = new ETurma();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setAnoLetivo(AnoLetivo.valueOf(rs.getInt("ANOLETIVO")));
            objeto.setLetra(rs.getString("LETRA").charAt(0));
            objeto.setAnoAtual(rs.getString("ANOATUAL"));
            objeto.setNumeroVagas(rs.getInt("NUMEROVAGAS"));
            objeto.setStatus(StatusTurma.valueOf(rs.getInt("STATUS")));
            
            objeto.setDiscentes(pDiscenteTurma.listarPorTurma(objeto.getCodigo(), cnn));

            objeto.setDocentes(pDocenteTurma.listarPorTurma(objeto.getCodigo(), cnn));

            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }
}
