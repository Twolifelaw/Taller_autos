package modelo;

public class Auto extends Vehiculo {

    /**
     * Atributos Auto.
     */

    private int num_puertas;
    private boolean is_gasolina;

    /**
     * Constructor vacio.
     */

    public Auto() {
    }

    /**
     * Constructor definiendo atributos.
     * 
     * @param placa
     * @param marca
     * @param referencia
     * @param modelo
     * @param precio
     * @param num_ruedas
     * @param num_puertas
     * @param is_gasolina
     */

    public Auto(String placa, String marca, String referencia, String modelo, double precio, int num_ruedas,
            int num_puertas, boolean isGasolina) {
        super(placa, marca, referencia, modelo, precio, num_ruedas);
        this.num_puertas = num_puertas;
        this.is_gasolina = isGasolina;
    }

    /**
     * Metodo imprimir
     */

    @Override
    public String toString() {
        return super.toString() + // Llama al toString de la superclase (Vehiculo)
                "\nPuertas: " + num_puertas+
                "\nGasolina: " + is_gasolina;
    }

    /**
     * Getters and Setters
     * 
     * @return
     */

    public int getNum_puertas() {
        return num_puertas;
    }

    public void setNum_puertas(int num_puertas) {
        this.num_puertas = num_puertas;
    }

    public boolean isGasolina() {
        return is_gasolina;
    }

    public void setGasolina(boolean isGasolina) {
        this.is_gasolina = isGasolina;
    }

}
