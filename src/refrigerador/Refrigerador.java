package refrigerador;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author EyDOC
 */
public class Refrigerador {

    /**
     * @param args the command line arguments
     */
    static String[][] almacen = new String[25][4];
    public static void main(String[] args) {
        // TODO code application logic here
        almacen = inicializar(almacen);
        almacen = cargarProductos(almacen);
        System.out.println("Productos con Existencia");
        mostrarProductosExistencia(almacen);
        System.out.println("Productos bajo el minimo");
        mostrarProductosBajoMinimo(almacen);
        System.out.println("Productos en cero");
        mostrarProductosEnCero(almacen);
        System.out.println("La siguiente posicion vacia es: "+
            String.valueOf(buscarVacio(almacen)));
        System.out.println("La posicion de la leche es: "+
            String.valueOf(buscarProducto(almacen,"LECHE")));

        //almacen = registrarProductoJOption(almacen);
        //mostrarProductosExistencia(almacen);
        
        almacen = eliminarProducto(almacen,3);
        System.out.println("Productos con Existencia");
        mostrarProductosExistencia(almacen);
    }
    
    /**
     * Pide los datos para un producto nuevo medienta jOption
     * @param arreglo
     * @return 
     */
    private static String[][] registrarProductoJOption(String[][] arreglo){
        String dato;
        int pos = buscarVacio(arreglo);
        if(pos==-1){
            JOptionPane.showMessageDialog(null,"No existen posiciones");
        }else{
            dato = JOptionPane.showInputDialog(null, "Descripcion","Digite lo solicitado",1);
            int pos2 = buscarProducto(arreglo,dato);
            if(pos2!=-1){
                JOptionPane.showMessageDialog(null,"Producto se encuentra registrado");
            }else{
                arreglo[pos][0]=dato;
                dato = JOptionPane.showInputDialog(null, "Unidad","Digite lo solicitado",1);
                arreglo[pos][1]=dato;
                dato = JOptionPane.showInputDialog(null, "Existencia","Digite lo solicitado",1);
                arreglo[pos][2]=dato;
                dato = JOptionPane.showInputDialog(null, "Minimo","Digite lo solicitado",1);
                arreglo[pos][3]=dato;
                JOptionPane.showMessageDialog(null,"Producto almacenado...");
            }
        }
        return arreglo;
    }
    
    /**
     * Pide los datos para un nuevo producto mediante consola
     * @param arreglo
     * @return 
     */
    private static String[][] registrarProducto(String[][] arreglo){
        Scanner en = new Scanner(System.in);
        String dato;
        int pos = buscarVacio(arreglo);
        if(pos==-1){
            System.out.println("No hay posiciones disponibles");
        }else{
            System.out.println("Registro de nuevo producto");
            System.out.print("Descripcion: ");
            dato = en.nextLine();
            int pos2 = buscarProducto(arreglo,dato);
            if(pos2!=-1){
                System.out.println("Producto se encuentra registrado");
            }else{
                arreglo[pos][0]=dato;
                System.out.print("Unidad: ");
                dato = en.nextLine();
                arreglo[pos][1]=dato;
                System.out.print("Existencia: ");
                dato = en.nextLine();
                arreglo[pos][2]=dato;
                System.out.print("Minimo: ");
                dato = en.nextLine();
                arreglo[pos][3]=dato;
                System.out.println("Producto almacenado...");
            }
        }
        return arreglo;
    }
    
    /**
     * Elimina un producto a partir de la posicion en la que se encuentra
     * @param arreglo
     * @param pos
     * @return 
     */
    
    private static String[][] eliminarProducto(String[][] arreglo,int pos){
        arreglo[pos][0] = "-1";
        return arreglo;
    }
    
    /**
     * Busca un producto a partir de la descripcion
     * retorna -1 si no lo encuentra
     * @param arreglo
     * @param descripcion
     * @return 
     */
    private static int buscarProducto(String[][] arreglo,String descripcion){
        int pos = -1;
        for(int i=0;i<arreglo.length;i++){
            if(descripcion.equalsIgnoreCase(arreglo[i][0])){
                return i;
            }
        }
        return pos; 
    }
    
