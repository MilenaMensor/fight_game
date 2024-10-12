package JogoDeLuta;

import java.util.Random;

public class Inimigos extends Entidade{
    private String classe;

    public Inimigos(int vida, int dano, String raca, String classe) {
        super(vida, dano, raca);
        this.classe = classe;
    }

    public static Inimigos criarInimigoAleatorio() {
        Random criador = new Random();
        String[] nomes = {"Orc", "Goblin", "Humano", "Troll", "Dragão"};
        String[] classes = {"Guerreiro", "Arqueiro", "Mago", "Stalker"};
        String nomeAleatorio = nomes[criador.nextInt(nomes.length)];
        String classeAleatoria = classes[criador.nextInt(classes.length)];
        int vidaAleatoria = 200 + criador.nextInt(200); // Vida entre 200 e 400
        int danoAleatorio = 15 + criador.nextInt(45); // Dano entre 15 e 60
        return new Inimigos(vidaAleatoria, danoAleatorio, nomeAleatorio, classeAleatoria);
    }

    public void mostrarInimigos() {
        System.out.println("\nInimigo: " + this.raca + "\nClasse: " + this.classe + "\nVida: " + this.vida + "\nDano: " + this.dano);
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Inimigos" +
                "\nvida=" + vida +
                "\ndano=" + dano +
                "\nraça='" + raca;
    }
}
