class VeiculoPJ extends Veículo {
    private int quantidadeFuncionarios;

    public VeiculoPJ(String placa, String marca, String modelo, int ano, int quantidadeFuncionarios) {
        super(placa,marca, modelo, ano);
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
}