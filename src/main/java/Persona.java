public class Persona {
    private String name;
    private String lastName;

    public Persona(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public String getFullName(){
        return this.name + " " + this.lastName;
    }

}
