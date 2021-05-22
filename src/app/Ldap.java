package app; /***********************************************************************
 * Module:  Ldap.java
 * Author:  Sergej
 * Purpose: Defines the Class Ldap
 ***********************************************************************/

import java.util.*;

/** @pdOid 686ff064-81c0-4264-a2c9-0c99fb5e3b6b */
public class Ldap {
   /** @pdOid 41189b94-8c4f-4895-9fc1-558a96c559bd */
   private ArrayList<Uporabnik> seznamPrijavljenih = new ArrayList<Uporabnik>();

   private void init (){
      seznamPrijavljenih.add(new Uporabnik("Asfaltina","geslo123"));
      seznamPrijavljenih.add(new Uporabnik("teo","123"));
      seznamPrijavljenih.add(new Uporabnik("sergej","123"));
   }

   private boolean find(Uporabnik user) {
      for (Uporabnik uporabnik : seznamPrijavljenih) {
         System.out.println(uporabnik);
         if (uporabnik.upIme.equals(user.upIme) && uporabnik.upGeslo.equals(user.upGeslo))
            return true;
      }
      return false;
   }
   
   /** @pdOid d78c46f4-24be-48e6-8ccc-fa9fdc6989e7 */
   public int zahtevaZaAvtentikacijo(String uporabniskoIme, String geslo) {
      // TODO: implement
      init();
      try {
         if (find(new Uporabnik(uporabniskoIme, geslo)))
            return 1;
      } catch (Exception e){
         System.out.println("Uporabniško ime ali geslo ne obstaja");
      }
      return 0;
   }

}