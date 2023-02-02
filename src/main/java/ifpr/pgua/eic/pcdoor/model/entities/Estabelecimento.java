package ifpr.pgua.eic.pcdoor.model.entities;

public class Estabelecimento {

    private String cnpj;
    private String nomeEstabelecimento;
    private String tipoEstabelecimento;
    private String enderecoEstabelecimento;
    private int pontuacaoMedia;


    public Estabelecimento(String cnpj, String nomeEstabelecimento, String tipoEstabelecimento, String enderecoEstabelecimento, int pontuacaoMedia) {
        this.cnpj = cnpj;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.tipoEstabelecimento = tipoEstabelecimento;
        this.enderecoEstabelecimento = enderecoEstabelecimento;
        this.pontuacaoMedia = pontuacaoMedia;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }


    public String getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }

    public void setTipoEstabelecimento(String tipoEstabelecimento) {
        this.tipoEstabelecimento = tipoEstabelecimento;
    }



    public String getEnderecoEstabelecimento() {
        return enderecoEstabelecimento;
    }

    public void setEnderecoEstabelecimento(String enderecoEstabelecimento) {
        this.enderecoEstabelecimento = enderecoEstabelecimento;
    }
    
    
    public int getPontuacaoMedia() {
        return pontuacaoMedia;
    }

    public void setPontuacaoMedia(int pontuacaoMedia) {
        this.pontuacaoMedia = pontuacaoMedia;
    }

}
