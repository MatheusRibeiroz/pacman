public class Ghost extends GameObject{
    
    public Ghost(int tamanhoTela, int posicaohorizontal, int posicaovertical ) {
        super(posicaohorizontal, posicaovertical, tamanhoTela);
    }
    
    // Define movimento randômico do fantasma
    public void Movimentacao() {
    	int posRandom = (int)(Math.random()*3)+0;
    	switch(posRandom) {
    	case 0: setDirection(0);
    	break;
    	case 1: setDirection(90);
    	break;
    	case 2: setDirection(180);
    	break;
    	case 3: setDirection(270);
    	break;
    	}
    	mover();
    }
}

