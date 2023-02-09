package ifpr.pgua.eic.pcdoor.controllers;

import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {
    

    @FXML
    private void carregarTelaCadastros(){
        BaseAppNavigator.pushScreen("CADASTROS");
    }


}
