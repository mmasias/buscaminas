package delaasuncionJose.src;

import java.util.ArrayList;
import java.util.List;

public class Coordenada {
    private int x, y;
    private int[] tamaño;
    private Pedir pedir;
    
    public Coordenada(int[] tamaño) {
        this.tamaño = tamaño;
        this.pedir = new Pedir();
    }

    public void pedir() {
        System.out.println("Eje X:");
        x = pedir.numeroEntero(1, tamaño[0]);
        System.out.println("Eje Y:");
        y = pedir.numeroEntero(1, tamaño[1]);
    }

    public int x(){
        return x-1;
    }

    public int y() {
        return tamaño[1] - y;
    }

    public Coordenada[] adyacente() {
        List<Coordenada> adyacentes = new ArrayList<>();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
    
                int nuevoX = this.x() + dx;
                int nuevoY = this.y() + dy;
    
                if (nuevoX >= 0 && nuevoX < tamaño[0] && nuevoY >= 0 && nuevoY < tamaño[1]) {
                    Coordenada adyacente = new Coordenada(tamaño);
                    adyacente.x = nuevoX + 1;
                    adyacente.y = tamaño[1] - nuevoY;
                    adyacentes.add(adyacente);
                }
            }
        }

        return adyacentes.toArray(new Coordenada[0]);
    }
}