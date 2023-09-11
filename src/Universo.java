import java.util.*;

import static java.lang.Math.abs;

public class Universo {
    private int f;
    private int c;

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    private Cell[][] matrix;

    private int[][] ver;

    public int[][] getVer() {
        return ver;
    }

    public void setVer(int[][] ver) {
        this.ver = ver;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Cell[][] matrix) {
        this.matrix = matrix;
    }


    Universo(int f, int c){
        setC(c);
        setF(f);
        setMatrix(new Cell[getF()][getF()]);
        setVer(new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}});
    }

    public int validate(int num){
        if(num == -1)return getF() - 1;
        return num;
    }

    public boolean surround(Cell prueba, int x, int y){
        int neighbors = 0;
        for (int i = 0; i < 8; i++) {
            if(getMatrix()[validate(x + getVer()[i][0]) % getF()][validate(y + getVer()[i][1]) % getF()].getVivo() == true){
                neighbors ++;
            }
        }
        if(prueba.getVivo() == true){
            if(neighbors == 2 || neighbors == 3){
                return true;
            }
            return false;
        }
        if(neighbors == 3){
            return true;
        }
        return false;
    }

    public void llenar(){
        Random random = new Random();
        for(int i = 0; i < getF(); i++){
            for(int j = 0; j < getF(); j++){
                int randomNumber = random.nextInt(2) + 1;
                if(randomNumber == 1){
                    getMatrix()[i][j] = new Cell(false);
                }
                else{getMatrix()[i][j] = new Cell(true);}
            }
        }
    }

    public void evol(){
        Cell[][] next = new Cell[getF()][getF()];
        for(int i = 0; i < getF(); i ++){
            for(int j = 0; j < getF(); j++){
                boolean temp = surround(getMatrix()[i][j], i, j);
                next[i][j] = new Cell(temp);
            }
        }
        setMatrix(next);
    }

    public void show(){
        for(int i = 0; i < getF(); i ++){
            for(int j = 0; j < getF(); j ++){
                getMatrix()[i][j].show();
            }
            System.out.println();
        }
    }

    public boolean revisar(){
        for(int i = 0; i < getF(); i++){
            for(int j = 0; j < getF(); j++){
                if(getMatrix()[i][j].getVivo() == true)return false;
            }
        }
        return true;
    }

    public void jugar(){
        boolean parar = false;
        int counter = 0;
        while(parar == false && counter != 1000){
            evol();
            show();
            System.out.println();
            parar = revisar();
            counter ++;
        }
        if(parar == true)System.out.println("El universo murió");
        else{
            System.out.println("El universo es immortal");
        }
    }


}
