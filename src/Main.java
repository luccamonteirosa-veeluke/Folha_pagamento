import static java.lang.IO.*;

void main() {
    // 1. Leitura inicial dos dados dos funcionários
    println("=== CADASTRO GERENTE ===");
    String nome_gerente = readln("insira o nome do gerente: ");
    String cpf_gerente = readln("insira o CPF do gerente: ");
    double salario_gerente = Double.parseDouble(readln("insira o salario do gerente: "));

    println("\n=== CADASTRO DESENVOLVEDOR ===");
    String nome_dev = readln("insira o nome do desenvolvedor: ");
    String cpf_dev = readln("insira o CPF do desenvolvedor: ");
    double salario_dev = Double.parseDouble(readln("insira o salario do desenvolvedor: "));

    println("\n=== CADASTRO VENDEDOR ===");
    String nome_vend = readln("insira o nome do vendedor: ");
    String cpf_vend = readln("insira o CPF do vendedor: ");
    double salario_vend = Double.parseDouble(readln("insira o salario do vendedor: "));
    double vendas_vend = Double.parseDouble(readln("insira o total vendido pelo vendedor: "));

    // Validação na main para impedir dados inválidos conforme as regras
    if (nome_gerente.isEmpty() || cpf_gerente.isEmpty() || salario_gerente <= 0 ||
            nome_dev.isEmpty() || cpf_dev.isEmpty() || salario_dev <= 0 ||
            nome_vend.isEmpty() || cpf_vend.isEmpty() || salario_vend <= 0 || vendas_vend < 0) {

        println("\n[ERRO] Dados invalidos! O nome e CPF nao podem ser vazios, e o salario deve ser maior que zero.");
        return;
    }

    // Instanciação das classes
    Gerentes ge = new Gerentes(nome_gerente, cpf_gerente, salario_gerente);
    Desenvolvedor de = new Desenvolvedor(nome_dev, cpf_dev, salario_dev);
    Vendedor ve = new Vendedor(nome_vend, cpf_vend, salario_vend, vendas_vend);

    boolean ex = true;

    // 2. Menu Principal Interativo
    while (ex) {
        String op = readln("\n1-gerente , 2-desenvolvedor , 3-vendedor , 4-total da folha , 5-sair");

        if (op.equals("1")) {
            boolean on = true;
            while (on) {
                String om = readln("1-consultar dados . 2-exibir holerite . 3-sair");
                switch (om) {
                    case "1" -> println(ge.getDados());
                    case "2" -> ge.exibirHolerite();
                    case "3" -> on = false;
                }
            }
        } else if (op.equals("2")) {
            boolean on = true;
            while (on) {
                String om = readln("1-consultar dados . 2-exibir holerite . 3-sair");
                switch (om) {
                    case "1" -> println(de.getDados());
                    case "2" -> de.exibirHolerite();
                    case "3" -> on = false;
                }
            }
        } else if (op.equals("3")) {
            boolean on = true;
            while (on) {
                String om = readln("1-consultar dados . 2-exibir holerite . 3-sair");
                switch (om) {
                    case "1" -> println(ve.getDados());
                    case "2" -> ve.exibirHolerite();
                    case "3" -> on = false;
                }
            }
        } else if (op.equals("4")) {
            double totalFolha = ge.calcularRemuneracaoTotal() + de.calcularRemuneracaoTotal() + ve.calcularRemuneracaoTotal();
            println("Total da folha de pagamento da empresa: R$ " + totalFolha);
        } else if (op.equals("5")) {
            ex = false;
        }
    }
}