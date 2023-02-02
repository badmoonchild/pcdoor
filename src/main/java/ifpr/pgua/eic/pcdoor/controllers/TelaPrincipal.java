package ifpr.pgua.eic.pcdoor.controllers;

import ifpr.pgua.eic.pcdoor.App;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.pcdoor.utils.Navigator.BorderPaneRegion;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {
    

    @FXML
    private void carregarCadastroUsuario(){
        BaseAppNavigator.pushScreen("CADASTROUSUARIO");
    }


}
