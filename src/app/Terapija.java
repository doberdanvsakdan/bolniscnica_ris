package app; /***********************************************************************
 * Module:  Terapija.java
 * Author:  Sergej
 * Purpose: Defines the Class Terapija
 ***********************************************************************/

import java.util.*;

/** @pdOid d4996935-25cb-4ad1-b321-7c98d315d462 */
public class Terapija {
   /** @pdOid a0698d41-05ab-474d-9a3b-8c5da49d9961 */
   private int idTerapije;
   /** @pdOid 40bd9dd8-2e46-4108-adbf-26c1485a1cc7 */
   private int idZaposlenega;
   /** @pdOid 493a422c-7dff-4ff1-be4c-f7f4e057a082 */
   private String opisTezave;
   /** @pdOid 3e110ea1-4b5d-4c6c-8e82-be9ebd680363 */
   private String predpisanoZdravljenje;


   public Terapija(int idTerapije, int idZaposlenega, String opisTezave, String predpisanoZdravljenje) {
      this.idTerapije = idTerapije;
      this.idZaposlenega = idZaposlenega;
      this.opisTezave = opisTezave;
      this.predpisanoZdravljenje = predpisanoZdravljenje;
   }

   public int getIdTerapije() {
      return idTerapije;
   }

   public String getOpisTezave(int idTerapije) {
      return opisTezave;
   }

   public void setOpisTezave(String opisTezave) {
      this.opisTezave = opisTezave;
   }

   public String getPredpisanoZdravljenje(int idTerapije) {
      return predpisanoZdravljenje;
   }

   public void setPredpisanoZdravljenje(String predpisanoZdravljenje) {
      this.predpisanoZdravljenje = predpisanoZdravljenje;
   }

   /** @pdOid eb216218-96c8-4ce9-8530-fbe42dadc6d2 */
   public int zapisTerapije(int idPacienta, String opis) {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 9f7e047f-941f-4e67-927b-46194be4ac46 */
   public int vrniUspesnost() {
      // TODO: implement
      return 0;
   }

}