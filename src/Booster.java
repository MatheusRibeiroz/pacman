public class Booster extends Item {
    
    private int turno;
    
    public Booster(int turno, int x, int y) {
        super(x, y,100); 
        this.turno = turno;
    }

	public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

}
