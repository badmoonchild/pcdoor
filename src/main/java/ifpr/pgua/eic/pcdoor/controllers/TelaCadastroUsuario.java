package ifpr.pgua.eic.pcdoor.controllers;

import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaCadastroUsuario {
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;


    public void cadastrar(){


    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
