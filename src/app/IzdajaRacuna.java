package app; /***********************************************************************
 * Module:  IzdajaRacuna.java
 * Author:  Sergej
 * Purpose: Defines the Class IzdajaRacuna
 ***********************************************************************/

import java.util.*;

/** @pdOid 1e04cc01-6c82-440d-a1f9-674f7336b492 */
public class IzdajaRacuna {
   /** @pdOid c4e3a676-b9a9-4aa7-8a50-9f8b85a10aa6 */
   private int idPacienta;
   /** @pdOid 8baca08f-f2c2-4f8f-beb7-b590338ef117 */
   private int specialist;
   /** @pdOid 771aeac7-b619-4044-bc64-72c2786cce9a */
   private float cena;
   /** @pdOid f1153d42-d1ad-431b-a5d2-78e28aaa5e9c */
   private Date datum;
   
   /** @pdOid c3fa20ca-beba-4c5d-8aae-801f58be749d */
   public int zahtevaZaIzdajoRacuna(OpisPacienta pacient, int specialist, float cena) {
      try {
         System.out.println("Izda se račun za osebo:");
         System.out.println(pacient.getPriimek() + ", " + pacient.getName());
         System.out.println("Račun je izdal specialist št. " + specialist);
         System.out.println("v višini " + cena + "€.");
         return 0;
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return 1;
   }
   
   /** @pdOid b4fc25d4-b535-4ddd-b2c4-746c8754f9f0 */
   public int zahtevaZaPotaknitevRacuna() {
      // TODO: implement
      return 0;
   }

}