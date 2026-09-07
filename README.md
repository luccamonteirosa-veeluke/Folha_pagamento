# Sistema de Folha de Pagamento e Gestão de Funcionários

Este projeto é um sistema interativo em Java via linha de comando para gerenciar os dados e a folha de pagamento de uma empresa. O sistema aplica conceitos centrais de Programação Orientada a Objetos (POO), como Herança, Classes Abstratas e Polimorfismo, para calcular dinamicamente remunerações e bonificações com base nos diferentes cargos da organização.

---

## Diferenças entre os três tipos de funcionários

A arquitetura do projeto é baseada em uma classe abstrata `Funcionario`, que define a estrutura base (Nome, CPF e Salário base) para os três cargos disponíveis no sistema:

1. **Desenvolvedor:** Funcionário do setor técnico. Possui regras padronizadas de bonificação salarial com base no seu salário fixo.
2. **Gerente:** Ocupante de cargo de liderança. Ocupa a mesma estrutura de dados do Desenvolvedor, porém possui um percentual de bonificação financeira maior devido às suas responsabilidades.
3. **Vendedor:** Funcionário do setor comercial. Além dos atributos normais, o vendedor possui um atributo exclusivo de `totalVendido`. Sua classe sobrescreve o método `getDados()` original para exibir também o valor das vendas, e sua bonificação possui uma regra mista (fixa + comissão).

---

## Regras de Bonificação e Remuneração

A remuneração total de um funcionário é calculada pela soma de seu salário base com sua bonificação. O método abstrato `calcularBonificacao()` garante que cada cargo implemente sua própria regra:

* **Gerente:** Recebe **20%** de bonificação sobre o salário base.
* **Desenvolvedor:** Recebe **10%** de bonificação sobre o salário base.
* **Vendedor:** Recebe **5%** de bonificação sobre o salário base **+ 2% de comissão** sobre o total de vendas realizadas.

---

## Validação de Dados na Entrada

A classe principal (`Main_2`) atua como uma barreira de segurança para garantir a integridade dos dados cadastrais antes de instanciar os objetos. O sistema rejeita o cadastro e encerra a execução exibindo uma mensagem de `[ERRO]` caso:
- O Nome ou CPF estejam em branco.
- O Salário base seja menor ou igual a zero.
- O Total de vendas do vendedor seja um valor negativo.

---

## O método exibirHolerite() e o encapsulamento

A classe `Funcionario` possui um método robusto chamado `exibirHolerite()`. 
Ele funciona de maneira inteligente: ao ser chamado por qualquer subclasse, ele utiliza reflexão (`getClass().getSimpleName()`) para descobrir qual é o cargo do funcionário em tempo de execução e aciona o método `calcularBonificacao()` polimórfico. 

Isso evita a repetição de código (DRY - *Don't Repeat Yourself*), pois o holerite (recibo de pagamento) é formatado em um só lugar (na classe mãe), mas os valores matemáticos impressos são ditados de forma independente por cada classe filha. Além disso, o encapsulamento foi mantido ao criar um método central `getDados()` para consulta rápida e limitar o acesso ao salário através do `getSalario()`, garantindo que subclasses apenas leiam o dado para cálculos, sem poder alterá-lo.

---

## Instruções para execução

Este projeto foi desenvolvido utilizando funcionalidades recentes da linguagem Java (como os métodos *main* implícitos e o pacote `java.lang.IO`). 

**Pré-requisito:** É necessário ter o **JDK 21** (ou superior) configurado no seu sistema.

1. Abra o terminal e navegue até a pasta onde os arquivos `.java` estão salvos.
2. Compile as classes executando o comando:
   ```bash
   javac --release 21 --enable-preview *.java
