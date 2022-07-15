package com.example.ejercicio24breng.tablas;

public class Transacciones {
    public static final String tabla_firmas = "tbl_firmas";


    public static final String id = "id";
    public static final String image = "image";
    public static final String descripcion = "descripcion";


    public static final String CreateTableFirmas= "CREATE TABLE tbl_firmas" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "image BLOB, " +
            "descripcion TEXT)";

    public static final String DropTableFirmas= "DROP TABLE IF EXISTS tbl_firmas";
    public static final String NameDataBase = "DBPWI";
}
