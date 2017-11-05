package persistencia;

import entidade.EDocente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Query;
import util.Conexao;
import util.Sexo;
import util.Titulacao;

public class PDocente {

    public void incluir(EDocente parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_DOCENTE);
            if (rs.next()) {
                parametro.setMatricula(rs.getInt("MATRICULA"));
            }
            rs.close();
            PreparedStatement prd = cnn.prepareStatement(Query.INSERT_DOCENTE);
            prd.setInt(1, parametro.getMatricula());
            prd.setString(2, parametro.getCPF());
            prd.setString(3, parametro.getNome());
            prd.setString(4, parametro.getDataNascimento());
            prd.setString(5, parametro.getTelefone());
            prd.setString(6, parametro.getCelular());
            prd.setString(7, parametro.getEmail());
            prd.setString(8, parametro.getEndereco());
            prd.setInt(9, parametro.getSexo().getId());
            prd.setInt(10, parametro.getTitulacao().getId());
            prd.setInt(11, parametro.getDisciplina().getCodigo());
            prd.execute(); 
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            throw ex;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public void alterar(EDocente parametro) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement prd = cnn.prepareStatement(Query.UPDATE_DOCENTE);
            prd.setString(1, parametro.getCPF());
            prd.setString(2, parametro.getNome());
            prd.setString(3, parametro.getDataNascimento());
            prd.setString(4, parametro.getTelefone());
            prd.setString(5, parametro.getCelular());
            prd.setString(6, parametro.getEmail());
            prd.setString(7, parametro.getEndereco());
            prd.setInt(8, parametro.getSexo().getId());
            prd.setInt(9, parametro.getTitulacao().getId());
            prd.setInt(10, parametro.getDisciplina().getCodigo());
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
            PreparedStatement prd = cnn.prepareStatement(Query.DELETE_DOCENTE);
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

    public EDocente consultar(int matricula) throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(Query.SELECT_DOCENTE);
        prd.setInt(1, matricula);
        ResultSet rs = prd.executeQuery();
        EDocente objeto = null;
        if (rs.next()) {
            objeto = new EDocente();
            objeto.setMatricula(rs.getInt("MATRICULA"));
            objeto.setCPF(rs.getString("CPF"));
            objeto.setNome(rs.getString("NOME"));
            objeto.setDataNascimento(rs.getString("DATANASCIMENTO"));
            objeto.setTelefone(rs.getString("TELEFONE"));
            objeto.setCelular(rs.getString("CELULAR"));
            objeto.setEmail(rs.getString("EMAIL"));
            objeto.setEndereco(rs.getString("ENDERECO"));
            objeto.setSexo(Sexo.valueOf(rs.getInt("SEXO")));
            objeto.setTitulacao(Titulacao.valueOf(rs.getInt("TITULACAO")));
            objeto.setDisciplina(new PDisciplina().consultar(rs.getInt("COD_DISCIPLINA")));            
        }
        prd.close();
        rs.close();
        return objeto;
    }

    public ArrayList<EDocente> listar() throws SQLException, Exception {
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_DOCENTE);
        ArrayList<EDocente> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            EDocente objeto = new EDocente();
            objeto.setMatricula(rs.getInt("MATRICULA"));
            objeto.setCPF(rs.getString("CPF"));
            objeto.setNome(rs.getString("NOME"));
            objeto.setDataNascimento(rs.getString("DATANASCIMENTO"));
            objeto.setTelefone(rs.getString("TELEFONE"));
            objeto.setCelular(rs.getString("CELULAR"));
            objeto.setEmail(rs.getString("EMAIL"));
            objeto.setEndereco(rs.getString("ENDERECO"));
            objeto.setSexo(Sexo.valueOf(rs.getInt("SEXO")));
            objeto.setTitulacao(Titulacao.valueOf(rs.getInt("TITULACAO")));
            objeto.setDisciplina(new PDisciplina().consultar(rs.getInt("COD_DISCIPLINA"))); 
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }
}
