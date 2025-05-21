package practicatema5;

import java.io.IOException;
import java.util.ArrayList;

public class Simulador {
    // atributos
    ArrayList<PersonajeRol> aliados = new ArrayList<>();
    Mazmorra mazmorra;

    // constructores
    public Simulador(ArrayList<PersonajeRol> aliados, String pathMazmorra) throws IOException {
        for (int i = 0; i < aliados.size(); i++) {
            this.aliados.add(aliados.get(i));
        }

        mazmorra = new Mazmorra(pathMazmorra);
    }

    // metodos
    public void Combate() throws IOException {
        int cont = 1;
        ArrayList<Mounstro> monstruosCombatiente = new ArrayList<>();
        int probabilidadCantMonstruos = 0;

        while (cont <= 10) {
            probabilidadCantMonstruos = (int) (Math.random() * 3) + 1;

            for (int index = 0; index < probabilidadCantMonstruos; index++) {
                monstruosCombatiente.add(mazmorra.combateAleatorio());
            }

            if (!aliados.isEmpty()) {
                System.out.println("\nEl combate " + cont + " empieza");
                Combate.combate(aliados, monstruosCombatiente);
            } else {
                System.err.println("No quedan mas heroes para luchar ivan");
                cont = 10;
            }

            monstruosCombatiente.removeAll(monstruosCombatiente);
            cont++;
        }
    }
}
