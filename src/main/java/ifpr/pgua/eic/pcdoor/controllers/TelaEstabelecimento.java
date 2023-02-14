package ifpr.pgua.eic.pcdoor.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ifpr.pgua.eic.pcdoor.model.entities.Estabelecimento;
import ifpr.pgua.eic.pcdoor.model.repositories.EstabelecimentoRepository;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class TelaEstabelecimento implements Initializable{

    @FXML
    private ListView<Estabelecimento> lvEstabelecimentos;

    @FXML
    private TextArea taDetalhes;
    
    private EstabelecimentoRepository repository;

    public TelaEstabelecimento(EstabelecimentoRepository repository){
        this.repository = repository;
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lvEstabelecimentos.getItems().clear();
        listarEstabelecimentos();
    }

    private void listarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = repository.listarEstabelecimentos();
        
        for(Estabelecimento estabelecimento : estabelecimentos){
            lvEstabelecimentos.getItems().add(estabelecimento);
        }
    }

    @FXML
    private void mostrarDetalhes(){
        Estabelecimento estabelecimento = lvEstabelecimentos.getSelectionModel().getSelectedItem();

        if(estabelecimento != null){
            taDetalhes.clear();
            taDetalhes.appendText("Nome: "+estabelecimento.getNomeEstabelecimento()+"\n");
            taDetalhes.appendText("Tipo: "+estabelecimento.getTipoEstabelecimento()+"\n");
            taDetalhes.appendText("Endereco: "+estabelecimento.getEndereco()+"\n");
            taDetalhes.appendText("Descricao: "+estabelecimento.getDescricaoAcessibilidade()+"\n");
            taDetalhes.appendText("Nota: "+estabelecimento.getPontuacao()+"\n");
        }
    }

    public void sair() {
        BaseAppNavigator.popScreen();
    }
    
}
