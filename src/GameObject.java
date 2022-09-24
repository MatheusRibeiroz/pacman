public class GameObject {

    private int posicaohorizontal;
    private int posicaovertical;
    private int TamanhodaTela;
    private boolean visivel; //Para ver declarar aqui visivel como true
    private int direcao;
    
    public boolean isVisivel() {
        return visivel;
    }



    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
        visivel = true;
    }

    public GameObject(int TamanhodaTela, int posicaovertical, int posicaohorizontal) {
        this.TamanhodaTela = TamanhodaTela;
        this.posicaovertical = posicaovertical;
        this.posicaohorizontal = posicaohorizontal;   
    }

    public int getX() {
        return posicaohorizontal;
    }

    public void setX(int posicaohorizontal) {
        if (posicaohorizontal>0) {
            this.posicaohorizontal = posicaohorizontal;
            
        }
    }

    public int getY() {
        return posicaovertical;
    }

    public void setY(int posicaovertical) {
        if (posicaovertical>0) {
            this.posicaovertical = posicaovertical;
            
        }
        
    }

    // Define tamanho da tela
    public int getScreenSize() {
        return TamanhodaTela;
    }

    public void setScreenSize(int TamanhodaTela) {
        this.TamanhodaTela = TamanhodaTela;
    }

    public GameObject(int posicaohorizontal, int posicaovertical){
        this.posicaohorizontal = posicaohorizontal;
        this.posicaovertical = posicaovertical;

    }

    

    
    public int getDirecao() {
        return direcao;
    }

    //Direção tem que ter valor acima de zero
    public void setDirection(int direcao) {
        if (direcao<0) {
        }
        
        this.direcao = direcao;
    }
    
    public boolean mover(){

    int x=getX(), y=getY();

        if(direcao == 0){
           y -= 10;
        }
        if(direcao == 90){
            x += 10;
        }
        if(direcao == 180){
            y += 10;
        }
        if(direcao == 270){
            x -= 10;
        }

        // Se os valores de x ou y forem menor que o tamanho da tela e maiores que zero
        if(x > 0 && x < getScreenSize()){
            if( y > 0 && y < getScreenSize()){
                setX(x);
                setY(y); 
            }
        }
       
       return false;

      
            
    }


}
