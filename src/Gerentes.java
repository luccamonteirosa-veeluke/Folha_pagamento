public class Gerentes extends Funcionarios {
    public Gerentes(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
        }

        @Override
        public double calcularBonificacao() {
            return getSalario() * 0.20;
        }
    }