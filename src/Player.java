public class Player extends GameObject
{
    private int quantVidas;
   
    private boolean invencivel;

    public Player(int posicaoX, int posicaoY, int tamanhoTela) {
        super(posicaoX, posicaoY, tamanhoTela);
    }

    public int getLife() {
        return quantVidas;
    }

    public void setLife(int quantVidas) {
        if (quantVidas<1) {
            System.out.println("Quantidade de vidas precisa ser maior que zero");
        }
        else
        this.quantVidas = quantVidas;
    }



    public boolean isInvencivel() {
        return invencivel;
    }

    public void setInvencivel(boolean invencivel) {
        this.invencivel = invencivel;
    }

    public Player(int posicaoX, int posicaoY, int tamanhoTela, int quantVidas, int direcao, boolean invencivel) {
        super(posicaoX, posicaoY, tamanhoTela);
        this.quantVidas = quantVidas;
        this.setDirection(direcao);
        this.invencivel = invencivel;
    }
    

}
       
