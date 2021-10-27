import com.sun.jdi.event.StepEvent;

import java.util.Random;

public class GameLogic {

    static public int choiceofweapons( Player p){//выбор оружия для игрока
        Weapon weapon = new Weapon();
        p.weapons.add(weapon);
        p.weapons.add(weapon);
        return p.weapons.get(0).hit;

    }

    static public  int APSforENE(Enemy e){ //APS и DPS  врага
        int APS;
        APS = (e.baseAP+e.equipment)*5;
        int dpsE;
        dpsE = e.equipments.get(1).damage*APS;
        return dpsE;
    }

    static public  int APSforPl(Player p){ //APS и DPS игрока
        int APS;
        APS = (p.baseAP+p.equipment)*5;
        int dpsp;
        dpsp =  p.equipments.get(1).damage*APSforPl(p);
        return dpsp;
    }
    static public int damageforEn(Enemy e, Player p){ // нанесение урона противнику

        if(e.health<(p.baseAP + p.equipment)){
            e.health = 0;
            e.alive=false;

        }else{
        e.health = e.health - (p.baseAP +p.equipment );

        }
        return e.health;
    }
    static public int damageforPl(Enemy e, Player p){  // нанесение урона игроку
        if(p.health<(e.baseAP +e.equipments.get(1).damage)) {
            p.health = 0;
            p.alive=false;
        }else{
            p.health = p.health - (e.baseAP +e.equipments.get(1).damage);
            e.expects=false;
        }
        return e.health;
    }
}












