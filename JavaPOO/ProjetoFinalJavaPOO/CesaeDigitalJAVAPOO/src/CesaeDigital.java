import java.util.ArrayList;
import java.util.Scanner;
import curso.*;
import pessoa.*;
import turma.*;

public class CesaeDigital {
    private ArrayList<Curso> cursos;
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private Scanner scanner;

    public CesaeDigital() {
        this.cursos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inicializarDados();
    }

    private void inicializarDados() {
        // Criar Professores
        Professor p1 = new Professor("João Silva", "joao@cesae.pt", "912345678", 45, "Programação", 2500);
        Professor p2 = new Professor("Maria Santos", "maria@cesae.pt", "923456789", 38, "Base de Dados", 2600);
        Professor p3 = new Professor("Pedro Costa", "pedro@cesae.pt", "934567890", 50, "Redes", 2700);
        Professor p4 = new Professor("Ana Oliveira", "ana@cesae.pt", "965678901", 33, "Web Design", 2400);
        professores.add(p1);
        professores.add(p2);
        professores.add(p3);
        professores.add(p4);

        // Criar Cursos
        Curso c1 = new Curso("Software Developer", TipoCurso.FORMACAO, 12);
        Curso c2 = new Curso("Data Science", TipoCurso.POS_GRADUACAO, 18);
        Curso c3 = new Curso("Cibersegurança", TipoCurso.WORKSHOP, 3);
        cursos.add(c1);
        cursos.add(c2);
        cursos.add(c3);

        // Criar Turmas
        Turma t1 = new Turma("SD-2025-A", 25, c1);
        Turma t2 = new Turma("DS-2025-B", 20, c2);
        c1.adicionarTurma(t1);
        c2.adicionarTurma(t2);

        // Criar UCs
        UnidadeCurricular uc1 = new UnidadeCurricular("POO", "JAVA-01", 50, p1);
        UnidadeCurricular uc2 = new UnidadeCurricular("Bases de Dados", "SQL-01", 40, p2);
        UnidadeCurricular uc3 = new UnidadeCurricular("Redes", "NET-01", 30, p3);
        UnidadeCurricular uc4 = new UnidadeCurricular("Web Development", "WEB-01", 60, p4);
        UnidadeCurricular uc5 = new UnidadeCurricular("Matemática", "MAT-01", 20, p1);

        p1.adicionarUC(uc1);
        p1.adicionarUC(uc5);
        p2.adicionarUC(uc2);
        p3.adicionarUC(uc3);
        p4.adicionarUC(uc4);

        c1.adicionarUC(uc1);
        c1.adicionarUC(uc2);
        c1.adicionarUC(uc4);

        t1.adicionarUC(uc1);
        t1.adicionarUC(uc2);

        // Criar Alunos
        for (int i = 1; i <= 10; i++) {
            Aluno a = new Aluno("Aluno " + i, "aluno" + i + "@cesae.pt", "90000000" + i, 20 + i, (i <= 5 ? t1 : t2));
            alunos.add(a);
            if (i <= 5)
                t1.inscreverAluno(a);
            else
                t2.inscreverAluno(a);
        }
    }

