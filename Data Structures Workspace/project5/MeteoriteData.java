package project5;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * This class stores Meteorite objects.
 * This class uses a BST storing system.
 *
 * @author Brendan Tang
 * @version 12/6/2020
 */

public class MeteoriteData {

	private BST<Meteorite> meteorites;
	private BST<Meteorite> byMass;
	private BST<Meteorite> byYear;

	public MeteoriteData() {

		this.meteorites = new BST<Meteorite>();
		this.byMass = new BST<Meteorite>(new MassComparator());
		this.byYear = new BST<Meteorite>(new YearComparator());

	}
	
	/**
	 * Adds the given Meteorite object to this BST and return true if an equal Meteorite object is not already present.
	 * Returns false if this BST contains an object equal to m
	 * @param m Meteorite to be added into the BST
	 * @return true if added to BST, false otherwise
	 * @throws NullPointerException if m is null
	 */
	public boolean add(Meteorite m) throws NullPointerException {
		
		if (m == null)
			throw new NullPointerException("Cannot enter null Meteorite");
		
		if(this.meteorites.add(m)){
			this.byMass.add(m);
			this.byYear.add(m);
			return true;
		}
		return false;
	}

	
	
	/**
//	 * Compares this MeteoriteData to obj.
	 * @return true if both this MeteoriteData and obj MeteoriteData is the samee
	 */
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MeteoriteData))
			return false;
		MeteoriteData md = (MeteoriteData) obj;
		if (this.meteorites.equals​(md.meteorites))
			return true;
		return false;

	}

	
	
	/**
	 * Give a collection of all Meteorite objects with mass within delta grams of the specified mass.
	 * Values given in grams.
	 * @param m the Meteorite to add
	 * @return true if successfully added to BST, false otherwise
	 * @throws NullPointerException if m is null
	 */
	public boolean remove(Meteorite m) throws NullPointerException {

		if (m == null)
			throw new NullPointerException("Cannot remove null");
		if (this.meteorites.remove(m)){
			this.byMass.remove(m);
			this.byYear.remove(m);
			return true;
		}
		return false;

	}

	/**
	 * Returns an iterator over the elements in the BST in ascending order.
	 * @return an iterator over the elements in this tree in ascending order
	 */
	public Iterator<Meteorite> iterator() {
		return meteorites.iterator();
	}

	
	
	/**
	 * Search through this MeteoriteData for Meteorite objects matching the mass +/-delta.
	 * @param mass the mass for seraching Meteorite objects
	 * @param delta the maximum difference in mass for the Meteorite objects
	 * @return MeteoriteData populated with Meteorite objects that are within the delta of mass
	 * @throws IllegalArgumentException if mass or delta is less than zero
	 */
	public MeteoriteData getByMass(int mass, int delta) throws IllegalArgumentException {

		if (mass < 0 || delta < 0)
			throw new IllegalArgumentException("Mass or Delta cannot be less than zero");

		MeteoriteData md = new MeteoriteData();
		Meteorite m1 = new Meteorite("a", 1);
		Meteorite m2 = new Meteorite("b", 2);
		m1.setMass(mass - delta);
		m2.setMass(mass + delta);

		ArrayList<Meteorite> al = this.byMass.getRange​(m1, m2);
		
		if(al.isEmpty())
			return null;
		
		for (Meteorite m : al)
			md.meteorites.add(m);

		return md;

	}

	
	
	/**
	 * Search through this MeteoriteData for a Meteorite object closest to Location.
	 * @param loc Location to find the nearest Meteorite object
	 * @return the Meteorite with the closest distance to Location according to Haversine Formula
	 * @throws IllegalArgumentException if loc is null
	 */
	public Meteorite getByLocation(Location loc) throws IllegalArgumentException {

		if (loc == null)
			throw new IllegalArgumentException("Location cannot be null");
		if (this.meteorites.isEmpty())
			return null;

		Iterator<Meteorite> itr = this.meteorites.iterator();
		Meteorite closestMet = itr.next();
		double closestDis = loc.getDistance(closestMet.getLocation());

		while (itr.hasNext()) {
			
			Meteorite met = itr.next();
			double dis = loc.getDistance(met.getLocation());
			if (dis < closestDis){
				closestDis = dis;
				closestMet = met;
			}
		}

		return closestMet;

	}

	
	
	/**
	 * Search through this MeteoriteData for Meteorite objects matching the year.
	 * @param year the year for seraching Meteorite objects
	 * @return the MeteoriteData populated with Meteorite objects that match the year
	 * @throws IllegalArgumentException if year is less than zero
	 */
	public MeteoriteData getByYear(int year) throws IllegalArgumentException {

		if (year < 0)
			throw new IllegalArgumentException("Year cannot be less than zero");

		MeteoriteData md = new MeteoriteData();
		Meteorite m1 = new Meteorite("A", 1);
		Meteorite m2 = new Meteorite("zzzzzzzzz", 2);
		m1.setYear(year);
		m2.setYear(year);
		ArrayList<Meteorite> al = this.byYear.getRange​(m1, m2);

		for (Meteorite m : al)
			md.meteorites.add(m);
		
		return md;

	}

	
	
	/**
	 * Returns a string representation of this MeteoriteData.
	 */
	public String toString() {

		Iterator<Meteorite> itr = this.meteorites.iterator();

		if (itr == null)
			return null;

		String txt = "";
		while (itr.hasNext()) {
			txt = String.format(txt + "%s%n", itr.next().toString());
		}
		return txt;
	}
}
