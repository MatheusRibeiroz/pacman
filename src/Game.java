import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Game extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Player player = new Player(275, 275, 180);
	private Ghost ghost1 = new Ghost(10,10,10);
	private Ghost ghost2 = new Ghost(500,0,10);
	private Ghost ghost3 = new Ghost(0,500,10);
	private Ghost ghost4 = new Ghost(500,500,10);
	private Bomb bomb = new Bomb(100,100);
	private Booster booster = new Booster(400, 400,(int)(Math.random()*100)+45);

	private JLabel imgPlayer = new JLabel(new ImageIcon("src/images/pacman.png"));
	private JLabel imgGhost1 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost2 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost3 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost4 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgBomb = new JLabel(new ImageIcon("src/images/bomb.png"));
	private JLabel imgBooster = new JLabel(new ImageIcon("src/images/booster.png"));

	private final int SCREENSIZE = 550;
	private int speed = 70;

    // variaveis booleanas para a movimentação em cada direção
	boolean paracima;
	boolean paradireita;
	boolean paraesquerda; 
	boolean parabaixo;  
	
	// Usar para tempo
	int delay = 5000;  // 5 segundos
	int interval = 5000; // 1 segundo

	public static void main(String[] args) {
		new Game().init();
	}

	private void init() {
		setLayout(null);
		player.setScreenSize(SCREENSIZE);
		player.setLife(15);

		ghost1.setScreenSize(SCREENSIZE);
		ghost2.setScreenSize(SCREENSIZE);
		ghost3.setScreenSize(SCREENSIZE);
		ghost4.setScreenSize(SCREENSIZE);
		
		add(imgPlayer);
		add(imgGhost1);
		add(imgGhost2);
		add(imgGhost3);
		add(imgGhost4);
		add(imgBomb);
		add(imgBooster);

		render();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREENSIZE + 100, SCREENSIZE + 100);
		setVisible(true);
		addKeyListener(this);

		run();
	}

	private void render() {
		
		updateLocation(imgPlayer, player);
		updateLocation(imgGhost1, ghost1);
		updateLocation(imgGhost2, ghost2);
		updateLocation(imgGhost3, ghost3);
		updateLocation(imgGhost4, ghost4);
		updateLocation(imgBomb, bomb);
		updateLocation(imgBooster, booster);
		setTitle("Total de Vidas: " + player.getLife());
		SwingUtilities.updateComponentTreeUI(this);
		

	}

	private void updateLocation(JLabel label, GameObject object) {
		label.setBounds(object.getX(), object.getY(), 50, 50);
		ImageIcon myImage = (ImageIcon) label.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        label.setIcon( new ImageIcon(newImg) );
        label.setVisible(object.isVisivel());
	}

	private void run() {
		while (!player.getLife() < 1) {
			// Quando a vida for maior que zero e se a função de botão pressionado estiver em true, então o player ira poder se mover
			if(paracima == true){
				player.mover();
			}   
			if(paraesquerda == true){
				player.mover();
			}  
			if(parabaixo == true){
				player.mover();
			}  
			if(paradireita == true){
				player.mover();
			}           
			//Métodos de colisão 
			if(!player.isInvencivel() && player.colisao(ghost1) || player.colisao(ghost2) || player.colisao(ghost3) || player.colisao(ghost4) || player.colisao(bomb)) {        
				System.out.println("Voce recebeu dano e perdeu uma vida.");
				Dano();
				
			}        
			if(player.colisao(booster) && booster.isVisivel()) {
				System.out.println("Booster ativado");
				player.setInvencivel(true);
				booster.setVisivel(false);
			}
            
			ghost1.Movimentacao();
			ghost2.Movimentacao();
			ghost3.Movimentacao();
			ghost4.Movimentacao();
			
			
			if(!booster.isVisivel()) {
				booster.setTurno(booster.getTurno() - 1);
				if(booster.getTurno() == 0) {
					booster.setVisivel(true);
					player.setInvencivel(false);
					booster.setTurno((int)(Math.random()*100)+45);
					
				}
				
				
			}
			
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
			
		}
    }
		
		
	


	@Override
	public void keyTyped(KeyEvent e) {
        
		char c = e.getKeyChar();
		if (c == '8' || c == 'w') player.setDirection(0);	
		if (c == '6' || c == 'd') player.setDirection(90);	
		if (c == '2' || c == 's') player.setDirection(180);	
		if (c == '4' || c == 'a') player.setDirection(270);	
	}

	@Override
	public void keyPressed(KeyEvent e) {
    // Define que o botão esta pressionado, para não ter lag na movimentação do player
	char c = e.getKeyChar();
	if (c == '8' || c == 'w') paracima = true; 	
	if (c == '6' || c == 'd') paradireita = true;
	if (c == '2' || c == 's') parabaixo = true;	
	if (c == '4' || c == 'a') paraesquerda = true;	
	}


	@Override
	public void keyReleased(KeyEvent e) {
    // Define que o botão não esta pressionado, para não ter lag na movimentação do player
	char c = e.getKeyChar();
	if (c == '8' || c == 'w') paracima = false; 	
	if (c == '6' || c == 'd') paradireita = false;
	if (c == '2' || c == 's') parabaixo = false;	
	if (c == '4' || c == 'a') paraesquerda = false;	
	}
	
	private void resetarPosicao() {
		player.setX(255);
		player.setY(255);
		ghost1.setX(0);
		ghost1.setY(0);
		ghost2.setX(400);
		ghost2.setY(0);
		ghost3.setX(0);
		ghost3.setY(400);
		ghost4.setX(400);
		ghost4.setY(400);
		bomb.setX(100);
		bomb.setY(100);
		booster.setX(200);
		booster.setY(200);
	}
	
	private void Dano() {
		if(!player.isInvencivel()) {
			player.setLife(player.getLife() - 1);
			resetarPosicao();
		}
	
			
	}
	
}  

