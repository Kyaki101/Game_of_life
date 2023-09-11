public class Cell {
    private boolean vivo;

    public void setVivo(boolean alive){
        this.vivo = alive;
    }

    public boolean getVivo(){
        return vivo;
    }

    public void show(){
        if(this.getVivo() == true){
            System.out.print("* ");
        }
        else{
            System.out.print("- ");
        }
    }
    Cell(boolean vivo){
        setVivo(vivo);
    }

    public void kill(){
        setVivo(false);
    }
    public void born(){
        setVivo(true);
    }
}