    public void menuPrincipal() {
        while (true) {
            System.out.println("\n===== GESTÃO CESAE DIGITAL =====\n");
            System.out.println("1. Gestão de Cursos");
            System.out.println("2. Gestão de Turmas");
            System.out.println("3. Gestão de Unidades Curriculares");
            System.out.println("4. Gestão de Professores");
            System.out.println("5. Gestão de Alunos");
            System.out.println("6. Estatísticas e Relatórios");
            System.out.println("7. Sair\n");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    menuCursos();
                    break;
                case 2:
                    menuTurmas();
                    break;
                case 3:
                    menuUCs();
                    break;
                case 4:
                    menuProfessores();
                    break;
                case 5:
                    menuAlunos();
                    break;
                case 6:
                    menuEstatisticas();
                    break;
                case 7:
                    System.out.println("A sair...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Métodos Auxiliares
    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double lerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // --- MENUS ---

    private void menuCursos() {
        System.out.println("\n--- GESTÃO DE CURSOS ---\n");
        System.out.println("1. Criar Curso");
        System.out.println("2. Listar Cursos");
        System.out.println("3. Voltar\n");
        System.out.print("Escolha uma opção: ");
        int op = lerInteiro();
        if (op == 1) {
            System.out.print("\nNome: ");
            String nome = scanner.nextLine();
            System.out.println("Tipo (1-FORMACAO, 2-POS, 3-WORKSHOP): ");
            int tipoOp = lerInteiro();
            TipoCurso tipo = (tipoOp == 1) ? TipoCurso.FORMACAO
                    : (tipoOp == 2) ? TipoCurso.POS_GRADUACAO : TipoCurso.WORKSHOP;
            System.out.print("Duração (meses): ");
            int duracao = lerInteiro();
            cursos.add(new Curso(nome, tipo, duracao));
            System.out.println("\nCurso criado.");
        } else if (op == 2) {
            for (Curso c : cursos)
                c.mostrarDetalhes();
        }
    }

    private void menuTurmas() {
        System.out.println("\n--- GESTÃO DE TURMAS ---\n");
        System.out.println("1. Criar Turma");
        System.out.println("2. Listar Turmas");
        System.out.println("3. Voltar\n");
        System.out.print("Escolha uma opção: ");
        int op = lerInteiro();
        if (op == 1) {
            if (cursos.isEmpty()) {
                System.out.println("\nCrie um curso primeiro.");
                return;
            }
            System.out.println("\nEscolha o Curso (ID 0-" + (cursos.size() - 1) + "):");
            for (int i = 0; i < cursos.size(); i++)
                System.out.println(i + ". " + cursos.get(i).getNome());
            int idx = lerInteiro();
            if (idx < 0 || idx >= cursos.size())
                return;
            Curso c = cursos.get(idx);

            System.out.print("\nNome da Turma: ");
            String nome = scanner.nextLine();
            System.out.print("Capacidade: ");
            int cap = lerInteiro();
            Turma t = new Turma(nome, cap, c);
            c.adicionarTurma(t);
            System.out.println("\nTurma criada.");
        } else if (op == 2) {
            for (Curso c : cursos)
                c.listarTurmas();
        }
    }

    private void menuUCs() {
        System.out.println("\n--- GESTÃO DE UCs ---\n");
        System.out.println("1. Criar UC");
        System.out.println("2. Listar UCs");
        System.out.println("3. Voltar\n");
        System.out.print("Escolha uma opção: ");
        int op = lerInteiro();
        if (op == 1) {
            if (professores.isEmpty()) {
                System.out.println("\nCrie um professor primeiro.");
                return;
            }
            System.out.print("\nNome: ");
            String nome = scanner.nextLine();
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Carga Horária: ");
            int ch = lerInteiro();

            System.out.println("Escolha o Professor (ID 0-" + (professores.size() - 1) + "):");
            for (int i = 0; i < professores.size(); i++)
                System.out.println(i + ". " + professores.get(i).getNome());
            int idx = lerInteiro();
            if (idx < 0 || idx >= professores.size())
                return;
            Professor p = professores.get(idx);

            UnidadeCurricular uc = new UnidadeCurricular(nome, codigo, ch, p);
            p.adicionarUC(uc);
            System.out.println("\nUC Criada.");
        } else if (op == 2) {
            for (Professor p : professores)
                p.listarUCs();
        }
    }

    private void menuProfessores() {
        System.out.println("\n--- GESTÃO DE PROFESSORES ---\n");
        System.out.println("1. Registar Professor");
        System.out.println("2. Listar Professores");
        System.out.println("3. Voltar\n");
        System.out.print("Escolha uma opção: ");
        int op = lerInteiro();
        if (op == 1) {
            System.out.print("\nNome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String tel = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = lerInteiro();
            System.out.print("Especialidade: ");
            String esp = scanner.nextLine();
            System.out.print("Salário: ");
            double sal = lerDouble();
            professores.add(new Professor(nome, email, tel, idade, esp, sal));
            System.out.println("\nProfessor registado.");
        } else if (op == 2) {
            for (Professor p : professores)
                p.mostrarDetalhes();
        }
    }

    private void menuAlunos() {
        System.out.println("\n--- GESTÃO DE ALUNOS ---\n");
        System.out.println("1. Inscrever Novo Aluno");
        System.out.println("2. Listar Alunos");
        System.out.println("3. Atribuir Nota");
        System.out.println("4. Voltar\n");
        System.out.print("Escolha uma opção: ");
        int op = lerInteiro();
        if (op == 1) {
            System.out.print("\nNome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String tel = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = lerInteiro();
            alunos.add(new Aluno(nome, email, tel, idade));
            System.out.println("\nAluno inscrito (sem turma associada).");
        } else if (op == 2) {
            for (Aluno a : alunos)
                a.mostrarDetalhes();
        } else if (op == 3) {
            System.out.print("\nNúmero do Aluno: ");
            int num = lerInteiro();
            for (Aluno a : alunos) {
                if (a.getNumeroAluno() == num) {
                    System.out.print("\nNota (0-20): ");
                    a.adicionarNota(lerDouble());
                    System.out.println("\nNota adicionada.");
                    return;
                }
            }
            System.out.println("\nAluno não encontrado.");
        }
    }

    private void menuEstatisticas() {
        System.out.println("\n--- ESTATÍSTICAS E RELATÓRIOS ---\n");
        System.out.println("1. Totais (Alunos, Professores, Cursos, Turmas)");
        System.out.println("2. Média de notas de um Aluno específico");
        System.out.println("3. Média de notas de uma Turma inteira");
        System.out.println("4. Alunos com média superior a um valor");
        System.out.println("5. Professor com mais UCs");
        System.out.println("6. Turma com maior e menor número de alunos");
        System.out.println("7. Lista de alunos por estado");
        System.out.println("8. Taxa de ocupação de cada turma");
        System.out.println("9. Voltar\n");
        System.out.print("Escolha uma opção: ");
        int op = lerInteiro();

        switch (op) {
            case 1:
                System.out.println("\nTotal de Alunos: " + alunos.size());
                System.out.println("Total de Professores: " + professores.size());
                System.out.println("Total de Cursos: " + cursos.size());
                int totalTurmas = 0;
                for (Curso c : cursos)
                    totalTurmas += c.getTurmas().size();
                System.out.println("Total de Turmas: " + totalTurmas);
                break;
            case 2:
                System.out.print("\nNúmero do Aluno: ");
                int numA = lerInteiro();
                for (Aluno a : alunos) {
                    if (a.getNumeroAluno() == numA) {
                        System.out.println(
                                "\nMédia do Aluno " + a.getNome() + ": " + String.format("%.2f", a.calcularMedia()));
                        return;
                    }
                }
                System.out.println("\nAluno não encontrado.");
                break;
            case 3:
                System.out.println("\nEscolha a Turma:");
                ArrayList<Turma> todasTurmas = getTodasTurmas();
                for (int i = 0; i < todasTurmas.size(); i++)
                    System.out.println(i + ". " + todasTurmas.get(i).getNome());
                int idxT = lerInteiro();
                if (idxT >= 0 && idxT < todasTurmas.size()) {
                    Turma t = todasTurmas.get(idxT);
                    double somaMedias = 0;
                    if (t.getAlunos().isEmpty()) {
                        System.out.println("\nTurma sem alunos.");
                        break;
                    }
                    for (Aluno a : t.getAlunos())
                        somaMedias += a.calcularMedia();
                    System.out.println("\nMédia da Turma " + t.getNome() + ": "
                            + String.format("%.2f", somaMedias / t.getAlunos().size()));
                }
                break;
            case 4:
                System.out.print("\nValor mínimo da média: ");
                double minMedia = lerDouble();
                System.out.println("\nAlunos com média > " + minMedia + ":");
                for (Aluno a : alunos) {
                    if (a.calcularMedia() > minMedia)
                        System.out.println(
                                "- " + a.getNome() + " (Média: " + String.format("%.2f", a.calcularMedia()) + ")");
                }
                break;
            case 5:
                Professor topProf = null;
                for (Professor p : professores) {
                    if (topProf == null
                            || p.getUnidadesCurriculares().size() > topProf.getUnidadesCurriculares().size())
                        topProf = p;
                }
                if (topProf != null)
                    System.out.println("\nProfessor com mais UCs: " + topProf.getNome() + " ("
                            + topProf.getUnidadesCurriculares().size() + " UCs)");
                break;
            case 6:
                Turma maior = null, menor = null;
                for (Turma t : getTodasTurmas()) {
                    if (maior == null || t.getAlunos().size() > maior.getAlunos().size())
                        maior = t;
                    if (menor == null || t.getAlunos().size() < menor.getAlunos().size())
                        menor = t;
                }
                if (maior != null)
                    System.out
                            .println("\nMaior turma: " + maior.getNome() + " (" + maior.getAlunos().size() + " alunos)");
                if (menor != null)
                    System.out
                            .println("\nMenor turma: " + menor.getNome() + " (" + menor.getAlunos().size() + " alunos)");
                break;
            case 7:
                System.out.println("\nEstado (1-ATIVO, 2-SUSPENSO, 3-CONCLUIDO, 4-DESISTENTE): ");
                int estOp = lerInteiro();
                EstadoAluno est = (estOp == 1) ? EstadoAluno.ATIVO
                        : (estOp == 2) ? EstadoAluno.SUSPENSO
                                : (estOp == 3) ? EstadoAluno.CONCLUIDO : EstadoAluno.DESISTENTE;
                System.out.println("\nAlunos em estado " + est + ":");
                for (Aluno a : alunos) {
                    if (a.getEstado() == est)
                        System.out.println("- " + a.getNome());
                }
                break;
            case 8:
                for (Turma t : getTodasTurmas()) {
                    double taxa = (double) t.getAlunos().size() / t.getCapacidadeMaxima() * 100;
                    System.out.println("\nTurma " + t.getNome() + ": " + String.format("%.2f", taxa) + "% ocupada");
                }
                break;
        }
    }

    private ArrayList<Turma> getTodasTurmas() {
        ArrayList<Turma> todas = new ArrayList<>();
        for (Curso c : cursos)
            todas.addAll(c.getTurmas());
        return todas;
    }
}
