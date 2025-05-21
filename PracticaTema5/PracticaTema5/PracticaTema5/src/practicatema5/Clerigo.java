package practicatema5;

import java.io.IOException;

public class Clerigo extends Creyente{
    //constructores
    public Clerigo(){
        super();
    }
    public Clerigo(Clerigo a){
        super(a);
    }
    public Clerigo(String nombre, String raza){
        super(nombre, raza);
    }
    public Clerigo(String path) throws IOException {
        super(path);
    }



    //metodos
    public void subirNivel(){
        setNivel(getNivel()+1);

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 80){
            setFe(getFe() + getNivel()*2);
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 80){
            setResistenciaMagica(getResistenciaMagica() + getNivel()*2);
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 20){
            setVitalidad(getVitalidad() + (int) (getVitalidad() * 0.1));
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 20){
            setFortaleza( getFortaleza() + ((int) (getNivel()/2)));
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 10){
            setFuerza(getFuerza() + ((int) (getNivel()*0.25)));
        }
    }
    public int plegaria(int milagro, String objetivo) {
        Clerigo [] prueba = new Clerigo[5];
        switch (milagro) {
            case 1:
                return (int) (getFe() * 0.70);
            case 2:
                for(int i = 0 ; i <= prueba.length ; i++){
                    return prueba[i].getVitalidad() + ((int) (prueba[i].getVitalidad() * 0.35));
                }
            case 3:
                return ((int) (getFe() * 0.55));
        }
        return 0;
    }
    public void luchar(int milagro ,String objetivo) {
        if(milagro == 3)
            plegaria(milagro, objetivo);
    }
    public void apoyar(int milagro, String objetivo) {
        if (milagro == 1 || milagro == 2)
            plegaria(milagro, objetivo);
    }
    public void equiparArma(Arma arma){
        if (arma.getTipo().equals("baston")){
            setArmaDelPersonaje(arma);
        }
    }
    public void equiparArmaduras(Armadura armadura){
        if (armadura.getMaterial().equals("tela")){
            setArmadurasDelPersonaje(armadura);
        }
    }
    public void equiparArtefactos(Artefacto artefacto){
        setArtefactosDelPersonaje(artefacto);
    }
    public String toString(){
        String resultado = "Ficha del Clerigo: "+getNombre()+"\n"+"\n"
                + super.toString();
        return resultado;
    }
    public boolean PersonajesCasen(String path) throws IOException{
        boolean casan = super.PersonajesCasen(path);

        if (casan == true){
            System.out.println("el clerigo esta perfecto");
        }
        else System.out.println("el clerigo no esta perfecto");

        return casan;
    }
}
