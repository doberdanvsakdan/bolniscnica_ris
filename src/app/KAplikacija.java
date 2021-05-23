package app;
/***********************************************************************
 * Module:  KAplikacija.java
 * Author:  Sergej
 * Purpose: Defines the Class KAplikacija
 ***********************************************************************/

import java.util.*;

/** @pdOid 2176834c-daf6-46cd-a6e9-4dcbf3187198 */
public class KAplikacija {
   /** @pdRoleInfo migr=no name=Ldap assc=association4 mult=1..1 */
   public Ldap ldap;
   /** @pdRoleInfo migr=no name=OpisPacienta assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<OpisPacienta> opisPacientov;
   /** @pdRoleInfo migr=no name=IzdajaRacuna assc=zahtevekZaIzdajoRacuna coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<IzdajaRacuna> izdajaRacuna;
   /** @pdRoleInfo migr=no name=CiscenjeSob assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<CiscenjeSob> ciscenjeSob;
   /** @pdRoleInfo migr=no name=PogrebnaSluzba assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<PogrebnaSluzba> pogrebnaSluzba;
   /** @pdRoleInfo migr=no name=Arhiv assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Arhiv> arhiv;
   private int stPacientov;
   private int stTerapij = 0;
   public ArrayList<Terapija> terapije;
   public ArrayList<KartotekaPacienta> kartoteke;
   public KartotekaPacienta kartotekaPacienta;

   public KAplikacija() {
      kartoteke = new ArrayList<>();
      stPacientov = 0;

      registracija("Marija", "Cvetka", "1805971505463", "Celovška cesta 88, 1000 Ljubljana", "031234657");
      registracija("Joze", "Stefan", "1204970500564", "Slovenska cesta 3, 1000 Ljubljana", "040123456");

      addTerapija(new Terapija(0,0, "to je opis za cvetko", "cvetka preveč pije."));
      addTerapija(new Terapija(1,1,"opis težav za Jožeta", "Z Jožetom ni nič narobe. Je zgolj hipohonder."));

      kartoteke.add(new KartotekaPacienta(0,0));
      kartoteke.add(new KartotekaPacienta(1,1));
   }

   public KartotekaPacienta dobiKartoteko(int idPacienta){
      for (KartotekaPacienta pacienta : kartoteke) {
         if (pacienta.getIdPacienta() == idPacienta)
            return pacienta;
      }
      return null;
   }

   public Terapija dobiTerapijo(int idTerapije){
      for (Terapija terapija : terapije) {
         if (terapija.getIdTerapije() == idTerapije)
            return terapija;
      }
      return null;
   }

   public void registracija(String ime, String priimek, String emso, String naslov, String tel) {
      if (this.opisPacientov == null)
         this.opisPacientov = new ArrayList<>();
      for (OpisPacienta pacient : opisPacientov) {
         if (pacient.getEmso().equals(emso)) {
            return;
         }
      }
      opisPacientov.add(new OpisPacienta(ime, priimek, emso, naslov, tel, this.stPacientov));
      stPacientov++;
   }

   /** @pdOid 2a608df2-a386-488c-8e91-4107a7a9def3 */
   public void vnosTerapijeZOdpustnico(int patID) {

   }

   public OpisPacienta getPacient(String priimek) throws Exception {
      OpisPacienta pacient = exists(priimek);
      if (pacient == null)
         throw new java.lang.Exception("Pacient ne obstaja");
      return pacient;

   }

   public OpisPacienta exists(String priimek){
      for (OpisPacienta pacient:
              opisPacientov) {
         if (String.valueOf(pacient.getPriimek()).equals(priimek))
            return pacient;
      }
      return null;
   }

   /** @pdOid 136de252-1375-4dc7-8bd7-b3dc3ab882cd */
   public int prijavaVSistem(String userName, String pass) {
      ldap = new Ldap();
      return ldap.zahtevaZaAvtentikacijo(userName, pass);
   }
   
