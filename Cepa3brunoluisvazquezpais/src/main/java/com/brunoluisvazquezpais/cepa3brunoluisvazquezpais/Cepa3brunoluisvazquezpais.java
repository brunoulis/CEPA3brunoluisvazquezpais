/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.brunoluisvazquezpais.cepa3brunoluisvazquezpais;

import Model.*;
import antlr.collections.List;

import java.util.HashSet;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author luisv
 */
public class Cepa3brunoluisvazquezpais {

    public static void createCarrera() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Carreras c = new Carreras();
        c.setNombre("Carrera1");
        // Pondremos la fecha actual
        c.setFecha(new java.sql.Date(System.currentTimeMillis()));
        // La pista la dejamos como null
        laSesion.persist(c);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void createCoche() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Coches c = new Coches();
        // El motor lo dejamos como null
        // El equipo lo dejamos como null
        laSesion.persist(c);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void createEquipo() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Equipos e = new Equipos();
        e.setNombre("Equipo1");
        e.setPais("España");
        // El piloto lo dejamos como null
        laSesion.persist(e);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void createPiloto() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Pilotos p = new Pilotos();
        p.setNombre("Piloto1");
        p.setApellido("Apellidos1");
        // El equipo lo dejamos como null
        laSesion.persist(p);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void createPista() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Pistas p = new Pistas();
        p.setNombre("Pista1");
        p.setPais("España");
        laSesion.persist(p);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void createMotor() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Motores m = new Motores();
        m.setNombre("Motor1");
        m.setDosal(24);
        // El coche lo dejamos como null
        laSesion.persist(m);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void readTables(String tabla) {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();

        Query q = laSesion.createQuery("Select * from " + tabla);
        java.util.List<Object[]> result = q.list();

        for (Object o : result) {
            // Obtenemos el tipo de objeto
            System.out.println(o.getClass().getName() + " " + o);

        }
        laSesion.getTransaction().commit();
        laSesion.close();
    }

    public static void updateCarrera() {
        // Hacemos una consulta para mostrar todos las carreras
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Carreras c = laSesion.get(Carreras.class, 1);
        // Actualizamos la carrera
        c.setNombre("Carrera2");
        c.setFecha(new java.sql.Date(System.currentTimeMillis()));
        laSesion.update(c);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void updateCoche() {
        // Actualizamos el coche
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Coches c = laSesion.get(Coches.class, 1);
        // Actualizamos el coche
        c.setDosal(1);
        laSesion.update(c);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void updateEquipo() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Equipos e = laSesion.get(Equipos.class, 1);
        // Actualizamos el equipo
        e.setNombre("Equipo2");
        e.setPais("España");
        laSesion.update(e);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void updatePiloto() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Pilotos p = laSesion.get(Pilotos.class, 1);
        // Actualizamos el piloto
        p.setNombre("Piloto2");
        p.setApellido("Apellidos2");
        laSesion.update(p);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void updatePista() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Pistas p = laSesion.get(Pistas.class, 1);
        // Actualizamos la pista
        p.setNombre("Pista2");
        p.setPais("España");
        laSesion.update(p);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void updateMotor() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Motores m = laSesion.get(Motores.class, 1);
        // Actualizamos el motor
        m.setNombre("Motor2");
        m.setDosal(1);
        laSesion.update(m);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void deleteCarrera() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Carreras c = laSesion.get(Carreras.class, 1);
        laSesion.delete(c);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void deleteCoche() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Coches c = laSesion.get(Coches.class, 1);
        laSesion.delete(c);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void deleteEquipo() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Equipos e = laSesion.get(Equipos.class, 1);
        laSesion.delete(e);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void deletePiloto() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Pilotos p = laSesion.get(Pilotos.class, 1);
        laSesion.delete(p);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void deletePista() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Pistas p = laSesion.get(Pistas.class, 1);
        laSesion.delete(p);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void deleteMotor() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        Motores m = laSesion.get(Motores.class, 1);
        laSesion.delete(m);
        laSesion.getTransaction().commit();
        laSesion.close();

    }

    public static void showRegistros(String tabla) {

    }

    public static void add(String tabla) {
        // Si es un equipo
        if (tabla.equals("equipo")) {
            // Pregunta a que tabla las cuales contengan el id del equipo
            // Va a ser añadido el equipo
            String opciones;
            System.out.println("A que tabla quieres añadir el equipo");
            System.out.println("1. Pilotos");
            System.out.println("2. Motores");
            System.out.println("3. Chasis");
            opciones = Utilidades.leerTextoC("Pon una de la opciones");
            switch (opciones) {
                case "1":
                    // Añadir a piloto
                    break;
                case "2":
                    // Añadir a motor
                    break;
                case "3":
                    // Añadir a chasis
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } else if (tabla.equals("pista")) {
            // Directamente lo añadira a la tabla de carreras
            // Mostramos todas las carreras
            // Preguntamos que carrera queremos añadir
            // Añadimos la pista a la carrera

            readTables("Carreras");
            Integer opciones;
            // Ponemos la id de la carrera
            System.out.println("A que carrera quieres añadir la pista");
            opciones = Utilidades.leerEnteroC("Pon una de la opciones");

        } else if (tabla.equals("motor")){
            //Directamenmte lo añadiremos a la tabla de coches
            readTables("Coches");


        }else if (tabla.equals("piloto")){
            //Directamenmte lo añadiremos a la tabla de coches
            readTables("Coches");

    }

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); // or whatever

        Boolean continuar = true;
        while (continuar) {
            String opcion = "";
            String opciones;

            opcion = Utilidades.leerTextoC("Pon una de la opciones");
            // Separem l'ordre introduida pel teclat en la forma: "Figura Posicio Mida
            // Color"
            String[] components = opcion.split(" ");

            opciones = components[0];
            switch (opciones) {
                case "create":
                    switch (components[1]) {
                        case "carrera":
                            createCarrera();
                            break;
                        case "coche":
                            createCoche();
                            break;
                        case "equipo":
                            createEquipo();
                            break;
                        case "piloto":
                            createPiloto();
                            break;
                        case "pista":
                            createPista();
                            break;
                        case "motor":
                            createMotor();
                            break;

                        default:
                            break;
                    }
                    break;

                case "read":
                    // Le enviamos el nombre de la tabla
                    readTables(components[1]);
                    break;

                case "update":
                    switch (components[1]) {
                        case "carrera":
                            updateCarrera();
                            break;
                        case "coche":
                            updateCoche();
                            break;

                        case "equipo":
                            updateEquipo();
                            break;
                        case "piloto":
                            updatePiloto();
                            break;
                        case "pista":
                            updatePista();
                            break;
                        case "motor":
                            updateMotor();
                            break;

                        default:
                            break;
                    }
                    break;

                case "delete":
                    switch (components[1]) {
                        case "carrera":
                            deleteCarrera();
                            break;
                        case "coche":
                            deleteCoche();
                            break;

                        case "equipo":
                            deleteEquipo();
                            break;
                        case "piloto":
                            deletePiloto();
                            break;
                        case "pista":
                            deletePista();
                            break;
                        case "motor":
                            deleteMotor();
                            break;

                        default:
                            break;
                    }
                    break;
                case "show":
                    switch (components[1]) {
                        case "-r":
                            showRegistros(components[2]);
                            break;
                    }
                    break;
                case "exit":
                    continuar = false;

                    break;
                case "add":
                    add(components[2]);
                    break;
                default:
                    break;
            }
        }

    }
}
