package spring_batch_update;

public class Venue {
    private int id;
    private String name;
    private String city;
    private String state;
    private String country;
    private String bookedBy;
    private String bookedFor;

    public Venue(String name, String city, String state, String country, String bookedBy, String bookedFor) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.bookedBy = bookedBy;
        this.bookedFor = bookedFor;
    }

    public Venue() {
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", bookedBy='" + bookedBy + '\'' +
                ", bookedFor='" + bookedFor + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getBookedFor() {
        return bookedFor;
    }

    public void setBookedFor(String bookedFor) {
        this.bookedFor = bookedFor;
    }
}
