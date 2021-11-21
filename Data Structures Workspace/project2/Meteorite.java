package project2;

/**
 * This class represents a Meteorite that stores the ID, name, mass, year it landed, and location.
 *
 * @author Brendan Tang
 * @version 10/7/2020
 */

public class Meteorite implements Comparable<Meteorite> {

  private int id;
  private String name;
  private int mass;
  private int year;
  private Location loc;
  private static final int CURRENT_YEAR = 2020;



  /**
   * Constructs a new Meteorite object with name and ID.
   * @param name name value for Meteorite
   * @param id ID value for Meteorite, valid for positive integers
   * @throws IllegalArgumentException  if ID is invalid
   */
  public Meteorite (String name, int id) throws IllegalArgumentException{
    setName(name);
    setID(id);
  }



  /**
	 * Validates and sets the mass value for this Meteorite object.
	 * @param mass mass value to be examined and set
	 * @throws IllegalArgumentException if mass is less or equal to zero
	 */
  public void setMass(int mass) throws IllegalArgumentException{

    if(mass <= 0)
      throw new IllegalArgumentException("Mass cannot be zero or negative.");

    this.mass = mass;
  }



  /**
	 * Returns the mass value representing this Meteorite object.
	 * @return the mass value of this Meteorite object
	 */
  public int getMass(){
    return this.mass;
  }



  /**
	 * Validates and sets the year value for this Meteorite object.
	 * @param year year value to be examined and set
	 * @throws IllegalArgumentException if year is less or equal to zero or if year is equal or larger than current year
	 */
  public void setYear(int year) throws IllegalArgumentException{

    if(year <= 0)
      throw new IllegalArgumentException("Year cannot be zero or negative.");

    if(year >= CURRENT_YEAR)
      throw new IllegalArgumentException("Year cannot exceed current year.");

    this.year = year;
  }


  /**
	 * Returns the year value representing this Meteorite object.
	 * @return the year value of this Meteorite object
	 */
  public int getYear(){
    return this.year;
  }



  /**
	 * Validates and sets the Location value for this Meteorite object.
	 * @param loc Location value to be examined and set
	 */
  public void setLocation(Location loc){
    this.loc = loc;
  }



  /**
	 * Returns the Location object representing this Meteorite object.
	 * @return the Location object of this Meteorite object
	 */
  public Location getLocation(){
    return this.loc;
  }



  /* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
  @Override
  public int compareTo(Meteorite m) {
    int nameCompare = this.name.compareToIgnoreCase(m.name);

    if(nameCompare != 0)
      return nameCompare;

    return this.id - m.id;
  }



  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object o){
    if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Meteorite))
			return false;
    Meteorite m = (Meteorite) o;
    if(this.compareTo(m) == 0){
      return true;
    }
    return false;
  }


  /**
	 * Returns the string representation of this Meteorite.
	 * @return the string representation of this Meteorite object
	 */
  public String toString () {

    String txt = String.format("%-20s %4d", this.name, this.id);

    if(this.getYear() > 0){
      txt = String.format(txt + " %4d", this.getYear());
    }
    else{
      txt = String.format(txt + " %4s", " ");
    }

    if(this.getMass() > 0){
      txt = String.format(txt + " %6d", this.getMass());
    }
    else{
      txt = String.format(txt + " %6s", " ");
    }

    if(this.getLocation() != null){
      txt = String.format(txt + " %10.5f %10.5f", this.getLocation().getLatitude(), this.getLocation().getLongitude());
    }
    else{
      txt = String.format(txt + " %10s %10s", " ", " ");
    }

    //NAME ID YEAR MASS LATITUDE LONGITUDE
    return txt;
  }



  /**
	 * Validates and sets the Name value for this Meteorite object.
	 * @param name name value to be examined and set
	 * @throws IllegalArgumentException if name is empty
	 */
  private void setName(String name) throws IllegalArgumentException{
    if(name == null || name.isEmpty()){
      throw new IllegalArgumentException("Name cannot be empty.");
    }

    this.name = name;
  }



  /**
	 * Validates and sets the ID value for this Meteorite object.
	 * @param id ID value to be examined and set
	 * @throws IllegalArgumentException if ID is less or equal to zero
	 */
  private void setID(int id) throws IllegalArgumentException{
    if(id <= 0)
      throw new IllegalArgumentException("ID cannot be zero or negative.");

    this.id = id;
  }
}
