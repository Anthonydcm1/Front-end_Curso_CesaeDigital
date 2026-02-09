## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).



1. Estrutura do Programa
O programa está organizado em pacotes, o que ajuda imenso na manutenção:

CesaeDigital.java: É o "cérebro" do sistema. Ele contém as listas centrais (ArrayList) de tudo o que existe (professores, alunos, cursos) e gere os menus que viste ao correr o programa.

Pacote pessoa: Aqui temos a Herança. Existe uma classe base abstrata Pessoa que contém o que é comum a todos (nome, email, etc.), e as classes Aluno e Professor herdam dela, acrescentando coisas específicas (como notas para alunos ou salário para professores).

Pacote curso e turma: Estão ligados à estrutura académica, definindo o que se ensina (Curso e UnidadeCurricular) e a quem se ensina (Turma).

2. O que o programa faz (Lógica principal)
O sistema permite um ciclo completo de gestão:

Criação: Podes criar cursos, turmas e registar pessoas.
Associação: Podes colocar alunos em turmas e atribuir professores a disciplinas (UCs).
Processamento: Podes atribuir notas aos alunos e o sistema calcula médias automaticamente.
Relatórios: No menu 6, o programa percorre todos os dados para dar estatísticas (quem é o professor com mais trabalho, qual a turma mais cheia, etc.).
Qual foi a parte mais complicada de criar?
Na minha análise, há três pontos que costumam ser os mais complexos nestes sistemas:

A. Gestão de Relacionamentos (O "Mapeamento")
A parte mais sensível não é criar um aluno ou um curso, mas sim o vínculo entre eles. Por exemplo:

Quando inscreves um Aluno numa Turma, tens de garantir que a Turma tem capacidade disponível.
Ao adicionar uma UnidadeCurricular, tens de verificar se o Professor associado não ultrapassou o limite de 5 UCs. Manter estas referências atualizadas e consistentes entre as várias listas é o que exige mais atenção lógica.

B. Lógica de Estatísticas e Iteração
O menu de estatísticas é complexo porque envolve "navegar" por várias camadas. Para calcular a média de uma turma, o programa tem de:

Ir à Turma.
Pegar na lista de Alunos.
Para cada Aluno, pegar na sua lista de Notas.
Calcular a média de cada aluno e depois a média global. São muitos ciclos (for) encadeados que precisam de ser feitos com cuidado para evitar erros de "ponteiro nulo" (NullPointerException).

C. Tratamento de Input (Scanner)
Lidar com a entrada de dados do utilizador (via teclado) é sempre traiçoeiro. Se o programa espera um número e o utilizador digita uma letra, o programa "estoura" (crash). Por isso, foram criados métodos auxiliares como lerInteiro() e lerDouble() com blocos try-catch para garantir que o programa continua a funcionar mesmo com erros de digitação.

