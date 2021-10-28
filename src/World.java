import java.util.Random;
import java.util.concurrent.Callable;

public class World {
    private char [][] worldArr = new char[][]{};
    private int count;
    public World(int count){ //создание поля
        this.count=count;
        worldArr = new char[count][];
        for (int i =0;i<worldArr.length;i++){
            worldArr[i]=new char[count];
            for (int k=0;k<worldArr[i].length;k++){
                worldArr[i][k] =' ';
            }
        }
    }

    private boolean IsCheck(int x, int y){
        if(x<0||y<0) return false;
        if(x>=count || y>=count)
            return false;
        return true;
    }

    public void SetPlayer(int x, int y, char ch){ // установка игрока на поле
        if(IsCheck(x,y)){
            worldArr[x][y] = ch;
        }
    }

    public void Print()
    {
        System.out.println();
        System.out.println();
        for (int i = 0; i < worldArr.length; ++i)
        {

            System.out.println();

            for (int j = 0; j < worldArr[i].length; ++j)
            {
                System.out.print(" | ");
                System.out.print(worldArr[j][i]);
            }
            System.out.print(" | ");

        }
    }


    public Posion Step(int x, int y)
    {
        String d = direction();
        System.out.println( d);
        return moving(d, x, y);

    }

    private Posion moving(String s, int x, int y){ // выбор направления хода

        Posion p = new Posion();
        p.x = x; p.y = y;
        if(!IsCheck( x,y)) return  p;

        char ch = worldArr[x][y];
        int _x = x; int _y = y;
        if(s== "Левая_нижняя_диагональ"){
            x--;
            y++;
        }else if(s=="Левая_верхняя_диаганаль"){
            x--;
            y--;
        }
        else if(s=="Правая_верхняя_диаганаль"){
            x++;
            y--;
        }else if(s=="Правая_нижняя_диагональ"){
            x++;
            y++;
        }else if(s=="вправо"){
            x++;
        }else if(s=="влево"){
            x--;
        }else if(s=="вверх"){
            y--;
        }else if(s=="вниз"){
            y++;
        }

        if( IsCheck( x,y)) {
            worldArr[_x][_y] = ' ';
            worldArr[x][y] = ch;

            p.x = x;
            p.y = y;
            return p;
        }

        p.x = _x; p.y = _y;
        return  p;
    }

    static Random random = new Random();
     private String direction(){

        String [] strs = new String[]{"Левая_нижняя_диагональ" , "Левая_верхняя_диаганаль","Правая_верхняя_диаганаль", "Правая_нижняя_диагональ", "вправо", "влево", "вверх", "вниз"};

        String str ="0";
        int r = random.nextInt(8000000);
        if(r<=1000000){
            str = strs[1];
        } else if(r<=2000000){
            str = strs[2];
        } else if(r<=3000000){
            str = strs[3];
        }else if(r<=4000000){
            str = strs[4];
        }else if(r<=5000000){
            str = strs[5];
        }else if(r<=6000000){
            str = strs[6];
        }else if(r<=7000000){
            str = strs[7];
        }else if(r<=8000000){
            str = strs[0];
        }
        return str;
    }

    public  Posion searchfortheenemy ( int x, int y){
        Posion p = new Posion();

        int h = worldArr.length - 1;
        int w = worldArr[0].length - 1;

        int _x=x-1; //проверяем левый низ
       int  _y =y+1;
        if(IsCheck( _x,_y))
        {
            if(worldArr[_x][_y]!=' ' ){
                p.x =_x;p.y =_y;
                p.name =   Character.toString(worldArr[_x][_y]);//String.valueOf(worldArr[_x][_y]);
                return p;
            }
        }
         _y = y-1;//  проверяем вверх
         if (IsCheck( x,_y)) {
            if(worldArr[x][_y]!= ' ' ){
                p.x = x; p.y = _y;
                p.name = Character.toString( worldArr[x][_y]);
                return p;
            }
        }

        _x=x+1;//проверяем правый верх
        _y=y-1;
        if(IsCheck( _x,_y)){
            if(worldArr[_x][_y]!=' '){
                p.x =_x;p.y =_y;
                p.name = Character.toString(worldArr[_x][_y]);
                return p;
            }
        }

        _x =x+1;//проверяем право
        if(IsCheck( _x,y)){
            if(worldArr[_x][y]!=' '){
                p.x=_x;p.y=y;
                p.name = Character.toString(worldArr[_x][y]);
                return  p;
            }
        }
        _x=x+1; //проверяем вправо вниз
        _y=y+1;
        if(IsCheck( _x,_y)){
            if(worldArr[_x][_y]!=' '){
                p.x=_x;p.y=_y;
                p.name = Character.toString(worldArr[_x][_y]);
                return  p;
            }
        }
        _y=y+1; //прверяет вниз
        if(IsCheck( x,_y)){
            if(worldArr[x][_y]!=' '){
                p.x=x;p.y=_y;
                p.name = Character.toString(worldArr[x][_y]);
                return  p;
            }
        }

        _x=x-1; //прверяет влево
        if(IsCheck( _x,y)){
            if(worldArr[_x][y]!=' '){
                p.x=_x;p.y=y;
                p.name = Character.toString(worldArr[_x][y]);
                return  p;
            }
        }
        _x=x-1; // проверяет вправо вверх
        _y=y-1;
        if(IsCheck( _x,_y)){
            if(worldArr[_x][_y]!=' '){
                p.x=_x;p.y=_y;
                p.name = Character.toString(worldArr[_x][_y]);
                return  p;
            }
        }
        return null;

    }

    public char[][] delcr (int x, int y){
         worldArr[x][y] = ' ';
         return worldArr;
    }
}

