import static java.lang.IO.*;
void main() {
        println("===SISTEMA DE CADASTRO DE FUNCIONÁRIOS===");

        println("===Cadastro: Gerente===");
        String nomeGerente = lerTextoValido("Digite o nome do gerente: ");
        String cpfGerente = lerTextoValido("Digite o CPF do gerente: ");
        double salarioGerente = lerDoubleValido("Digite o salário do gerente (R$): ");

// 2. Leitura dos dados do Desenvolvedor
        println("===Cadastro: Desenvolvedor===");
        String nomeDev = lerTextoValido("Digite o nome do desenvolvedor: ");
        String cpfDev = lerTextoValido("Digite o CPF do desenvolvedor: ");
        double salarioDev = lerDoubleValido("Digite o salário do desenvolvedor (R$): ");

// 3. Leitura dos dados do Vendedor
        println("===Cadastro: Vendedor===");
        String nomeVendedor = lerTextoValido("Digite o nome do vendedor: ");
        String cpfVendedor = lerTextoValido("Digite o CPF do vendedor: ");
        double salarioVendedor = lerDoubleValido("Digite o salário do vendedor (R$): ");
        double totalVendido = lerDoubleValido("Digite o total de vendas (R$): ");

// Instancia com captura de possíveis exceções de regra de negócio
        try {
            Funcionarios gerente = new Gerentes(nomeGerente, cpfGerente, salarioGerente);
            Funcionarios dev = new Desenvolvedor(nomeDev, cpfDev, salarioDev);
            Funcionarios vendedor = new Vendedor(nomeVendedor, cpfVendedor, salarioVendedor, totalVendido);

// Exibição de todos os holerites
            println("===HOLERITE GERENTE ===");
            gerente.exibirHolerite();
            println("===HOLERITE DEV ===");
            dev.exibirHolerite();
            println("===HOLERITE VENDEDOR===");
            vendedor.exibirHolerite();

        } catch (IllegalArgumentException e) {
            println("\n[ERRO DE VALIDAÇÃO]: " + e.getMessage());
        }
    }

// --- Métodos Auxiliares para Validação de Entrada de Usuário (UX/Main) ---

    private String lerTextoValido(String mensagem) {
        while (true) {
            String entrada = readln(mensagem);
            if (entrada != null && !entrada.isBlank()) {
                return entrada.trim();
            }
            println(" -> Entrada inválida! O campo não pode ficar em branco.");
        }
    }

    private double lerDoubleValido(String mensagem) {
        while (true) {
            try {
                String entrada = readln(mensagem);
// Substitui vírgula por ponto para suportar ambos os formatos
                double valor = Double.parseDouble(entrada.replace(",", "."));

                if (valor <= 0) {
                    println(" -> Entrada inválida! O valor deve ser maior que zero.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                println(" -> Formato inválido! Digite apenas números válidos (Ex: 3500.50).");
            }
        }
    }
