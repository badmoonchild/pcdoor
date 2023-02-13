package ifpr.pgua.eic.pcdoor.controllers;

import ifpr.pgua.eic.pcdoor.model.entities.Estabelecimento;
import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import ifpr.pgua.eic.pcdoor.model.repositories.EstabelecimentoRepository;
import ifpr.pgua.eic.pcdoor.model.repositories.UsuarioRepository;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TelaPrincipal extends BaseController {

    private UsuarioRepository repositorioUsuario;
    private EstabelecimentoRepository repositorioEstabelecimento;

    private Usuario usuarioLogin;
    private Estabelecimento estabelecimentoLogin;
    
    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    public TelaPrincipal(UsuarioRepository repositorioUsuario, EstabelecimentoRepository repositorioEstabelecimento){
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioEstabelecimento = repositorioEstabelecimento;
    }

    public void entrar(){

        Alert a = new Alert(Alert.AlertType.NONE);

        String email = tfEmail.getText();
        String senha = tfSenha.getText();

        usuarioLogin = repositorioUsuario.login(email, senha);

        estabelecimentoLogin = repositorioEstabelecimento.login(email, senha);

        if(usuarioLogin != null){
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText("Usuario logado!");
            a.showAndWait();
        }
        else if(estabelecimentoLogin != null){
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText("Estabelecimento logado!");
            a.showAndWait();
        }
        else{
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText("Email ou senha incorretos!");
            a.showAndWait();
        }

    }
    
    @FXML
    private void carregarTelaCadastros(){
        BaseAppNavigator.pushScreen("CADASTROS");
    }


}
