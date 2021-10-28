import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Creature {
    String name;
    Random ran = new Random();
    public int  health = 100;
    public int equipment=ran.nextInt(50);
    ArrayList<Weapon> weapons = new ArrayList<>();
    public boolean expects = true;  //ожидает
    public int baseAP=ran.nextInt(30);
    public boolean alive= true;
    ArrayList<Equipment> equipments = new ArrayList<>(10);
    public int x;
    public int y;


    public int getBaseAP() {return baseAP;}
    public int getHealth() {return health;}
    public int getEquipment() {return equipment;}
    public List<Equipment> getequipments () {return equipments;}
}
