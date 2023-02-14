package ifpr.pgua.eic.pcdoor.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ifpr.pgua.eic.pcdoor.model.entities.Estabelecimento;
import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import ifpr.pgua.eic.pcdoor.model.entities.Validacao;
import ifpr.pgua.eic.pcdoor.model.repositories.AvaliacaoRepository;
import ifpr.pgua.eic.pcdoor.model.repositories.EstabelecimentoRepository;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class TelaEstabelecimento implements Initializable{

    @FXML
    private ListView<Estabelecimento> lvEstabelecimentos;

    @FXML
    private TextArea taDetalhes;

    @FXML
    private ComboBox<Integer> cbNota = new ComboBox<>();

    private ArrayList<Integer> notas = new ArrayList<>();
    
    private EstabelecimentoRepository estabelecimentoRepository;

    private AvaliacaoRepository avaliacaoRepository;

    public TelaEstabelecimento(EstabelecimentoRepository estabelecimentoRepository, AvaliacaoRepository avaliacaoRepository){
        this.estabelecimentoRepository = estabelecimentoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lvEstabelecimentos.getItems().clear();
        listarEstabelecimentos();
        cbNota.getItems().removeAll();

        for(int i = 0;i < 5;i++){
            notas.add(i, i+1);
        }

        cbNota.getItems().addAll(notas);

    }

    private void listarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.listarEstabelecimentos();
        
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

    @FXML
    private void avaliar(){

        Alert alert = new Alert(Alert.AlertType.NONE);

        Estabelecimento estabelecimento = lvEstabelecimentos.getSelectionModel().getSelectedItem();

        int nota = cbNota.getSelectionModel().getSelectedItem();

        int idUsuario = Validacao.getInstance().getUsuario().getIdUsuario();

        int idEstabelecimento = estabelecimento.getIdEstabelecimento();

        if(avaliacaoRepository.cadastrar(nota, idEstabelecimento, idUsuario) != null){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Avaliacao enviada!");
            alert.showAndWait();
        }

        
    }

    public void sair() {
        BaseAppNavigator.popScreen();
    }
    
}
