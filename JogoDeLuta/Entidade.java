package JogoDeLuta;

import java.util.Random;

public class Entidade {
    protected int vida;
    protected int dano;
    protected String raca;
    private boolean estaDefendendo;
    public int vitoria, derrota;

    public Entidade(int vida, int dano, String raca) {
        this.vida = vida;
        this.dano = dano;
        this.raca = raca;
        this.estaDefendendo = false;
    }

    public void atacar(Entidade inimigos) {
        int danoLuta = this.dano;
        System.out.println(raca + " ataca " + inimigos.raca + " com " + danoLuta + " de dano!");
        inimigos.receberDano(dano);
    }

    public void defender() {
        this.estaDefendendo = true;
        System.out.println(raca + " se defendeu e reduziu o dano no próximo ataque!");
    }

    public void receberDano(int dano) {
        // Se está defendendo o dano é reduzido pela metade.
        if (estaDefendendo) {
            dano /= 2;
            System.out.println(this.raca + " está defendendo e recebeu " + dano + " de dano.");
            estaDefendendo = false; // Defesa dura apenas um turno.
        } else {
            System.out.println(this.raca + " recebeu " + dano + " de dano.");
        }

        this.vida -= dano;
        System.out.println("Vida Restante: " + this.vida);
    }

    public void usarPocaoCura() {
        int pocao = new Random().nextInt(20) + 10;
        this.vida += pocao;
        System.out.println(this.raca + " curou " + pocao + " de vida");
        System.out.println("Vida restaurada: " + this.vida);
    }

    public boolean estarVivo() {
        return getVida() > 0;
    }

    public void ganharLuta() {
        vitoria++;
    }

    public void perderLuta() {
        derrota++;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getVitoria() {
        return vitoria;
    }

    public void setVitoria(int vitoria) {
        this.vitoria = vitoria;
    }

    public int getDerrota() {
        return derrota;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }
}
