package practicatema5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Creyente extends PersonajeRol {
    private int fe;

    public Creyente() {
        super();
        fe = 0;
    }

    public Creyente(Creyente a) {
        super(a);
        this.setFe(a.getFe());
    }

    public Creyente(String path) throws IOException {
        super(path);
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea = "";
        String[] campos = new String[1];

        for (int i = 0; i < 14; i++) {
            br.readLine();
        }

        linea = br.readLine();
        campos = linea.split(" ");
        int fe = Integer.parseInt(campos[1]);
        this.fe = fe;

        br.close();
        fr.close();
    }

    public Creyente(String nombre, String raza) {
        super(nombre, raza);
        this.fe = 10;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public int getFe() {
        return fe;
    }

    public abstract int plegaria(int milagro, String objetivo);

    public String toString() {
        String resultado = super.toString() + "\n"
                + "Fe: " + fe;
        return resultado;
    }

    public boolean PersonajesCasen(String path) throws IOException {

        boolean casan = super.PersonajesCasen(path);

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea = "";
        String[] campos = new String[1];

        for (int i = 0; i < 14; i++) {
            br.readLine();
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int fe = Integer.parseInt(campos[1]);
        if (fe != this.getFe()) {
            casan = false;
            this.setFe(fe);
            System.out.println("error en la fe");
        }

        br.close();
        fr.close();

        return casan;
    }
}