   /** @pdOid a4d24478-b24f-4a2c-b193-19e29ac7188c */
   public Object[] dostopDoKartoteke(String priimek) throws Exception {
      OpisPacienta pat = getPacient(priimek);
      Terapija ter = dobiTerapijo(dobiKartoteko(pat.getIdPacienta()).getIdTerapije());

      return new Object[] {pat, ter};
   }
   

   
   /** @pdOid 6fb3904f-ea12-4ee5-9bc5-af99c36fbb70 */
   public int posredujKartoteko() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 3d1c33f6-5623-4032-b3a9-2ecf80aecdd3 */
   public int odobritevAvtentikacije() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 767637dd-c589-4cec-89d1-105932900ac0 */
   public int vrniUspesnost() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid e6291c0e-548a-4483-869d-e1752ed272fa */
   public int arhivirajPacienta() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<OpisPacienta> getOpisPacienta() {
      if (opisPacientov == null)
         opisPacientov = new java.util.ArrayList<OpisPacienta>();
      return opisPacientov;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<OpisPacienta> getPacienti() {
      if (opisPacientov == null)
         opisPacientov = new java.util.ArrayList<OpisPacienta>();
      return opisPacientov.iterator();
   }


   
   /** @pdGenerated default setter
     * @param newOpisPacienta */
   public void setOpisPacienta(java.util.Collection newOpisPacienta) {
      removeAllOpisPacienta();
      for (java.util.Iterator iter = newOpisPacienta.iterator(); iter.hasNext();)
         addOpisPacienta((OpisPacienta)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOpisPacienta */
   public void addOpisPacienta(OpisPacienta newOpisPacienta) {
      if (newOpisPacienta == null)
         return;
      if (this.opisPacientov == null)
         this.opisPacientov = new java.util.ArrayList<>();
      if (!this.opisPacientov.contains(newOpisPacienta))
         this.opisPacientov.add(newOpisPacienta);
   }
   
   /** @pdGenerated default remove
     * @param oldOpisPacienta */
   public void removeOpisPacienta(OpisPacienta oldOpisPacienta) {
      if (oldOpisPacienta == null)
         return;
      if (this.opisPacientov != null)
         if (this.opisPacientov.contains(oldOpisPacienta))
            this.opisPacientov.remove(oldOpisPacienta);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOpisPacienta() {
      if (opisPacientov != null)
         opisPacientov.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection getTerapija() {
      if (terapije == null)
         terapije = new ArrayList<>();
      return terapije;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTerapija() {
      if (terapije == null)
         terapije = new ArrayList<>();
      return terapije.iterator();
   }
   
   /** @pdGenerated default add
     * @param newTerapija */
   public void addTerapija(Terapija newTerapija) {
      if (newTerapija == null)
         return;
      if (this.terapije == null)
         this.terapije = new ArrayList<>();
      if (!this.terapije.contains(newTerapija)) {
         this.terapije.add(newTerapija);
         stTerapij++;
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTerapija */
   public void removeTerapija(Terapija oldTerapija) {
      if (oldTerapija == null)
         return;
      if (this.terapije != null)
         if (this.terapije.contains(oldTerapija))
            this.terapije.remove(oldTerapija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTerapija() {
      if (terapije != null)
         terapije.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection getIzdajaRacuna() {
      if (izdajaRacuna == null)
         izdajaRacuna = new java.util.HashSet();
      return izdajaRacuna;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIzdajaRacuna() {
      if (izdajaRacuna == null)
         izdajaRacuna = new java.util.HashSet();
      return izdajaRacuna.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIzdajaRacuna */
   public void setIzdajaRacuna(java.util.Collection newIzdajaRacuna) {
      removeAllIzdajaRacuna();
      for (java.util.Iterator iter = newIzdajaRacuna.iterator(); iter.hasNext();)
         addIzdajaRacuna((IzdajaRacuna)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newIzdajaRacuna */
   public void addIzdajaRacuna(IzdajaRacuna newIzdajaRacuna) {
      if (newIzdajaRacuna == null)
         return;
      if (this.izdajaRacuna == null)
         this.izdajaRacuna = new java.util.HashSet();
      if (!this.izdajaRacuna.contains(newIzdajaRacuna))
         this.izdajaRacuna.add(newIzdajaRacuna);
   }
   
   /** @pdGenerated default remove
     * @param oldIzdajaRacuna */
   public void removeIzdajaRacuna(IzdajaRacuna oldIzdajaRacuna) {
      if (oldIzdajaRacuna == null)
         return;
      if (this.izdajaRacuna != null)
         if (this.izdajaRacuna.contains(oldIzdajaRacuna))
            this.izdajaRacuna.remove(oldIzdajaRacuna);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIzdajaRacuna() {
      if (izdajaRacuna != null)
         izdajaRacuna.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection getCiscenjeSob() {
      if (ciscenjeSob == null)
         ciscenjeSob = new java.util.HashSet();
      return ciscenjeSob;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCiscenjeSob() {
      if (ciscenjeSob == null)
         ciscenjeSob = new java.util.HashSet();
      return ciscenjeSob.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCiscenjeSob */
   public void setCiscenjeSob(java.util.Collection newCiscenjeSob) {
      removeAllCiscenjeSob();
      for (java.util.Iterator iter = newCiscenjeSob.iterator(); iter.hasNext();)
         addCiscenjeSob((CiscenjeSob)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCiscenjeSob */
   public void addCiscenjeSob(CiscenjeSob newCiscenjeSob) {
      if (newCiscenjeSob == null)
         return;
      if (this.ciscenjeSob == null)
         this.ciscenjeSob = new java.util.HashSet();
      if (!this.ciscenjeSob.contains(newCiscenjeSob))
         this.ciscenjeSob.add(newCiscenjeSob);
   }
   
   /** @pdGenerated default remove
     * @param oldCiscenjeSob */
   public void removeCiscenjeSob(CiscenjeSob oldCiscenjeSob) {
      if (oldCiscenjeSob == null)
         return;
      if (this.ciscenjeSob != null)
         if (this.ciscenjeSob.contains(oldCiscenjeSob))
            this.ciscenjeSob.remove(oldCiscenjeSob);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCiscenjeSob() {
      if (ciscenjeSob != null)
         ciscenjeSob.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection getPogrebnaSluzba() {
      if (pogrebnaSluzba == null)
         pogrebnaSluzba = new java.util.HashSet();
      return pogrebnaSluzba;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPogrebnaSluzba() {
      if (pogrebnaSluzba == null)
         pogrebnaSluzba = new java.util.HashSet();
      return pogrebnaSluzba.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPogrebnaSluzba */
   public void setPogrebnaSluzba(java.util.Collection newPogrebnaSluzba) {
      removeAllPogrebnaSluzba();
      for (java.util.Iterator iter = newPogrebnaSluzba.iterator(); iter.hasNext();)
         addPogrebnaSluzba((PogrebnaSluzba)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPogrebnaSluzba */
   public void addPogrebnaSluzba(PogrebnaSluzba newPogrebnaSluzba) {
      if (newPogrebnaSluzba == null)
         return;
      if (this.pogrebnaSluzba == null)
         this.pogrebnaSluzba = new java.util.HashSet();
      if (!this.pogrebnaSluzba.contains(newPogrebnaSluzba))
         this.pogrebnaSluzba.add(newPogrebnaSluzba);
   }
   
   /** @pdGenerated default remove
     * @param oldPogrebnaSluzba */
   public void removePogrebnaSluzba(PogrebnaSluzba oldPogrebnaSluzba) {
      if (oldPogrebnaSluzba == null)
         return;
      if (this.pogrebnaSluzba != null)
         if (this.pogrebnaSluzba.contains(oldPogrebnaSluzba))
            this.pogrebnaSluzba.remove(oldPogrebnaSluzba);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPogrebnaSluzba() {
      if (pogrebnaSluzba != null)
         pogrebnaSluzba.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection getArhiv() {
      if (arhiv == null)
         arhiv = new java.util.HashSet();
      return arhiv;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorArhiv() {
      if (arhiv == null)
         arhiv = new java.util.HashSet();
      return arhiv.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArhiv */
   public void setArhiv(java.util.Collection newArhiv) {
      removeAllArhiv();
      for (java.util.Iterator iter = newArhiv.iterator(); iter.hasNext();)
         addArhiv((Arhiv)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArhiv */
   public void addArhiv(Arhiv newArhiv) {
      if (newArhiv == null)
         return;
      if (this.arhiv == null)
         this.arhiv = new java.util.HashSet();
      if (!this.arhiv.contains(newArhiv))
         this.arhiv.add(newArhiv);
   }
   
   /** @pdGenerated default remove
     * @param oldArhiv */
   public void removeArhiv(Arhiv oldArhiv) {
      if (oldArhiv == null)
         return;
      if (this.arhiv != null)
         if (this.arhiv.contains(oldArhiv))
            this.arhiv.remove(oldArhiv);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArhiv() {
      if (arhiv != null)
         arhiv.clear();
   }

}