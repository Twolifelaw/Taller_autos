package modelo;

public class Camion extends Vehiculo {

    /**
     * Atributos Camion
     */

    private int cap_carga;

    /**
     * Constructor vacio.
     */
    public Camion() {
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
     * @param cap_carga
     */

    public Camion(String placa, String marca, String referencia, String modelo, double precio, int num_ruedas,
            int cap_carga) {
        super(placa, marca, referencia, modelo, precio, num_ruedas);
        this.cap_carga = cap_carga;
    }

    @Override
    public String toString() {
        return super.toString() + // Llama al toString de la superclase (Vehiculo)
                "\ncapacidad carga: " + cap_carga;

    }

    /**
     * Getters and Setters.
     * 
     * @return
     */

    public int getCap_carga() {
        return cap_carga;
    }

    public void setCap_carga(int cap_carga) {
        this.cap_carga = cap_carga;
    }

}
