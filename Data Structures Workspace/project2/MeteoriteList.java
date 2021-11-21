package project2;

import java.util.*;

/**
 * This class stores a Collection of Meteorite objects.
 * This class inherits all of its properties from an ArrayList<Meteorite>.
 * It adds Meteorite specific functions that allow search by mass, location, or year.
 * This class does not store Meteorite objects in any particular order.
 *
 * @author Brendan Tang
 * @version 10/7/2020
 */

public class MeteoriteList extends ArrayList<Meteorite> {



  /**
   * Constructs a new MeteoriteList object.
   */
  public MeteoriteList(){

  }



  /**
	 * Search through this MeteoriteList for Meteorite objects matching the mass +/-delta.
	 * @param mass the mass for seraching Meteorite objects
   * @param delta the maximum difference in mass for the Meteorite objects
	 * @return the MeteoriteLinkedList populated with Meteorite objects that are within the delta of mass
   * @throws IllegalArgumentException if mass is less than zero
	 */
  public MeteoriteLinkedList getByMass ( int mass, int delta) throws IllegalArgumentException{
    if(mass < 0){
      throw new IllegalArgumentException("Cannot pass negative mass or delta.");
    }

    // Will throw IllegalArgumentException if year is invalid
    Meteorite temp = new Meteorite("temp", 1);
    temp.setMass(mass);

    // MeteoriteList yearStore = MeteoriteList();
    ArrayList<Meteorite> massStore = new MeteoriteList();

    for(Meteorite m: this){
      if(m.getMass() - delta < mass && m.getMass() + delta > mass){
        massStore.add(m);
      }
    }

    if(massStore.isEmpty()){
      return null;
    }

    Collections.sort(massStore);

    MeteoriteLinkedList mll = new MeteoriteLinkedList((MeteoriteList)massStore);

    return mll;
  }



  /**
	 * Search through this MeteoriteList for a Meteorite object closest to Location.
   * @param loc the Location to find the nearest Meteorite object
	 * @return the Meteorite with the closest distance to Location according to Haversine Formula
   * @throws IllegalArgumentException if loc is null
	 */
  public Meteorite getByLocation ( Location loc) throws IllegalArgumentException{

    if(loc == null)
      throw new IllegalArgumentException("Cannot pass null Location.");

    if(this.isEmpty())
      return null;

    Meteorite closestMet = null;
    double closestDis = -1;

    for(Meteorite m: this){

      if(closestMet == null){
        closestMet = m;
        closestDis = m.getLocation().getDistance(loc);
      }

      if(m.getLocation() != null && m.getLocation().getDistance(loc) < closestDis){
        closestMet = m;
        closestDis = m.getLocation().getDistance(loc);
      }

    }
    return closestMet;
  }



  /**
	 * Search through this MeteoriteList for Meteorite objects matching the year.
	 * @param year the year for seraching Meteorite objects
	 * @return the MeteoriteLinkedList populated with Meteorite objects that match the year
   * @throws IllegalArgumentException if year is less than zero
	 */
  public MeteoriteLinkedList getByYear ( int year) throws IllegalArgumentException{
    if(year < 0){
      throw new IllegalArgumentException("Cannot pass negative Year.");
    }

    // Will throw IllegalArgumentException if year is invalid
    Meteorite temp = new Meteorite("temp", 1);
    temp.setYear(year);

    ArrayList<Meteorite> yearStore = new MeteoriteList();

    for(Meteorite m: this){
      if(m.getYear() == year){
        yearStore.add(m);
      }
    }

    if(yearStore.isEmpty()){
      return null;
    }

    Collections.sort(yearStore);

    MeteoriteLinkedList mll = new MeteoriteLinkedList((MeteoriteList)yearStore);

    return mll;
  }

}
