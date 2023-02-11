package ifpr.pgua.eic.pcdoor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.pcdoor.controllers.TelaCadastroEstabelecimento;
import ifpr.pgua.eic.pcdoor.controllers.TelaCadastroUsuario;
import ifpr.pgua.eic.pcdoor.controllers.TelaCadastros;
import ifpr.pgua.eic.pcdoor.controllers.TelaPrincipal;
import ifpr.pgua.eic.pcdoor.model.FabricaConexoes;
import ifpr.pgua.eic.pcdoor.model.daos.EstabelecimentoDAO;
import ifpr.pgua.eic.pcdoor.model.daos.JDBCEstabelecimentoDAO;
import ifpr.pgua.eic.pcdoor.model.daos.JDBCUsuarioDAO;
import ifpr.pgua.eic.pcdoor.model.daos.UsuarioDAO;
import ifpr.pgua.eic.pcdoor.model.repositories.EstabelecimentoRepository;
import ifpr.pgua.eic.pcdoor.model.repositories.UsuarioRepository;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.pcdoor.utils.Navigator.ScreenRegistryFXML;


/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private UsuarioDAO usuarioDAO;
    private UsuarioRepository usuarioRepository;
    private EstabelecimentoDAO estabelecimentoDAO;
    private EstabelecimentoRepository estabelecimentoRepository;


    @Override
    public void init() throws Exception {

        super.init();
        
        usuarioDAO = new JDBCUsuarioDAO(FabricaConexoes.getInstance());
        usuarioRepository = new UsuarioRepository(usuarioDAO);
        estabelecimentoDAO = new JDBCEstabelecimentoDAO(FabricaConexoes.getInstance());
        estabelecimentoRepository = new EstabelecimentoRepository(estabelecimentoDAO);
    
    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }



    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "PCDoor";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(getClass(), "fxml/principal.fxml", (o)->new TelaPrincipal()));
        registraTela("CADASTROS", new ScreenRegistryFXML(getClass(), "fxml/cadastros.fxml", (o)->new TelaCadastros()));
        registraTela("CADASTROUSUARIO", new ScreenRegistryFXML(getClass(), "fxml/cadastroUsuario.fxml", (o)->new TelaCadastroUsuario(usuarioRepository)));
        registraTela("CADASTROESTABELECIMENTO", new ScreenRegistryFXML(getClass(), "fxml/cadastroEstabelecimento.fxml", (o)->new TelaCadastroEstabelecimento(estabelecimentoRepository)));

        //REGISTRAR AS OUTRAS TELAS

    }


}