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

        // TODO Auto-generated method stub
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();

        System.out.println("Hola desde hibernate");

        //Close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
