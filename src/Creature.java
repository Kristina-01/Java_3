import java.util.ArrayList;
import java.util.List;

public class Creature {
    String name;
    public int  health = 100;
    public int equipment=20;
    ArrayList<Weapon> weapons = new ArrayList<>();
    public boolean expects = true;  //ожидает
    public int baseAP=30;
    public boolean alive= true;
    ArrayList<Equipment> equipments = new ArrayList<>();



    public int getBaseAP() {return baseAP;}
    public int getHealth() {return health;}
    public int getEquipment() {return equipment;}
    public List<Equipment> getequipments () {return equipments;}
}
