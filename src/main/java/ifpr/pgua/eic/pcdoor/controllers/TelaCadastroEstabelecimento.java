package ifpr.pgua.eic.pcdoor.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.pcdoor.model.repositories.EstabelecimentoRepository;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TelaCadastroEstabelecimento {
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfTipo;

    @FXML
    private TextField tfCnpj;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfEndereco;

    private EstabelecimentoRepository repository;

    public TelaCadastroEstabelecimento(EstabelecimentoRepository repository){
        this.repository = repository;
    }

    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void cadastrar(){

        Alert alert = new Alert(Alert.AlertType.NONE);

        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();
        String tipo = tfTipo.getText();
        String cnpj = tfCnpj.getText();
        String descricao = tfDescricao.getText();
        int pontuacao = 0;
        String endereco = tfEndereco.getText();

        if(nome == null || email == null || senha == null || tipo == null || cnpj == null || descricao == null || endereco == null){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ta em branco");
            alert.showAndWait();
        }
        else{
            repository.cadastrarEstabelecimento(nome, email, senha, tipo, cnpj, descricao, pontuacao, endereco);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cadastro concluido!");
            alert.showAndWait();
        }

    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
