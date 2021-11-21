package project2;



public class Tester {
  public static void main(String[] args) {
    Meteorite m1 = new Meteorite("abc", 1);
    Location l1 = new Location(60, 60);
    m1.setYear(1990);
    m1.setMass(10);
    m1.setLocation(l1);

    Meteorite m2 = new Meteorite("defghi", 2);
    Location l2 = new Location(-30, 160);
    m2.setYear(2000);
    m2.setMass(1820);
    m2.setLocation(l2);

    MeteoriteList ml1 = new MeteoriteList();
    ml1.add(m1);
    ml1.add(m2);

    MeteoriteList ml2 = new MeteoriteList();

    // Location search = new Location(0, 100);
    Object search = new Location(0, 100);
    System.out.println(ml2.getByLocation((Location) search));

  }
}
