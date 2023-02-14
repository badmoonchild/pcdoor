package ifpr.pgua.eic.pcdoor.model.entities;

public class Validacao {

    private static Validacao instance;

    private Usuario usuario;

    public static Validacao getInstance() {
        if (instance == null) {
            instance = new Validacao();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}