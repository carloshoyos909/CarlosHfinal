import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class UltimoParcial {
    
    //personal natual, persona judirico y ongs
    //el codigo debe ser pot terminal y almacenada en el archivo 
    //id, remitente, receptor, fecha

    public static void main(String[] args) {

        try { //con control de error general

        Scanner consola = new Scanner(System.in);
        String[][] fechas = new String[7][100];

        for(int i=0; i <fechas.length;i++) {
            for(int j=0; j<fechas.length;j++){
                fechas[i][j]="";
            }
        }
        
        //declarqcion variables 
        int dia=0;
        String tipoRemitente = "";
        String idRemitente = "";
        String fecha = "";

        // Solicitamos la información al usuario
        for (int i = 0; i < fechas.length; i++) {
            for (int j = 0; j < fechas[i].length; j++) {

                // Validamos el día de la semana
                if (i == 0) {
                    System.out.println("Ingrese el día de la semana (0 = Domingo, 1 = Lunes, ..., 6 = Sábado): ");
                    dia = Integer.parseInt(System.console().readLine());
                }

                // Validamos el tipo de remitente
                if (j == 0) {
                    System.out.println("Ingrese el tipo de remitente (Persona natural, Persona jurídica, ONG): ");
                    tipoRemitente = System.console().readLine();
                }

                // Validamos el ID del remitente
                if (j == 1) {
                    System.out.println("Ingrese el ID del remitente: ");
                    idRemitente = System.console().readLine();
                }

                // Validamos la fecha
                if (j == 2) {
                    System.out.println("Ingrese la fecha (YYYY-MM-DD): ");
                    fecha = System.console().readLine();
                }

                // Guardamos la información en la matriz
                fechas[i][j] = idRemitente + "," + tipoRemitente + "," + fecha;
            }
        }

        // Escribimos la información en el archivo, como son 7 días en mi mente son 7 archivos
        FileWriter fl = new FileWriter("lunes.txt");
        FileWriter fm = new FileWriter("martes.txt");
        FileWriter fMi = new FileWriter("miercoles.txt");
        FileWriter fJ = new FileWriter("jueves.txt");
        FileWriter fV = new FileWriter("viernes.txt");
        FileWriter fS = new FileWriter("sabado.txt");
        FileWriter fD = new FileWriter("domingo.txt");

        PrintWriter pl = new PrintWriter(fl);
        PrintWriter pm = new PrintWriter(fm);
        PrintWriter pMi = new PrintWriter(fMi);
        PrintWriter pJ = new PrintWriter(fJ);
        PrintWriter pV = new PrintWriter(fV);
        PrintWriter pS = new PrintWriter(fS);
        PrintWriter pD = new PrintWriter(fD);


        for (int i = 0; i < fechas.length; i++) {
            for (int j = 0; j < fechas[i].length; j++) {
                pl.println(fechas[i][j]);
                pm.println(fechas[i][j]);
                pMi.println(fechas[i][j]);
                pJ.println(fechas[i][j]);
                pV.println(fechas[i][j]);
                pS.println(fechas[i][j]);
                pD.println(fechas[i][j]);
            }
        }

        pl.close();
        pm.close();
        pMi.close();
        pJ.close();
        pV.close();
        pS.close();
        pD.close();

    } catch (Exception errorG) {
        System.out.println("tiene un error: " + errorG);
    }

    }
    //uso de condicionales para el control de errores  con los condicionales de main

    public static void validarDia(int dia) throws Exception {
        if (dia < 0 || dia > 6) {
            throw new Exception("El día de la semana debe ser un número entre 0 y 6.");
        }
    }
    public static void validarTipoRemitente(String tipoRemitente) throws Exception {
        if (!tipoRemitente.equals("Persona natural") && !tipoRemitente.equals("Persona jurídica") && !tipoRemitente.equals("ONG")) {
            throw new Exception("El tipo de remitente debe ser 'Persona natural', 'Persona jurídica' o 'ONG'.");
        }
    }

    public static void validarFecha(String fecha) throws Exception {
        if (!fecha.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            throw new Exception("La fecha debe estar en el formato YYYY-MM-DD.");
        }
    }


}
