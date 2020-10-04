package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception{
    public static final  String NO_ITEM = "No Existe un item con ese id en la base de datos.";
    public static final  String NO_CLIENTE = "No Existe un cliente con ese id en la base de datos.";
    public static final  String NO_TIPOITEM = "No Existe un tipo item con ese id en la base de datos.";
    public static final  String NO_ALQUILERITEM = "No esta en alquiler el item con id: ";
    public ExcepcionServiciosAlquiler(String message){
        super(message);
    }

    public ExcepcionServiciosAlquiler(String message, Exception e){
        super(message,e);
    }
}
