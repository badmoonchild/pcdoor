package ifpr.pgua.eic.pcdoor.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.pcdoor.model.repositories.UsuarioRepository;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TelaCadastroUsuario {
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    private UsuarioRepository repository;

    public TelaCadastroUsuario(UsuarioRepository repository){
        this.repository = repository;
    }


    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

    public void cadastrar(){

        Alert alert = new Alert(Alert.AlertType.NONE);

        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();

        if(nome == null){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira seu nome!");
            alert.showAndWait();
        }
        else if(email == null || !email.contains("@")){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira um email valido!");
            alert.showAndWait();
        }
        else if(senha == null){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira sua senha!");
            alert.showAndWait();
        }
        else{

            if(repository.buscarEmail(email) == null){

                repository.cadastrarUsuario(nome, email, senha);

                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Cadastro concluido!");
                alert.showAndWait();
            }
            else{
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Email ja cadastrado!");
                alert.showAndWait();
            }

            
        }

    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
