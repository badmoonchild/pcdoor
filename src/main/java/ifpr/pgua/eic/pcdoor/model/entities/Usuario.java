package ifpr.pgua.eic.pcdoor.model.entities;

public class Usuario {
    
    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;

    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario(String nomeUsuario, String emailUsuario, String senhaUsuario){
        this(-1, nomeUsuario, emailUsuario, senhaUsuario);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }


    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }


    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenha(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

}
