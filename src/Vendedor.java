public class Vendedor extends Funcionario {
    private double totalVendido;

    public Vendedor(String nome, String cpf, double salario, double totalVendido) {
        super(nome, cpf, salario);
        this.totalVendido = totalVendido;
    }

    @Override
    public String getDados() {
        return super.getDados() + " | Vendas: R$" + totalVendido;
    }

    public double calcularComissao() {
        return this.totalVendido * 0.02;
    }

    @Override
    public double calcularBonificacao() {
        return (getSalario() * 0.05) + calcularComissao();
    }
}