package ifpr.pgua.eic.pcdoor.controllers;

import ifpr.pgua.eic.pcdoor.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;

public class TelaCadastros{
    
    @FXML
    private void carregarCadastroUsuario(){
        BaseAppNavigator.pushScreen("CADASTROUSUARIO");
    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }

}
