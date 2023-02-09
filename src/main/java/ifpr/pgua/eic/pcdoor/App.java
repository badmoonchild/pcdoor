package ifpr.pgua.eic.pcdoor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.pcdoor.controllers.TelaCadastroUsuario;
import ifpr.pgua.eic.pcdoor.controllers.TelaCadastros;
import ifpr.pgua.eic.pcdoor.controllers.TelaPrincipal;
import ifpr.pgua.eic.pcdoor.controllers.viewmodels.TelaCadastroUsuarioViewModel;
import ifpr.pgua.eic.pcdoor.model.FabricaConexoes;
import ifpr.pgua.eic.pcdoor.model.daos.JDBCUsuarioDAO;
import ifpr.pgua.eic.pcdoor.model.daos.UsuarioDAO;
import ifpr.pgua.eic.pcdoor.model.repositories.UsuarioRepository;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.pcdoor.utils.Navigator.ScreenRegistryFXML;


/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private UsuarioDAO usuarioDAO;
    private UsuarioRepository usuarioRepository;


    @Override
    public void init() throws Exception {

        super.init();
        
        usuarioDAO = new JDBCUsuarioDAO(FabricaConexoes.getInstance());
        usuarioRepository = new UsuarioRepository(usuarioDAO);
    
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
        registraTela("CADASTROUSUARIO", new ScreenRegistryFXML(getClass(), "fxml/cadastroUsuario.fxml", (o)->new TelaCadastroUsuario(new TelaCadastroUsuarioViewModel(usuarioRepository))));
        
        //REGISTRAR AS OUTRAS TELAS

    }


}