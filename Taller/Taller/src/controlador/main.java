package controlador;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Auto;
import modelo.Camion;
import modelo.Concesionario;
import modelo.Moto;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(":) Bienvenido al menú de vehículos :)");
            System.out.println("1 Registrar vehiculo");
            System.out.println("2 Buscar vehiculo.");
            System.out.println("3 Listar vehiculos disponibles");
            System.out.println("4 Vender vehiculo");
            System.out.println("5 Mostrar cantidad de vehiculos");
            System.out.println("6 Actualizar datos del vehiculo");
            System.out.println("7 Total de ventas");
            System.out.println("8 Eliminar vehiculo");
            System.out.println("9 salir");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:// Registro de vehiculos.
                    System.out.println("Elegible: ");
                    System.out.println("1 motos");
                    System.out.println("2 autos");
                    System.out.println("3 camiones");
                    int opcion_vehiculos = entrada.nextInt();
                    if (opcion_vehiculos != 1 && opcion_vehiculos != 2 && opcion_vehiculos != 3) {
                        System.out.println("error al ingresar");
                    } else {
                        if (opcion_vehiculos == 1) {
                            System.out.println("ingrese la placa de la moto: ");
                            String placa_moto = entrada.next();
                            System.out.println("Ingrese la marca de la moto:");
                            String marca_oto = entrada.next();
                            System.out.println("Ingrese la referencia de la moto:");
                            String referencia_moto = entrada.next();
                            System.out.println("Ingrese el modelo de la moto:");
                            String modelo_moto = entrada.next();
                            System.out.println("Ingrese el precio de la moto:");
                            double precio_moto = entrada.nextDouble();
                            System.out.println("Ingrese el número de ruedas de la moto:");
                            int num_ruedas_moto = entrada.nextInt();
                            System.out.println("Ingrese el cilindraje de la moto:");
                            int cilindraje_moto = entrada.nextInt();
                            System.out.println("Ingrese el tamaño del tanque de la moto:");
                            int tam_tanque_moto = entrada.nextInt();
                            Moto nueva_moto = new Moto(placa_moto, marca_oto, referencia_moto, modelo_moto, precio_moto,
                                    num_ruedas_moto, cilindraje_moto, tam_tanque_moto);
                            concesionario.registrarVehiculos(nueva_moto);

                        } else if (opcion_vehiculos == 2) {
                            System.out.println("Ingrese la placa del auto:");
                            String placa_auto = entrada.next();
                            System.out.println("Ingrese la marca del auto:");
                            String marc_auto = entrada.next();
                            System.out.println("Ingrese la referencia del auto:");
                            String referencia_auto = entrada.next();
                            System.out.println("Ingrese el modelo del auto:");
                            String modelo_auto = entrada.next();
                            System.out.println("Ingrese el precio del auto:");
                            double precio_auto = entrada.nextDouble();
                            System.out.println("Ingrese el número de ruedas del auto:");
                            int num_ruedas_auto = entrada.nextInt();
                            System.out.println("Ingrese el número de puertas del auto:");
                            int num_ruertas_auto = entrada.nextInt();
                            System.out.println("El auto es a gasolina? (si/no):");
                            String respuesta = entrada.next();

                            boolean is_gasolina_auto = false;
                            if (respuesta.equalsIgnoreCase("si")) {
                                is_gasolina_auto = true;
                            } else if (respuesta.equalsIgnoreCase("no")) {
                                is_gasolina_auto = false;
                            } else {
                                System.err.println("respuesta invalida.");
                            }
                            Auto nuevo_auto = new Auto(placa_auto, marc_auto, referencia_auto, modelo_auto, precio_auto,
                                    num_ruedas_auto, num_ruertas_auto, is_gasolina_auto);
                            concesionario.registrarVehiculos(nuevo_auto);

                        } else if (opcion_vehiculos == 3) {
                            System.out.println("Ingrese la placa del camion:");
                            String placa_camion = entrada.next();
                            System.out.println("Ingrese la marca del camion:");
                            String marca_camion = entrada.next();
                            System.out.println("Ingrese la referencia del camion:");
                            String referencia_camion = entrada.next();
                            System.out.println("Ingrese el modelo del camion:");
                            String modelo_camion = entrada.next();
                            System.out.println("Ingrese el precio del camion:");
                            double precio_camion = entrada.nextDouble();
                            System.out.println("Ingrese el número de ruedas del camion:");
                            int num_ruedas_camion = entrada.nextInt();
                            System.out.println("Ingrese la capcidad de carga: ");
                            int cap_carga = entrada.nextInt();

                            Camion nuevo_camion = new Camion(placa_camion, marca_camion, referencia_camion,
                                    modelo_camion, precio_camion, num_ruedas_camion, cap_carga);
                            concesionario.registrarVehiculos(nuevo_camion);

                        }

                    }

                    break;// Fin de registro.
                case 2:// busqueda de vehiculos.
                    System.out.println("ingrese el dato por el cual quiere buscar el vehiculo: ");
                    String clave = entrada.next();
                    concesionario.buscarVehiculo(clave);
                    break;

                case 3:// Listar autos disponibles.
                    concesionario.mostrarVehiculosPorTipo();
                    break;
                case 4:
                    System.out.println("Ingrese la placa del vehiculo a vender: ");
                    String placa_venta = entrada.next();
                    concesionario.venderVehiculo(placa_venta);
                    break;

                case 5:

                    concesionario.mostrarVehiculoStock();
                    concesionario.mostrarVehiculosVendidos();

                    break;

                case 6:
                    System.out.println("Ingrese la placa del vehiculo a actualizar: ");
                    String placa_actualizar = entrada.next();
                    concesionario.actualizarDatosVehiculo(placa_actualizar);

                    break;

                case 7:
                    System.out.println("las ventas totales son: " + concesionario.ventasTotales());
                    break;

                case 8:
                    System.out.println("Ingrese la placa del vehiculo a eliminar: ");
                    String placa_eliminar = entrada.next();
                    concesionario.eliminarVehiculo(placa_eliminar);

                    break;
                default:
                    break;
            }

        } while (opcion != 9);

        entrada.close(); // Cierra el Scanner al final
    }
}
