package com.example.testG38.entities;

import java.util.ArrayList;
import java.util.Scanner;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/

class Producto{
    private int codigo;
    private Double precio;
    private String nombre;
    private int inventario;

    public Producto() {
    }

    public Producto(int codigo,  String nombre, Double precio, int inventario) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.inventario = inventario;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
    
}

class BaseDatosProductos{
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    
    public BaseDatosProductos(){
    }
    public void agregarProducto(Producto producto){
        this.listaProductos.add(producto);
    }
    public void borrarProducto(int codigo){
        for(int i=0; i<listaProductos.size(); i++){
            if(listaProductos.get(i).getCodigo() == codigo){
                listaProductos.remove(i);
            }
        }
    }
    public void actualizarProducto(Producto producto){
        for(int i=0; i<listaProductos.size(); i++){
            if(listaProductos.get(i).getCodigo() == producto.getCodigo()){
                listaProductos.remove(i);
                listaProductos.add(producto);
            }
        }
    }
    public String informeFinal(){
        Producto pMayor = new Producto();
        Producto pMenor = new Producto();;
        Double mayor = 0.0;
        Double menor = 0.0;
        int valorTotalPrecios = 0;
        int promedioPrecios = 0;
        int valorInventario = 0;

        for(int i=0; i<listaProductos.size(); i++){
            Producto producto = listaProductos.get(i);
            if (i == 0){
                menor = producto.getPrecio();
                mayor = producto.getPrecio();
            }else if(producto.getPrecio() < menor){
                menor = producto.getPrecio();
                pMenor = producto;
            }else if(producto.getPrecio() > mayor){
                mayor = producto.getPrecio();
                pMayor = producto;
            }

            valorTotalPrecios += listaProductos.get(i).getPrecio();
            
            valorInventario += producto.getInventario() * producto.getPrecio();
        }
        promedioPrecios = valorTotalPrecios / listaProductos.size();
        return pMayor.getNombre() + " " + pMenor.getNombre() + " " + promedioPrecios + " " + valorInventario;
    }

}

class Reto2{

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run(){
        BaseDatosProductos baseDatosProductos = new BaseDatosProductos();

        Producto producto1 = new Producto(1, "Cafe", 5000.0, 25);
        Producto producto2 = new Producto(2, "Limones",	2300.0,	15);
        Producto producto3 = new Producto(3, "Peras",	2700.0,	33);
        Producto producto4 = new Producto(4, "Agua",	9300.0,	5);
        Producto producto5 = new Producto(5, "Tomates",	2100.0,	42);
        Producto producto6 = new Producto(6, "Fresas",	4100.0,	3);
        Producto producto7 = new Producto(7, "Helado",	4500.0,	41);
        Producto producto8 = new Producto(8, "Galletas",	500.0, 8);
        Producto producto9 = new Producto(9, "Chocolates",	3500.0,	80);
        Producto producto10 = new Producto(10, "Tortas",	15000.0,	10);

        baseDatosProductos.actualizarProducto(producto1);
        baseDatosProductos.actualizarProducto(producto2);
        baseDatosProductos.actualizarProducto(producto3);
        baseDatosProductos.actualizarProducto(producto4);
        baseDatosProductos.actualizarProducto(producto5);
        baseDatosProductos.actualizarProducto(producto6);
        baseDatosProductos.actualizarProducto(producto7);
        baseDatosProductos.actualizarProducto(producto8);
        baseDatosProductos.actualizarProducto(producto9);
        baseDatosProductos.actualizarProducto(producto10);

        System.out.println(baseDatosProductos.informeFinal()); 
    }
}
