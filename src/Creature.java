import java.util.ArrayList;
import java.util.List;

public class Creature {
    String name;
    int  health;
    int equipment;
    String weapon;
    int baseAP;
    ArrayList<Equipment> equipments = new ArrayList<>();

    public Creature(){
        //this.name = name;
        this.health = 1;
        this.equipment = 1;
        this.baseAP = 1;
    }

    public int getBaseAP() {return baseAP;}
    public int getHealth() {return health;}
    public int getEquipment() {return equipment;}
    public List<Equipment> getequipments () {return equipments;}
}
