package persistencia;

import entidade.EDiscente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Query;
import util.Conexao;
import util.Sexo;

public class PDiscente {

    public void incluir(EDiscente parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_DISCENTE);
            if (rs.next()) {
                parametro.setMatricula(rs.getInt("MATRICULA"));
            }
            rs.close();
            PreparedStatement prd = cnn.prepareStatement(Query.INSERT_DISCENTE);
            prd.setInt(1, parametro.getMatricula());
            prd.setString(2, parametro.getCPF());
            prd.setString(3, parametro.getNome());
            prd.setString(4, parametro.getNomePai());
            prd.setString(5, parametro.getNomeMae());
            prd.setString(6, parametro.getDataNascimento());
            prd.setString(7, parametro.getTelefone());
            prd.setString(8, parametro.getCelular());
            prd.setString(9, parametro.getEmail());
            prd.setString(10, parametro.getEndereco());
            prd.setInt(11, parametro.getSexo().getId());
            prd.execute(); 
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public void alterar(EDiscente parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.UPDATE_DISCENTE);
            prd.setString(1, parametro.getCPF());
            prd.setString(2, parametro.getNome());
            prd.setString(3, parametro.getNomePai());
            prd.setString(4, parametro.getNomeMae());
            prd.setString(5, parametro.getDataNascimento());
            prd.setString(6, parametro.getTelefone());
            prd.setString(7, parametro.getCelular());
            prd.setString(8, parametro.getEmail());
            prd.setString(9, parametro.getEndereco());
            prd.setInt(10, parametro.getSexo().getId());
            prd.setInt(11, parametro.getMatricula());
            prd.executeUpdate();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public void excluir(int matricula) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.DELETE_DISCENTE);
            prd.setInt(1, matricula);
            prd.execute();
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public EDiscente consultar(int matricula) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(Query.SELECT_DISCENTE);
        prd.setInt(1, matricula);
        ResultSet rs = prd.executeQuery();
        EDiscente objeto = null;
        if (rs.next()) {
            objeto = new EDiscente();
            objeto.setMatricula(rs.getInt("MATRICULA"));
            objeto.setCPF(rs.getString("CPF"));
            objeto.setNome(rs.getString("NOME"));
            objeto.setNomePai(rs.getString("NOMEPAI"));
            objeto.setNomeMae(rs.getString("NOMEMAE"));
            objeto.setDataNascimento(rs.getString("DATANASCIMENTO"));
            objeto.setTelefone(rs.getString("TELEFONE"));
            objeto.setCelular(rs.getString("CELULAR"));
            objeto.setEmail(rs.getString("EMAIL"));
            objeto.setEndereco(rs.getString("ENDERECO"));
            objeto.setSexo(Sexo.valueOf(rs.getInt("SEXO")));
        }
        prd.close();
        rs.close();
        return objeto;
    }

    public ArrayList<EDiscente> listar() throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_DISCENTE);
        ArrayList<EDiscente> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            EDiscente objeto = new EDiscente();
            objeto.setMatricula(rs.getInt("MATRICULA"));
            objeto.setCPF(rs.getString("CPF"));
            objeto.setNome(rs.getString("NOME"));
            objeto.setNomePai(rs.getString("NOMEPAI"));
            objeto.setNomeMae(rs.getString("NOMEMAE"));
            objeto.setDataNascimento(rs.getString("DATANASCIMENTO"));
            objeto.setTelefone(rs.getString("TELEFONE"));
            objeto.setCelular(rs.getString("CELULAR"));
            objeto.setEmail(rs.getString("EMAIL"));
            objeto.setEndereco(rs.getString("ENDERECO"));
            objeto.setSexo(Sexo.valueOf(rs.getInt("SEXO")));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }
}
