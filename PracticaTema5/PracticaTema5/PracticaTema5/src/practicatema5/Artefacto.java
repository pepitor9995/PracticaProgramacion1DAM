package practicatema5;

public class Artefacto extends Equipamiento{
    //atributos
    private String tipo;



    //constructores
    public Artefacto(){
        tipo="";
    }
    public Artefacto(String nombre, String rareza, int hp, int ataque, int vel, int magia, int fe, int armadura, int valor, int resistenciaMagica, String tipo){
        super(nombre, rareza, valor, hp, ataque, vel, magia, fe, armadura, resistenciaMagica);

        this.setTipo(tipo);
    }
    public Artefacto(Artefacto artefacto){
        super(artefacto);

        this.setTipo(artefacto.getTipo());
    }



    //getters y setters
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        if (tipo.toLowerCase().equals("anillo") || tipo.toLowerCase().equals("amuleto")){
            this.tipo = tipo;
        }else System.err.println("Tipo de artefacto erroneo");
    }



    //metodos
    public String toString(){
        return super.toString() +
                "\nEl tipo de artefacto: " + this.getTipo();
    }
    public boolean equals(Artefacto artefacto) {
        boolean equals = super.equals(artefacto);

        if (this.getTipo().equals(artefacto.getTipo())) {
            equals = false;
        }

        return equals;
    }
}
