public class GameObject {

    private int posicaoX;
    private int posicaoY;
    private int tamanhoTela;
    private boolean visivel=true;
    private int direcao;
    
    public boolean isVisivel() {
        return visivel;
    }



    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public GameObject(int posicaoX, int posicaoY, int tamanhoTela) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.tamanhoTela = tamanhoTela;
    }

    public int getX() {
        return posicaoX;
    }

    public void setX(int posicaoX) {
        if (posicaoX<0) {
            System.out.println("Posicao Invalida");
            this.posicaoX = 0;
        }
        else
        this.posicaoX = posicaoX;
    }

    public int getY() {
        return posicaoY;
    }

    public void setY(int posicaoY) {
        if (posicaoY<0) {
            System.out.println("Posicao Invalida");
            this.posicaoY = 0;
        }
        else
        this.posicaoY = posicaoY;
        
    }

    public int getScreenSize() {
        return tamanhoTela;
    }

    public void setScreenSize(int tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    public GameObject(int posicaoX, int posicaoY){
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;

    }

    public boolean colisao(GameObject obj){
        if(getX() >= obj.getX() && getX() <= obj.getX() + 50 && getY() >= obj.getY() && getY() <= obj.getY() + 50){
            return true;
        }
        return false;
    }
    public int getDirecao() {
        return direcao;
    }

    public void setDirection(int direcao) {
        if (direcao<0) {
            System.out.println("direcao Invalida");
        }
        
        this.direcao = direcao;
    }
    public boolean mover(){

    int x=getX(), y=getY();

        if(direcao == 0){
           y -= 10;
        }
        if(direcao == 180){
            y += 10;
        }
        if(direcao == 90){
            x += 10;
        }
        if(direcao == 270){
            x -= 10;
        }

        if(x < getScreenSize() && x > 0){
            if(y < getScreenSize() && y > 0){
                //TODO: Mover o jogador caso verdadeiro
                setX(x);
                setY(y); 
                return true;
            }
        }
       
       return false;

      
            
    }


}
