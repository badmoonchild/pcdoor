package ifpr.pgua.eic.pcdoor.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ifpr.pgua.eic.pcdoor.model.FabricaConexoes;
import ifpr.pgua.eic.pcdoor.model.entities.Avaliacao;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public class JDBCAvaliacaoDAO implements AvaliacaoDAO{

    private FabricaConexoes fabricaConexoes;

    public JDBCAvaliacaoDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrar(Avaliacao avaliacao) {
        
        try{
            Connection con = fabricaConexoes.getConnection();
            
            PreparedStatement pstm = con.prepareStatement("INSERT INTO pcdoor_Avaliacao(nota,idUsuario,idEstabelecimento) VALUES (?,?,?)");

            pstm.setInt(1, avaliacao.getNota());
            pstm.setInt(2, avaliacao.getIdUsuario());
            pstm.setInt(3, avaliacao.getIdEstabelecimento());

            pstm.execute();

            pstm.close();
            con.close();
            return Result.success("Avaliacao recebida!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
    
}
