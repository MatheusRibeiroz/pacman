public class Player extends GameObject
{
    private int Vida;
    private boolean invencivel;


    public Player(int TamanhodaTela, int posicaohorizontal, int posicaovertical) {
        super(TamanhodaTela, posicaohorizontal, posicaovertical);
    }

    public int getLife() {
        return Vida;
    }

    public void setLife(int Vida) {
        if (Vida > 0) {
            this.Vida = Vida;
            
        }
        else
            System.out.println("Voce perdeu todas as suas vidas");
    }



    public boolean isInvencivel() {
        return invencivel;
    }

    public void setInvencivel(boolean invencivel) {
        this.invencivel = invencivel;
    }

    public Player(int TamanhodaTela, int posicaovertical, int posicaohorizontal, int Vida, int direcao, boolean invencivel) {
        super(posicaohorizontal, posicaovertical, TamanhodaTela);
        this.Vida = Vida;
        this.setDirection(direcao);
        this.invencivel = invencivel;
    }
    

}
       
