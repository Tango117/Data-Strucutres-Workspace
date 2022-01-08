package project5;

public class Location {

	  private double latitude;
	  private double longitude;



	  /**
		 * Constructs a new Location object with latitude and longitude.
		 * @param latitude latitude value for Location, valid from -90 to 90 inclusive
	   * @param longitude longitude value for Location, valid from -180 to 180 inclusive
		 * @throws IllegalArgumentException  if latitude or longitude parameter is invalid
		 */
	  public Location (double latitude, double longitude) throws IllegalArgumentException{
	    setLatitude(latitude);
	    setLongitude(longitude);
	  }



	  /**
		 * Calculates the distance between this.Location and loc using Haversine Formula
		 * @param loc Location Object to compare to this.Location to find distance
		 * @return a double representing the distance between the two Locations in kilometers(km).
		 */
	  public double getDistance( Location loc ) throws IllegalArgumentException{
	    if(loc == null)
	      throw new IllegalArgumentException("Cannot pass null Location.");

	    // Distance between latitudes and longitudes
	    double dLat = Math.toRadians(loc.getLatitude() - this.getLatitude());
	    double dLon = Math.toRadians(loc.getLongitude() - this.getLongitude());

	    // Convert to radians
		  double lat1 = Math.toRadians(this.getLatitude());
	    double lat2 = Math.toRadians(loc.getLatitude());

	    // Apply formula
	    double a = Math.pow(Math.sin(dLat / 2), 2) +
	    Math.pow(Math.sin(dLon / 2), 2) *
	    Math.cos(lat1) *
	    Math.cos(lat2);

	    double rad = 6371;
		  double c = 2 * Math.asin(Math.sqrt(a));

	    return rad * c;

	  }



	  /**
		 * Returns the latitude value representing this Location object.
		 * @return the latitude value of this Location object
		 */
	  public double getLatitude(){
	    return this.latitude;
	  }



	  /**
		 * Returns the longitude value representing this Location object.
		 * @return the longitude value of this Location object
		 */
	  public double getLongitude(){
	    return this.longitude;
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
			if (!(o instanceof Location))
				return false;
	    Location l = (Location) o;
	    if(Math.abs(this.getLatitude() - l.getLatitude()) < 0.00001 && Math.abs(this.getLongitude() - l.getLongitude()) < 0.00001)
	      return true;
	    return false;
	  }



	  /**
		 * Validates and sets the latitude value for this Location object.
		 * @param latitude latitude value to be examined and set
		 * @throws IllegalArgumentException if latitude is not within [-90, 90]
		 */
	  private void setLatitude(double latitude) throws IllegalArgumentException{

	    if(latitude <  -90 || latitude > 90)
	      throw new IllegalArgumentException("Latitude cannot be less than -90 or greater than 90.");

	    this.latitude = latitude;
	  }



	  /**
		 * Validates and sets the longitude value for this Location object.
		 * @param longitude longitude value to be examined and set
		 * @throws IllegalArgumentException if longitude is not within [-180, 180]
		 */
	  private void setLongitude(double longitude) throws IllegalArgumentException{

	    if(longitude <  -180 || longitude > 180)
	      throw new IllegalArgumentException("Longitude cannot be less than -180 or greater than 180.");

	    this.longitude = longitude;
	  }
	}