    /**
     * Busca el siguiente espacio vacio en el arreglo.
     * retorna -1 si no lo encuentra
     * @param arreglo
     * @return 
     */
    private static int buscarVacio(String[][] arreglo){
        int pos = -1;
        for(int i=0;i<arreglo.length;i++){
            if("-1".equals(arreglo[i][0])){
                return i;
            }
        }
        return pos; 
    }
    
    /**
     * Muestra los productos con existencia en cero
     * @param arreglo 
     */
    private static void mostrarProductosEnCero(String[][] arreglo){
        boolean e = false;
        for(int i=0; i<arreglo.length; i++){
            e = false;
            for(int j=0;j<arreglo[i].length; j++){
                if(Double.parseDouble(arreglo[i][2])== 0 && arreglo[i][0]!="-1"){
                    System.out.print(arreglo[i][j]+" | ");
                    e=true;
                } 
            }
            if(e){
                System.out.println("");
            } 
        }
    }
    
    /**
     * Incializa el arreglo con -1 como variable de control
     * @param arreglo
     * @return 
     */
    private static String[][] inicializar(String[][] arreglo){
        for(int i=0; i<arreglo.length; i++){
            for(int j=0;j<arreglo[i].length; j++){
                arreglo[i][j]="-1";
            }
        }
        return arreglo;    
    }
    
    /**
     * Muestra todos los datos del arreglo
     * @param arreglo 
     */
    private static void mostrarDatos(String[][] arreglo){
        for(int i=0; i<arreglo.length; i++){
            for(int j=0;j<arreglo[i].length; j++){
                System.out.print(arreglo[i][j]+" | ");
            }
            System.out.println("");
        }
    }
    
    /**
     * Muestra los productos que tienen existencia superior a cero
     * @param arreglo 
     */
    private static void mostrarProductosExistencia(String[][] arreglo){
        boolean e = false;
        for(int i=0; i<arreglo.length; i++){
            e = false;
            for(int j=0;j<arreglo[i].length; j++){
                if(Double.parseDouble(arreglo[i][2])>0 && arreglo[i][0]!="-1"){
                    System.out.print(arreglo[i][j]+" | ");
                    e=true;
                } 
            }
            if(e){
                System.out.println("");
            } 
        }
    }
    
    /**
     * Muestra los productos con existencia bajo el minimo
     * @param arreglo 
     */
    private static void mostrarProductosBajoMinimo(String[][] arreglo){
        boolean e = false;
        for(int i=0; i<arreglo.length; i++){
            e = false;
            for(int j=0;j<arreglo[i].length; j++){
                if(Double.parseDouble(arreglo[i][2])<Double.parseDouble(arreglo[i][3])
                        && arreglo[i][0]!="-1"){
                    System.out.print(arreglo[i][j]+" | ");
                    e=true;
                } 
            }
            if(e){
                System.out.println("");
            } 
        }
    }
    
    /**
     * Siembra datos iniciales en el arreglo.
     * @param arreglo
     * @return 
     */
    private static String[][] cargarProductos(String[][] arreglo){
        arreglo[0][0]="Natilla";
        arreglo[0][1]="350 grs";
        arreglo[0][2]="2";
        arreglo[0][3]="1";
        
        arreglo[1][0]="Queso";
        arreglo[1][1]="Kilo";
        arreglo[1][2]="3";
        arreglo[1][3]="1";
        
        arreglo[3][0]="Tomate";
        arreglo[3][1]="Kilo";
        arreglo[3][2]="3";
        arreglo[3][3]="5";
        
        arreglo[4][0]="Leche";
        arreglo[4][1]="Litro";
        arreglo[4][2]="0";
        arreglo[4][3]="2";
        
        return arreglo;
    }
}
