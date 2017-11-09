package util;

public class Query {
    //DISCENTE
    public static final String INSERT_DISCENTE = "INSERT INTO DISCENTE "
            + "(MATRICULA, CPF, NOME, NOMEPAI, NOMEMAE, DATANASCIMENTO, TELEFONE, CELULAR, EMAIL, ENDERECO, SEXO) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_SEQ_DISCENTE = "SELECT DISCENTE_MATRICULA_SEQ.NEXTVAL AS MATRICULA FROM DUAL";
    public static final String UPDATE_DISCENTE = "UPDATE DISCENTE SET "
            + "CPF = ?, NOME = ?, NOMEPAI = ?, NOMEMAE = ?, DATANASCIMENTO = ?, "
            + "TELEFONE = ?, CELULAR = ?, EMAIL = ?, ENDERECO = ?, SEXO = ? "
            + "WHERE MATRICULA = ?";
    public static final String DELETE_DISCENTE = "DELETE FROM DISCENTE WHERE MATRICULA = ?";
    public static final String SELECT_DISCENTE = "SELECT * FROM DISCENTE WHERE MATRICULA = ?";
    public static final String SELECT_ALL_DISCENTE = "SELECT * FROM DISCENTE ORDER BY MATRICULA";
    
    //DOCENTE
    public static final String INSERT_DOCENTE = "INSERT INTO DOCENTE "
            + "(MATRICULA, CPF, NOME, DATANASCIMENTO, TELEFONE, CELULAR, EMAIL, ENDERECO, SEXO, TITULACAO, COD_DISCIPLINA) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_SEQ_DOCENTE = "SELECT DOCENTE_MATRICULA_SEQ.NEXTVAL AS MATRICULA FROM DUAL";
    public static final String UPDATE_DOCENTE = "UPDATE DOCENTE SET "
            + "CPF = ?, NOME = ?, DATANASCIMENTO = ?, "
            + "TELEFONE = ?, CELULAR = ?, EMAIL = ?, ENDERECO = ?, SEXO = ?, "
            + "TITULACAO = ?, COD_DISCIPLINA = ? "
            + "WHERE MATRICULA = ?";
    public static final String DELETE_DOCENTE = "DELETE FROM DOCENTE WHERE MATRICULA = ?";
    public static final String SELECT_DOCENTE = "SELECT * FROM DOCENTE WHERE MATRICULA = ?";
    public static final String SELECT_ALL_DOCENTE = "SELECT * FROM DOCENTE ORDER BY MATRICULA";
    
    //DISCIPLINA
    public static final String INSERT_DISCIPLINA = "INSERT INTO DISCIPLINA "
            + "(CODIGO, DESCRICAO, ANOLETIVO, CARGAHORARIA) VALUES "
            + "(?, ?, ?, ?)";
    public static final String SELECT_SEQ_DISCIPLINA = "SELECT DISCIPLINA_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_DISCIPLINA = "UPDATE DISCIPLINA SET "
            + "DESCRICAO = ?, ANOLETIVO = ?, CARGAHORARIA = ? "
            + "WHERE CODIGO = ?";
    public static final String DELETE_DISCIPLINA = "DELETE FROM DISCIPLINA WHERE CODIGO = ?";
    public static final String SELECT_DISCIPLINA = "SELECT * FROM DISCIPLINA WHERE CODIGO = ?";
    public static final String SELECT_ALL_DISCIPLINA = "SELECT * FROM DISCIPLINA ORDER BY CODIGO";
    
    //TURMA
    public static final String INSERT_TURMA = "INSERT INTO TURMA "
            + "(CODIGO, ANOLETIVO, LETRA, ANOATUAL, NUMEROVAGAS, STATUS) VALUES "
            + "(?, ?, ?, ?, ?, ?)";
    public static final String SELECT_SEQ_TURMA = "SELECT TURMA_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_TURMA = "UPDATE TURMA SET "
            + "ANOLETIVO = ?, LETRA = ?, ANOATUAL = ?, "
            + "NUMEROVAGAS = ?, STATUS = ? "
            + "WHERE CODIGO = ?";
    public static final String DELETE_TURMA = "DELETE FROM TURMA WHERE CODIGO = ?";
    public static final String SELECT_TURMA = "SELECT * FROM TURMA WHERE CODIGO = ?";
    public static final String SELECT_ALL_TURMA = "SELECT * FROM TURMA ORDER BY CODIGO";
    
    //DISCENTETURMA
    public static final String INSERT_DISCENTETURMA = "INSERT INTO DISCENTETURMA "
            + "(MAT_DISCENTE, COD_TURMA, STATUS) VALUES "
            + "(?, ?, ?)";
    public static final String SELECT_ALL_DISCENTETURMA_BY_TURMA = "SELECT * FROM DISCENTETURMA WHERE COD_TURMA = ?";
    public static final String DELETE_DISCENTETURMA_BY_TURMA = "DELETE FROM DISCENTETURMA WHERE COD_TURMA = ?";
    
    //DOCENTETURMA
    public static final String INSERT_DOCENTETURMA = "INSERT INTO DOCENTETURMA "
            + "(MAT_DOCENTE, COD_TURMA, STATUS) VALUES "
            + "(?, ?, ?)";
    public static final String SELECT_ALL_DOCENTETURMA_BY_TURMA = "SELECT * FROM DOCENTETURMA WHERE COD_TURMA = ?";
    public static final String DELETE_DOCENTETURMA_BY_TURMA = "DELETE FROM DOCENTETURMA WHERE COD_TURMA = ?";
    
    //NOTA
    public static final String INSERT_NOTA = "INSERT INTO NOTA "
            + "(CODIGO, "
            + "BIMESTRE1, BIMESTRE2, BIMESTRE3, BIMESTRE4, RECUPERACAOPARCIAL, RECUPERACAOFINAL, "
            + "COD_TURMA, MAT_DOCENTE, MAT_DISCENTE) VALUES "
            + "(?, "
            + "?, ?, ?, ?, ?, ?, "
            + "?, ?, ?)";
    public static final String SELECT_SEQ_NOTA = "SELECT NOTA_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_NOTA = "UPDATE NOTA SET "
            + "BIMESTRE1 = ?, BIMESTRE2 = ?, BIMESTRE3 = ?, BIMESTRE4 = ?, RECUPERACAOPARCIAL = ?, RECUPERACAOFINAL = ?, "
            + "COD_TURMA = ?, MAT_DOCENTE = ?, MAT_DISCENTE = ? "
            + "WHERE CODIGO = ?";
    public static final String DELETE_NOTA = "DELETE FROM NOTA WHERE CODIGO = ?";
    public static final String SELECT_ALL_NOTA_BY_TURMA = "SELECT * FROM NOTA ORDER BY CODIGO WHERE COD_TURMA = ?";
    public static final String SELECT_ALL_NOTA_BY_DOCENTE = "SELECT * FROM NOTA ORDER BY CODIGO WHERE COD_DOCENTE = ?";
}
