public class Desenvolvedor extends Funcionarios {
    public Desenvolvedor(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.10;
    }
}