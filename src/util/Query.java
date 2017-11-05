package util;

public class Query {
    //DISCENTE
    public static String INSERT_DISCENTE = "INSERT INTO DISCENTE "
            + "(MATRICULA, CPF, NOME, NOMEPAI, NOMEMAE, DATANASCIMENTO, TELEFONE, CELULAR, EMAIL, ENDERECO, SEXO) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static String SELECT_SEQ_DISCENTE = "SELECT DISCENTE_MATRICULA_SEQ.NEXTVAL AS MATRICULA FROM DUAL";
    public static String UPDATE_DISCENTE = "UPDATE DISCENTE SET "
            + "CPF = ?, NOME = ?, NOMEPAI = ?, NOMEMAE = ?, DATANASCIMENTO = ?, "
            + "TELEFONE = ?, CELULAR = ?, EMAIL = ?, ENDERECO = ?, SEXO = ? "
            + "WHERE MATRICULA = ?";
    public static String DELETE_DISCENTE = "DELETE FROM DISCENTE WHERE MATRICULA = ?";
    public static String SELECT_DISCENTE = "SELECT * FROM DISCENTE WHERE MATRICULA = ?";
    public static String SELECT_ALL_DISCENTE = "SELECT * FROM DISCENTE ORDER BY MATRICULA";
    
    //DOCENTE
    public static String INSERT_DOCENTE = "INSERT INTO DOCENTE "
            + "(MATRICULA, CPF, NOME, DATANASCIMENTO, TELEFONE, CELULAR, EMAIL, ENDERECO, SEXO) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static String SELECT_SEQ_DOCENTE = "SELECT DOCENTE_MATRICULA_SEQ.NEXTVAL AS MATRICULA FROM DUAL";
    public static String UPDATE_DOCENTE = "UPDATE DOCENTE SET "
            + "CPF = ?, NOME = ?, DATANASCIMENTO = ?, "
            + "TELEFONE = ?, CELULAR = ?, EMAIL = ?, ENDERECO = ?, SEXO = ?, "
            + "TITULACAO = ?, COD_DISCIPLINA = ? "
            + "WHERE MATRICULA = ?";
    public static String DELETE_DOCENTE = "DELETE FROM DOCENTE WHERE MATRICULA = ?";
    public static String SELECT_DOCENTE = "SELECT * FROM DOCENTE WHERE MATRICULA = ?";
    public static String SELECT_ALL_DOCENTE = "SELECT * FROM DOCENTE ORDER BY MATRICULA";
    
    //DISCIPLINA
    public static String INSERT_DISCIPLINA = "INSERT INTO DISCIPLINA "
            + "(CODIGO, DESCRICAO, ANOLETIVO, CARGAHORARIA) VALUES "
            + "(?, ?, ?, ?)";
    public static String SELECT_SEQ_DISCIPLINA = "SELECT DISCIPLINA_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static String UPDATE_DISCIPLINA = "UPDATE DISCIPLINA SET "
            + "DESCRICAO = ?, ANOLETIVO = ?, CARGAHORARIA = ? "
            + "WHERE CODIGO = ?";
    public static String DELETE_DISCIPLINA = "DELETE FROM DISCIPLINA WHERE CODIGO = ?";
    public static String SELECT_DISCIPLINA = "SELECT * FROM DISCIPLINA WHERE CODIGO = ?";
    public static String SELECT_ALL_DISCIPLINA = "SELECT * FROM DISCIPLINA ORDER BY CODIGO";
}
