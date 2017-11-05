package util;

public class Query {
    //DISCENTE
    public static String INSERT_DISCENTE = "INSERT INTO DISCENTE "
            + "(MATRICULA, CPF, NOME, NOMEPAI, NOMEMAE, DATANASCIMENTO, TELEFONE, CELULAR, EMAIL, ENDERECO, SEXO) VALUES "
            + "(?,?,?,?,?,?,?,?,?,?,?)";
    public static String SELECT_SEQ_DISCENTE = "SELECT DISCENTE_MATRICULA_SEQ.NEXTVAL AS MATRICULA FROM DUAL";
    public static String UPDATE_DISCENTE = "UPDATE DISCENTE SET "
            + "CPF = ?, NOME = ?, NOMEPAI = ?, NOMEMAE = ?, DATANASCIMENTO = ?, "
            + "TELEFONE = ?, CELULAR = ?, EMAIL = ?, ENDERECO = ?, SEXO = ? "
            + "WHERE MATRICULA = ?";
    public static String DELETE_DISCENTE = "DELETE FROM DISCENTE WHERE MATRICULA = ?";
    public static String SELECT_DISCENTE = "SELECT * FROM DISCENTE WHERE MATRICULA = ?";
    public static String SELECT_ALL_DISCENTE = "SELECT * FROM DISCENTE ORDER BY MATRICULA";
}
