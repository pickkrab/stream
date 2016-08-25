/**
 * Created by alexander on 25.08.16.
 */
public class Workman {
    private String name;
    private int age;
    private int experience;

    public Workman(String name, int age, int experience){
        this.name = name;
        this.age = age;
        this.experience = experience;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getExperience(){
        return experience;
    }
}
