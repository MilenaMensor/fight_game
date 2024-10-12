package JogoDeLuta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GerenciadorDePersonagem {
       protected List<Entidade> personagens;
       protected List<Entidade> inimigos;
       private Scanner acao;
       private Scanner leitor;

    public GerenciadorDePersonagem() {
        this.inimigos = new ArrayList<>();
        this.personagens = new ArrayList<>();
        this.acao = new Scanner(System.in);
        this.leitor = new Scanner(System.in);
    }

    public void batalhar() {
        for (Entidade personagem : personagens) {
            for (Entidade inimigo : inimigos) {
                System.out.println("\n--- Começa a batalha entre " + personagem.raca + " e " + inimigo.raca);

                // Turnos
                while (personagem.estarVivo() && inimigo.estarVivo()) {
                    // TURNO JOGADOR
                    System.out.println("\nSua vez! Escolha sua ação:");
                    System.out.println("[1] Atacar");
                    System.out.println("[2] Defender");

                    int escolha = acao.nextInt();

                    if (escolha == 1) {
                        personagem.atacar(inimigo);
                    } else if (escolha == 2) {
                        personagem.defender();
                    } else {
                        System.out.println("Escolha inválida, você perdeu seu turno!");
                    }

                    // VERIFICAR SE O INIMIGO ESTÁ VIVO.
                    if (!inimigo.estarVivo()) {
                        System.out.println("\nVocê derrotou " + inimigo.raca + "!");
                        personagem.ganharLuta();
                        break;
                    }

                    // TURNO DO INIMIGO.
                    System.out.println("\nTurno do Inimigo...");
                    int acaoInimigo = new Random().nextInt(2) + 1;

                    if (acaoInimigo == 1) {
                        inimigo.atacar(personagem);
                    } else {
                        inimigo.defender();
                    }

                    // VERIFICAR SE O PERSONAGEM ESTÁ VIVO.
                    if (!personagem.estarVivo()) {
                        System.out.println("\nVocê foi derrotado!");
                        personagem.perderLuta();
                        break;
                    }
                }
            }
        }
    }

    public void batalhaFrenética(Personagem personagem) {
        int resposta;
        // REPETIR O CICLO ATÉ A RESPOSTA SER NÃO OU O PERSONAGEM MORRER
        do {
            System.out.println("\nDeseja iniciar o campo de batalha?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            resposta = leitor.nextInt();

            // SE A RESPOTA FOR "SIM" RODA O SEGUINTE COMANDO.
            if (resposta == 1) {
                System.out.println("==============");
                System.out.println("YOUR ENEMY:");
                Inimigos inimigo = Inimigos.criarInimigoAleatorio();
                inimigo.mostrarInimigos();
                while (personagem.estarVivo() && inimigo.estarVivo()) {
                    System.out.println("==============");
                    System.out.println("SUA VEZ, ESCOLHA SUA AÇÃO:");
                    System.out.println("[1] Atacar");
                    System.out.println("[2] Defender");
                    System.out.println("[3] Curar");
                    System.out.println("==============");

                    int acao = leitor.nextInt();

                    if (acao == 1) {
                        personagem.atacar(inimigo);
                    } else if (acao == 2) {
                        personagem.defender();
                    } else if (acao == 3) {
                        personagem.usarPocaoCura();
                    } else {
                        System.out.println("Você perdeu seu turno!");
                    }

                    // VERIFICAR SE O INIMIGO ESTIVER VIVO.
                    if (!inimigo.estarVivo()) {
                        System.out.println("\nVocê Derrotou: " + inimigo.raca);
                        personagem.ganharLuta();
                        break;
                    }

                    System.out.println("\n================");
                    System.out.println("TURNO DO INIMIGO:");
                    int acaoInimigo = new Random().nextInt(3) + 1;

                    // ESCOLHA ALEATÓRIO DO INIMIGO.
                    if (acaoInimigo == 1) {
                        inimigo.atacar(personagem);
                    } else if (acaoInimigo == 2) {
                        inimigo.defender();
                    } else {
                        inimigo.usarPocaoCura();
                    }
                }
            }
        } while (personagem.estarVivo());

        System.out.println("\n=============");
        System.out.println("VOCÊ PERDEU!");
        personagem.perderLuta();
    }

    public void adicionarInimigo(Entidade inimigo) {
        inimigos.add(inimigo);
    }

    public void adicionarPersonagem(Entidade personagem) {
        personagens.add(personagem);
    }

    public List<Entidade> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Entidade> personagens) {
        this.personagens = personagens;
    }
}