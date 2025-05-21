package practicatema5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mazmorra {
    // atributos
    String nombre;
    int NivelMazmorra;
    ArrayList<Mounstro> mounstros = new ArrayList<>();

    // constructores
    public Mazmorra() {
        nombre = "";
        NivelMazmorra = 0;
        mounstros = new ArrayList<>();
    }

    public Mazmorra(String pathString) throws IOException {
        FileReader fr = new FileReader(pathString);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        String[] campos = new String[2];

        linea = br.readLine();
        campos = linea.split(", ");

        this.setNombre(campos[0]);
        this.setNivelMazmorra(Integer.parseInt(campos[1]));

        while ((linea = br.readLine()) != null) {
            campos = linea.split(",");
            mounstros.add(new Mounstro(campos[1], campos[0]));
        }

        br.close();
        fr.close();

    }

    public Mazmorra(Mazmorra a) {
        this.setNombre(a.getNombre());
        this.setNivelMazmorra(a.getNivelMazmorra());
        this.setMounstro(a.getMounstros());
    }

    // setters y getters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelMazmorra() {
        return this.NivelMazmorra;
    }

    public void setNivelMazmorra(int nivelMazmorra) {
        this.NivelMazmorra = nivelMazmorra;
    }

    public ArrayList<Mounstro> getMounstros() {
        return this.mounstros;
    }

    public void setMounstro(ArrayList<Mounstro> mounstros) {
        for (int i = 0; i < mounstros.size(); i++) {
            this.mounstros.add(mounstros.get(i));
        }
    }

    // metodos
    public Mounstro combateAleatorio() {
        int monstruoAleatorio = (int) (Math.random() * mounstros.size() - 1) + 0;
        int nivelAleatorio = (int) (Math.random() * 7) + this.NivelMazmorra - 3;
        Mounstro monstruo = new Mounstro(this.mounstros.get(monstruoAleatorio));

        for (int i = 1; i < nivelAleatorio; i++) {
            monstruo.subirNivel();
        }

        return monstruo;
    }

    public String toString() {
        String toString = "El nombre de la mazmorra es: " + this.getNombre() +
                "\nEl nivel de la mazmorra es: " + this.getNivelMazmorra() +
                "\nLa mazmorra consta de los siguientes monstruos: \n";

        for (int i = 0; i < this.mounstros.size(); i++) {
            toString += this.mounstros.get(i).toString();
        }

        return toString;

    }

}