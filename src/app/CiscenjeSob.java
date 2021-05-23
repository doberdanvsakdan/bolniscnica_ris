package app; /***********************************************************************
 * Module:  CiscenjeSob.java
 * Author:  Sergej
 * Purpose: Defines the Class CiscenjeSob
 ***********************************************************************/

import java.util.*;

/** @pdOid 21188ac4-f95d-4123-a6ed-16ae17972c7a */
public class CiscenjeSob {
   /** @pdOid b0d7b350-c430-4b61-96b4-46f69cb4b33c */
   private int stevilkaSobe;
   /** @pdOid 78e789d8-5ef7-4c88-b922-d2966afe6c38 */
   private Date datumZahteve;
   
   /** @pdOid 878c315c-ee65-4b6b-81fb-edd6c1f1592d */
   public int zahtevaZaCiscenjeSob(OpisPacienta patient) {
      try {
         System.out.println("\n\n");
         System.out.println("Izda se zahteva za čiščenje sobe pacienta:");
         System.out.println(patient.getIdPacienta() + " - " + patient.getPriimek() + ", " + patient.getName());
         return 0;
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return 1;
   }

}