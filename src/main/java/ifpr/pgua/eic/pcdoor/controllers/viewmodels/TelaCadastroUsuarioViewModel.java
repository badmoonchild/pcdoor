package ifpr.pgua.eic.pcdoor.controllers.viewmodels;

import ifpr.pgua.eic.pcdoor.model.repositories.UsuarioRepository;
import ifpr.pgua.eic.pcdoor.model.results.Result;
import ifpr.pgua.eic.pcdoor.model.results.SuccessResult;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TelaCadastroUsuarioViewModel {

    private StringProperty nomeProperty = new SimpleStringProperty();
    private StringProperty emailProperty = new SimpleStringProperty();
    private StringProperty senhaProperty = new SimpleStringProperty();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();


    private UsuarioRepository repository;

    public TelaCadastroUsuarioViewModel(UsuarioRepository repository){
        this.repository = repository;
    }

    public StringProperty nomeProperty(){
        return nomeProperty;
    }

    public StringProperty emailProperty(){
        return emailProperty;
    }

    public StringProperty senhaProperty(){
        return senhaProperty;
    }

    public ObjectProperty<Result> alertProperty() {
        return alertProperty;
    }

    public void cadastrar(){

        String nome = nomeProperty.getValue();
        String email = emailProperty.getValue();
        String senha = senhaProperty.getValue();

        Result resultado = repository.cadastrarUsuario(nome, email, senha);

        if(resultado instanceof SuccessResult){
            limpar();
            alertProperty.setValue(Result.success("Usuario cadastrado!"));
        }else{
            alertProperty.setValue(Result.fail("Usuario não cadastrado!"));
        }


    }

    public void limpar(){
        nomeProperty.setValue("");
        emailProperty.setValue("");
        senhaProperty.setValue("");
    }
    
}
