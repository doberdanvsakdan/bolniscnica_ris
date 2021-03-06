package app; /***********************************************************************
 * Module:  OpisPacienta.java
 * Author:  Sergej
 * Purpose: Defines the Class OpisPacienta
 ***********************************************************************/

import java.util.*;

/** @pdOid 54acbcd4-1e32-4311-a8df-cd0c1396d0eb */
public class OpisPacienta {
   /** @pdOid 30df66a2-b2e8-4a85-b8ae-a91d2299d5f3 */
   private String ime;
   /** @pdOid 31d1af5f-08d1-4327-8dda-610a80b34ee1 */
   private String priimek;
   /** @pdOid 8d3aaeb4-9cf2-41bd-8b4b-04136badfb8c */
   private String emso;
   /** @pdOid 028c48a4-40de-4035-90d9-ed4bf047b564 */
   private String naslov;
   /** @pdOid 444fc79e-c2ec-47f1-ad23-66a226860686 */
   private Date datumRojstva;
   /** @pdOid 271b667f-133b-44be-9ba1-bc26daa64395 */
   private String tel;
   /** @pdOid 23aff2bd-5568-4e4b-be0e-73c494390eaf */
   private int stZzzs;
   /** @pdOid 65d15532-2f5b-4e5f-9e38-bab18a1c6dd2 */
   private int idPacienta;
   private static int stPacientov;

   public OpisPacienta(String ime, String priimek, String emso, String naslov, String tel, int id) {
      this.idPacienta = id;
      this.ime = ime;
      this.priimek = priimek;
      this.emso = emso;
      this.naslov = naslov;
      this.tel = tel;
   }

   public int size(){
      return stPacientov;
   }

   public int getIdPacienta() {
      return idPacienta;
   }

   /** @pdOid 0a94d17b-53f1-4679-88b4-3d2c896ca29b */
   public int zahtevaZaKartoteko() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid b7aece28-d878-487e-9d9e-0a706d42d22a */
   public int vrniKartoteko() {
      // TODO: implement
      return 0;
   }

   public String getName() {
      return this.ime;
   }

   public void setName(String ime) {
      this.ime = ime;
   }

   public String getPriimek(){
      return this.priimek;
   }

   public void setPriimek(String priimek) {
      this.priimek = priimek;
   }

   public String getEmso() {
      return emso;
   }

   public void setEmso(String emso) {
      this.emso = emso;
   }

   public String getNaslov() {
      return naslov;
   }

   public void setNaslov(String ulica, String kraj) {
      setNaslov(ulica + ", " + kraj);
   }

   public void setNaslov(String naslov) {
      this.naslov = naslov;
   }

   public Date getDatumRojstva() {
      return datumRojstva;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public int getStZzzs() {
      return stZzzs;
   }


}