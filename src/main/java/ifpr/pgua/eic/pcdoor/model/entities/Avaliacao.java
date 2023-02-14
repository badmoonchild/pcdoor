package ifpr.pgua.eic.pcdoor.model.entities;

import java.sql.Date;

public class Avaliacao {

    private int idAvaliacao;
    private int nota; 
    private int idEstabelecimento; 
    private int idUsuario;

    public Avaliacao (int idAvaliacao, int nota, int idEstabelecimento, int idUsuario) {
        this.idAvaliacao = idAvaliacao;
        this.nota = nota; 
        this.idEstabelecimento = idEstabelecimento; 
        this.idUsuario = idUsuario; 
    }

    public Avaliacao (int nota, int idEstabelecimento, int idUsuario) {
        this(-1, nota, idEstabelecimento, idUsuario);
    }


    public int getIdAvaliacao() {
        return idAvaliacao;
    }
    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }


    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }


    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }
    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }


    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
