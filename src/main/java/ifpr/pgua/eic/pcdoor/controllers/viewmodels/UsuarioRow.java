package ifpr.pgua.eic.pcdoor.controllers.viewmodels;

import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsuarioRow {

    private Usuario usuario;

    public UsuarioRow(Usuario usuario){
        this.usuario = usuario;
    }

    public StringProperty idUsuarioProperty(){
        return new SimpleStringProperty(String.valueOf(usuario.getIdUsuario()));
    }

    public StringProperty nomeUsuarioProperty(){
        return new SimpleStringProperty(String.valueOf(usuario.getNomeUsuario()));
    }

    public StringProperty emailUsuarioProperty(){
        return new SimpleStringProperty(String.valueOf(usuario.getEmailUsuario()));
    }

    public StringProperty senhaUsuarioProperty(){
        return new SimpleStringProperty(String.valueOf(usuario.getSenhaUsuario()));
    }
    
}
