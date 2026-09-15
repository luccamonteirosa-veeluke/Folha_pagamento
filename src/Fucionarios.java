public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    // Único método para consultar todos os dados de uma vez
    public String getDados() {
        return "Nome: " + nome + " | CPF: " + cpf + " | Salário: R$" + salario;
    }

    // Mantido apenas porque as subclasses precisam dele para o cálculo matemático
    public double getSalario() {
        return salario;
    }

    public abstract double calcularBonificacao();

    public double calcularRemuneracaoTotal() {
        return salario + calcularBonificacao();
    }

    public void exibirHolerite() {
        System.out.println("Funcionário: " + nome);
        System.out.println("Cargo: " + getClass().getSimpleName());
        System.out.println("Salário: R$ " + salario);
        System.out.println("Bonificação: R$ " + calcularBonificacao());
        System.out.println("Remuneração total: R$ " + calcularRemuneracaoTotal());
        System.out.println("-----------------------------------");
    }
}
