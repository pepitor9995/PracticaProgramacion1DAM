package practicatema5;

public class Armadura extends Equipamiento{
    //atributos
    private String tipo;
    private String material;



    //constructores
    public Armadura(){
        this.tipo=this.material="";
    }

    public Armadura(String nombre, String rareza, int armadura, int resistenciaMagica, int hp, int valor, String tipo, String material){
        super(nombre, rareza, valor, hp, 0, 0, 0, 0, armadura, resistenciaMagica);

        this.setTipo(tipo);
        this.setMaterial(material);
    }
    public Armadura(Armadura armadura){
        super(armadura);

        this.setTipo(armadura.getTipo());
    }


    //getters y setters
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        switch (tipo.toLowerCase()){
            case "yelmo", "pechera", "hombreras", "guanteletes", "grebas", "botas":
                this.tipo = tipo;
                break;
            default:
                System.err.println("Introduce un tipo de armadura correcto");
        }
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        material = material.toLowerCase();
        switch (material){
            case "tela", "cuero", "metal":
                this.material = material;
                break;
            default:
                System.err.println("Introduce un material de verdad");
        }
    }



    //metodos
    public String toString(){
        return super.toString()+
                "\nEl tipo de la armadura es de: " + this.getTipo() +
                "\nEl material de la armadura es de: " + this.getMaterial();
    }

    public boolean equals(Armadura armadura){
        boolean equals = super.equals(armadura);

        if (this.getTipo().equals(armadura.getTipo()) || this.getMaterial().equals(armadura.getMaterial())){
            equals = false;
        }

        return equals;
    }
}
