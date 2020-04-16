package Person;

public class Person {
    
    private long Id;
    private String Firstname;
    private String Lastname;

    public Person(long Id, String Firstname, String Lastname) {
        this.Id = Id;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    @Override
    public String toString() {
        return "Person{" + "Id=" + Id + ", Firstname=" + Firstname + ", Lastname=" + Lastname + '}';
    }
    
    
}
