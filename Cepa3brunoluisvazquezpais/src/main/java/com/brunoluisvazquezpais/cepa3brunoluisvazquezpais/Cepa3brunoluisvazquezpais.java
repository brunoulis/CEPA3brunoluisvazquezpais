/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.brunoluisvazquezpais.cepa3brunoluisvazquezpais;

import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class Cepa3brunoluisvazquezpais {

    public static void main(String[] args) {
        
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need

        System.out.println("Hello World!");

        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        System.out.println("Hello World!");
        
        
        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
