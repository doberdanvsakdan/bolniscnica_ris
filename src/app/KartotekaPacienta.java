package app; /***********************************************************************
 * Module:  KartotekaPacienta.java
 * Author:  Sergej
 * Purpose: Defines the Class KartotekaPacienta
 ***********************************************************************/

import java.util.*;

/** @pdOid 59ed1c23-84e2-4392-bb41-a961cec9f52c */
public class KartotekaPacienta {
   /** @pdOid a406f1fd-70da-48c2-807a-849c045514c1 */
   private int idPacienta;
   /** @pdOid 520c2671-fbd7-4275-9c0a-bdbbc26e852c */
   private int idTerapije;

   public KartotekaPacienta(int id, int idTer) {
      this.idPacienta = id;
      this.idTerapije = idTer;
   }
   
   /** @pdOid 590067c2-7c5e-410d-98a4-783cacebb99e */
   public int prikliciKartoteko() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 643e1662-39af-49e2-906c-7b74924996c0 */
   public int shraniTerapijo() {
      // TODO: implement
      return 0;
   }

}