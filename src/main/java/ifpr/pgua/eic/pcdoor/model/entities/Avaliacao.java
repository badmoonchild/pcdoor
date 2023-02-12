package ifpr.pgua.eic.pcdoor.model.entities;

import java.sql.Date;

public class Avaliacao {

    private int idAvaliacao;
    private Date dataRegistro; 
    private int nota; 
    private String comentario; 
    private int  idEstabelecimento; 
    private int idUsuario;

    public Avaliacao (int idAvaliacao, Date dataRegistro, int nota, String comentario, int idEstabelecimento, int idUsuario) {
        this.idAvaliacao = idAvaliacao;
        this.dataRegistro = dataRegistro; 
        this.nota = nota; 
        this.comentario = comentario; 
        this.idEstabelecimento = idEstabelecimento; 
        this.idUsuario = idUsuario; 

    }

    public Avaliacao (Date dataRegistro, int nota, String comentario, int idEstabelecimento, int idUsuario) {
        this(-1, dataRegistro, nota, comentario, idEstabelecimento, idUsuario);
    }


    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
