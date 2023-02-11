package ifpr.pgua.eic.pcdoor.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ifpr.pgua.eic.pcdoor.model.FabricaConexoes;
import ifpr.pgua.eic.pcdoor.model.entities.Estabelecimento;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public class JDBCEstabelecimentoDAO implements EstabelecimentoDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCEstabelecimentoDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrar(Estabelecimento estabelecimento) {

        try{
            Connection con = fabricaConexoes.getConnection();
            
            PreparedStatement pstm = con.prepareStatement("INSERT INTO pcdoor_Estabelecimento(nomeEstabelecimento,emailEstabelecimento,senhaEstabelecimento,tipoEstabelecimento,cnpj,descricaoAcessibilidade,pontuacao,endereco) VALUES (?,?,?,?,?,?,?,?)");

            pstm.setString(1, estabelecimento.getNomeEstabelecimento());
            pstm.setString(2, estabelecimento.getEmailEstabelecimento());
            pstm.setString(3, estabelecimento.getSenhaEstabelecimento());
            pstm.setString(4, estabelecimento.getTipoEstabelecimento());
            pstm.setString(5, estabelecimento.getCnpj());
            pstm.setString(6, estabelecimento.getDescricaoAcessibilidade());
            pstm.setInt(7, estabelecimento.getPontuacao());
            pstm.setString(8, estabelecimento.getEndereco());

            pstm.execute();

            pstm.close();
            con.close();
            return Result.success("Estabelecimento cadastrado com sucesso!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
    
}
