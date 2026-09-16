abstract class Funcionarios {
    protected String nome;
    protected String cpf;
    protected double salario;

    public Funcionarios(String nome, String cpf, double salario) {
        if (nome == null || nome.isBlank()) {
            try {
                throw new IllegalAccessException("nome invalido");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (cpf == null || cpf.isBlank()) {
            try {
                throw new IllegalAccessException("cpf invalido");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (salario <= 0) {
            try {
                throw new IllegalAccessException("salario invalido");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        this.nome = nome.trim();
        this.cpf = cpf.trim();
        this.salario = salario;
    }

    public String getDados() {
        return "Nome: " + nome + " | CPF: " + cpf + " | Salário: R$ " + salario;
    }

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