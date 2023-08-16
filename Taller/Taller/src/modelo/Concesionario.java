package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Concesionario {

    /**
     * Arraylis que contiene la informacion de cada tipo de vehiculo
     */
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Vehiculo> vehiculos_vendidos = new ArrayList<>();
    private static double venta_totales = 0;

    public void registrarVehiculos(Vehiculo vehiculo) {
        // Verificar si la placa ya existe
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
                System.out.println("No se puede registrar el vehículo. Ya existe una placa con el mismo número.");
                return;
            }
        }

        vehiculos.add(vehiculo);
        System.out.println("Se registró correctamente!");
    }

    public void buscarVehiculo(String clave) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(clave) ||
                    vehiculo.getMarca().equalsIgnoreCase(clave) ||
                    vehiculo.getReferencia().equalsIgnoreCase(clave) ||
                    vehiculo.getModelo().equalsIgnoreCase(clave)) {

                System.out.println("!Vehiculo encontrado! - Tipo: " + vehiculo.getClass().getSimpleName());
                System.out.println(vehiculo.toString()); // Imprime los atributos generales del vehículo

                if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    System.out.println(moto.toString()); // Imprime los atributos específicos de Moto
                } else if (vehiculo instanceof Auto) {
                    Auto auto = (Auto) vehiculo;
                    System.out.println(auto.toString()); // Imprime los atributos específicos de Auto
                } else if (vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    System.out.println(camion.toString()); // Imprime los atributos específicos de Camión
                }

                return;
            } else {
                try {
                    double valorNumerico = Double.parseDouble(clave);
                    if (Math.abs(vehiculo.getPrecio() - valorNumerico) < 0.01) {
                        System.out.println("!Vehiculo encontrado! - Tipo: " + vehiculo.getClass().getSimpleName());
                        System.out.println(vehiculo.toString()); // Imprime los atributos generales del vehículo
                        if (vehiculo instanceof Moto) {
                            Moto moto = (Moto) vehiculo;
                            System.out.println(moto.toString()); // Imprime los atributos específicos de Moto
                        } else if (vehiculo instanceof Auto) {
                            Auto auto = (Auto) vehiculo;
                            System.out.println(auto.toString()); // Imprime los atributos específicos de Auto
                        } else if (vehiculo instanceof Camion) {
                            Camion camion = (Camion) vehiculo;
                            System.out.println(camion.toString()); // Imprime los atributos específicos de Camión
                        }
                        return; // Sale del método después de encontrar el vehículo
                    }
                } catch (NumberFormatException e) {
                    // No hace nada, simplemente continúa con la iteración
                }
            }
        }
        System.out.println("No se pudo encontrar el vehiculo. Intente de nuevo");
    }

    // 3. Hacer metodo para listar los vehiculos.

    public void mostrarVehiculosPorTipo() {
        System.out.println("Listado de vehículos por tipo:");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Tipo: " + vehiculo.getClass().getSimpleName());

            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                System.out.println(moto.toString()); // Usa el toString() de Moto
            } else if (vehiculo instanceof Auto) {
                Auto auto = (Auto) vehiculo;
                System.out.println(auto.toString()); // Usa el toString() de Auto
            } else if (vehiculo instanceof Camion) {
                Camion camion = (Camion) vehiculo;
                System.out.println(camion.toString()); // Usa el toString() de Camion
            }

            System.out.println();
        }
    }

    public void venderVehiculo(String placa) { // 4. Vender vehiculo y dejar un registro del vehiculo que se vendio.
        Vehiculo vehiculo_vendido = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo_vendido = vehiculo;
                double monto = vehiculo.getPrecio();
                venta_totales += monto;
                break;
            }
        }

        if (vehiculo_vendido != null) {
            vehiculos.remove(vehiculo_vendido);
            vehiculos_vendidos.add(vehiculo_vendido);
            System.out.println("vehiculo vendido: " + vehiculo_vendido.toString());
        } else {
            System.out.println("No se encontro el vehiculo con las placas especificadas.");
        }
    }

    public void mostrarVehiculoStock() {// 5. mostrar el stock de vehiculos.
        int contadorMotos = 0;
        int contadorAutos = 0;
        int contadorCamiones = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Moto) {
                contadorMotos++;
            } else if (vehiculo instanceof Auto) {
                contadorAutos++;
            } else if (vehiculo instanceof Camion) {
                contadorCamiones++;
            }
        }
        System.out.println("Cantidad de motos en stock: " + contadorMotos);
        System.out.println("Cantidad de autos en stock: " + contadorAutos);
        System.out.println("Cantidad de camiones en stock: " + contadorCamiones);
    }

    public void mostrarVehiculosVendidos() {// mostrar la cantida de autos vendidos.
        int contadorMotos = 0;
        int contadorAutos = 0;
        int contadorCamiones = 0;

        for (Vehiculo vehiculo : vehiculos_vendidos) {
            if (vehiculo instanceof Moto) {
                contadorMotos++;
            } else if (vehiculo instanceof Auto) {
                contadorAutos++;
            } else if (vehiculo instanceof Camion) {
                contadorCamiones++;
            }
        }

        System.out.println("Cantidad de motos vendidas: " + contadorMotos);
        System.out.println("Cantidad de autos vendidos: " + contadorAutos);
        System.out.println("Cantidad de camiones vendidos: " + contadorCamiones);
    }

    public void actualizarDatosVehiculo(String placa) {// 6. Actualizar datos del vehiculo.
        Scanner entrada = new Scanner(System.in);
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Datos actuales del vehiculo: ");
                System.out.println(vehiculo.toString());

                // placa
                System.out.println("ingrese la placa a actualizar: ");
                String nueva_placa = entrada.nextLine();
                vehiculo.setPlaca(nueva_placa);

                // marca
                System.out.println("ingrese la marca a actualizar: ");
                String nueva_marca = entrada.nextLine();
                vehiculo.setPlaca(nueva_marca);

                // referencia
                System.out.println("ingrese la referencia a actualizar: ");
                String nueva_referencia = entrada.nextLine();
                vehiculo.setReferencia(nueva_referencia);

                // modelo
                System.out.println("ingrese el modelo a actualizar: ");
                String nueva_modelo = entrada.nextLine();
                vehiculo.setModelo(nueva_modelo);

                // precio
                System.out.println("ingrese el precio a actualizar: ");
                double nueva_precio = entrada.nextDouble();
                vehiculo.setPrecio(nueva_precio);

                System.out.println("datos del vehiculo actualizado: ");
                System.out.println(vehiculo.toString());
            } else {
                System.out.println("No se encontro el vehiculo con las placas especificadas.");
            }

        }
    }

    public double ventasTotales() {// 7. Mostrar ventas totales.
        return venta_totales;
    }

    public void eliminarVehiculo(String placa) {
        Vehiculo vehiculo_encontrado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo_encontrado = vehiculo;
                break;
            }

        }
        if (vehiculo_encontrado != null) {
            vehiculos.remove(vehiculo_encontrado);
            System.out.println("vehiculo eliminado" + vehiculo_encontrado.toString());
        } else {
            System.out.println("No se encontró un vehiculo con la placa especificada.");
        }
    }

}
