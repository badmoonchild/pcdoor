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
import ifpr.pgua.eic.pcdoor.model.FabricaConexoes;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.pcdoor.utils.Navigator.ScreenRegistryFXML;


/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {


    //DEFINIR A FABRICA DE CONEXÕES, DAOS e REPOSITÓRIOS

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();
        
        //INSTANCIAR FABRICA, DAOS E REPOSITÓRIOS
    
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
        registraTela("CADASTROUSUARIO", new ScreenRegistryFXML(getClass(), "fxml/cadastroUsuario.fxml", (o)->new TelaCadastroUsuario()));
        
        //REGISTRAR AS OUTRAS TELAS

    }


}