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

        if(nome == null || nome.isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira o nome do seu estabelecimento!");
            alert.showAndWait();
        }
        else if(email == null || !email.contains(".com")  || !email.contains("@") || email.isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira um email valido!");
            alert.showAndWait();
        }
        else if(senha == null || senha.isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira sua senha!");
            alert.showAndWait();
        }
        else if(tipo == null || tipo.isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira qual o tipo do seu estabelecimento!");
            alert.showAndWait();
        }
        else if(cnpj == null || cnpj.isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira o cnpj!");
            alert.showAndWait();
        }
        else if(descricao == null || descricao.isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira a descrição da acessibilidade do seu estabelecimento!");
            alert.showAndWait();
        }
        else if(endereco == null || endereco.isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Insira o endereco do seu estabelecimento!");
            alert.showAndWait();
        }
        else{

            if(repository.buscarEmail(email) != null){
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Email ja cadastrado!");
                alert.showAndWait();
            }
            else if(repository.buscarCnpj(cnpj) != null){
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Cnpj ja cadastrado!");
                alert.showAndWait();
            }
            else{
                repository.cadastrarEstabelecimento(nome, email, senha, tipo, cnpj, descricao, pontuacao, endereco);

                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Cadastro concluido!");
                alert.showAndWait();
            }
            
        }

    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
