package ifpr.pgua.eic.pcdoor.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.pcdoor.controllers.viewmodels.TelaCadastroUsuarioViewModel;
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

    private TelaCadastroUsuarioViewModel viewModel;

    public TelaCadastroUsuario(TelaCadastroUsuarioViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        tfNome.textProperty().bindBidirectional(viewModel.nomeProperty());
        tfEmail.textProperty().bindBidirectional(viewModel.emailProperty());
        tfSenha.textProperty().bindBidirectional(viewModel.senhaProperty());
    }

    public void cadastrar(){
        viewModel.cadastrar();
    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
