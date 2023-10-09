package model;

public class Endereco {

    private  String cep;
    private  String logradouro;
    private  String complemento;
    private  String bairro;
    private  String localidade;
    private  String uf;
    private  String ddd;

    public Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ddd){
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ddd = ddd;
    }

    public Endereco(EnderecoApi enderecoPesquisado) {
        this.cep = enderecoPesquisado.cep();
        this.logradouro = enderecoPesquisado.logradouro();
        this.complemento = enderecoPesquisado.complemento();
        this.bairro = enderecoPesquisado.bairro();
        this.localidade = enderecoPesquisado.localidade();
        this.uf = enderecoPesquisado.uf();
        this.ddd = enderecoPesquisado.ddd();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "(cep = " + cep +
                ", logradouro = " + logradouro + "," +
                "complemento = " + complemento + ")";
    }



}
