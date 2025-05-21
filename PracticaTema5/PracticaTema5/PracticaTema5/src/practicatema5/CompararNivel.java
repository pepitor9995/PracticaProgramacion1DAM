package practicatema5;

import java.util.ArrayList;

public class CompararNivel {
    public static void compareNivel(ArrayList<PersonajeRol> personajes) {
        ArrayList<PersonajeRol> aux = new ArrayList<>();

        aux.add(personajes.get(0));

        for (int i = 0; i < personajes.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (personajes.get(j).getNivel() < personajes.get(j + 1).getNivel()) {
                    aux.set(0, personajes.get(j));
                    personajes.set(j, personajes.get(j + 1));
                    personajes.set(j + 1, aux.get(0));
                }
            }
        }
    }

    public static void compareNivelMonstruo(ArrayList<Mounstro> personajes) {
        ArrayList<Mounstro> aux = new ArrayList<>();

        aux.add(personajes.get(0));

        for (int i = 0; i < personajes.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (personajes.get(j).getNivel() < personajes.get(j + 1).getNivel()) {
                    aux.set(0, personajes.get(j));
                    personajes.set(j, personajes.get(j + 1));
                    personajes.set(j + 1, aux.get(0));
                }
            }
        }
    }
}
