package practicatema5;

import java.util.Comparator;

public class CompareVelo implements Comparator<PersonajeRol> {
    public int compare(PersonajeRol p1, PersonajeRol p2) {
        int esMayor = Integer.compare(p2.getAgilidad(), p1.getAgilidad());

        if (esMayor == 0) {
            p1.setNombre(p1.getNombre().toLowerCase());
            p2.setNombre(p2.getNombre().toLowerCase());

            int limite = 0;

            if (p1.getNombre().length() <= p2.getNombre().length()) {
                limite = p1.getNombre().length();
            } else {
                limite = p2.getNombre().length();
            }

            for (int i = 0; i <= limite; i++) {
                if (p1.getNombre().charAt(i) < p2.getNombre().charAt(i)) {
                    return -1;
                } else if (p1.getNombre().charAt(i) > p2.getNombre().charAt(i)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        return esMayor;
    }



}
