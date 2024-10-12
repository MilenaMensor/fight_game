package JogoDeLuta;

import java.util.Random;
import java.util.Scanner;

public class Personagem  extends Entidade{
    Scanner teclado = new Scanner(System.in);
    private String classe;
    private String nome;

    public Personagem(int vida, int dano, String raca) {
        super(vida, dano, raca);
        this.nome = nome;
    }

    public void escolherClasse() {
        int escolha;
        System.out.print("\nESCOLHA SEU NOME: ");
        nome = teclado.next();
        System.out.println("\nESCOLHA SUA CLASSE:");
        System.out.println("[1] Mago");
        System.out.println("[2] Cavalheiro");
        System.out.println("[3] Arqueiro");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                System.out.println("Classe MAGO escolhida!");
                this.dano = 50;
                this.vida = 340;
                this.classe = "Mago";
                break;
            case 2:
                System.out.println("Classe CAVALHEIRO escolhida!");
                this.dano = 35;
                this.vida = 450;
                this.classe = "Cavalheiro";
                break;
            case 3:
                System.out.println("Classe ARQUEIRO escolhida!");
                this.dano = new Random().nextInt(30) + 10;
                this.vida = 300;
                this.classe = "Arqueiro";
                break;
            default:
                System.out.println("Classe incorreta, por favor tente novamente!");
        }
    }

    public void mostrarPersonagem() {
        System.out.println("");
        System.out.println("====PERSONAGEM====");
        System.out.println("Nome: " + this.nome);
        System.out.println("Classe: " + this.classe);
        System.out.println("Vida: " + this.vida);
        System.out.println("Dano: " + this.dano);
        System.out.println("Raça: " + this.raca);
    }

    public void mostrarVitoDerro(Entidade personagem) {
        System.out.println("\nESTÁTISCAS");
        System.out.println("Vitórias: " + personagem.vitoria);
        System.out.println("Derrotas: " + personagem.derrota);
        System.out.println("==================");
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
