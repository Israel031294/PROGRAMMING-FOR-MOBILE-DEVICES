package com.example.app08.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Message {
    private long idMensaje;
    private String Mensaje;
    private long dateInMillis;

    public Message(){}
    public Message(String mensaje) {
        Mensaje = mensaje;
        this.dateInMillis = System.currentTimeMillis();
    }

    public long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public long getDateInMillis() {
        return dateInMillis;
    }

    public void setDateInMillis(long dateInMillis) {
        this.dateInMillis = dateInMillis;
    }

    @Override
    public String toString(){
        String fecha="";
        String text="Mensaje: "+this.Mensaje+"";
        String formatoFecha="dd/MM/yyyy HH:mm:ss";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDateTime datetime = Instant.ofEpochMilli(dateInMillis).atZone(ZoneId.systemDefault()).toLocalDateTime();
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern(formatoFecha, Locale.getDefault());
            fecha=formatter.format(datetime);

        }else{
            long yourmilliseconds=System.currentTimeMillis();
            SimpleDateFormat sdf=new SimpleDateFormat(formatoFecha);
            Date resultDate=new Date(yourmilliseconds);
            fecha=sdf.format(resultDate);
        }
        return text+" (At: "+fecha+" )";
    }
}
