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

    static public int battle(Creature cr1, Creature cr2){
        if(cr1.health<(cr2.baseAP+cr2.equipment)){
            cr1.health=0;
            cr2.alive=false;
        }
        else{
            cr1.health=cr1.health-(cr2.baseAP+cr2.equipment);
            cr2.health=cr2.health-(cr1.baseAP+cr1.equipment);
        }
        return cr1.health;
    }

    static public Creature battle2(Creature cr1, Creature cr2){
        while (true)
        {
            cr1.health=cr1.health-(cr2.baseAP+cr2.equipment);
            if(cr1.health <= 0) break;
            cr2.health=cr2.health-(cr1.baseAP+cr1.equipment);
            if(cr2.health <= 0) break;
        }
        return cr1.health <= 0 ? cr1 : cr2;
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
        if(p.health<(e.baseAP +e.equipment))
        {
            p.health = 0;
            p.alive=false;
        }else{
            p.health = p.health - (e.baseAP +e.equipment);
            e.expects=false;
        }
        return e.health;
    }
}












