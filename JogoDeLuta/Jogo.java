package JogoDeLuta;

public class Jogo {
    public static void main(String[] args) {
        // Criando o gerenciador de batalhas, inimigos e personagens
        GerenciadorDePersonagem gerenciador = new GerenciadorDePersonagem();

        // Criador de inimigos aleatórios
        Inimigos inimigo1 = Inimigos.criarInimigoAleatorio();
        Inimigos inimigo2 = Inimigos.criarInimigoAleatorio();
        Inimigos inimigo3 = Inimigos.criarInimigoAleatorio();

        Batalha batalha = new Batalha();

        // Criando personagens
        Personagem personagem1 = new Personagem(0,0,"Orc");

        personagem1.escolherClasse();
        personagem1.mostrarPersonagem();
        gerenciador.adicionarPersonagem(personagem1);

        gerenciador.adicionarInimigo(inimigo1);

        personagem1.mostrarVitoDerro(personagem1);

        gerenciador.batalhar();

        personagem1.mostrarVitoDerro(personagem1);
    }
}