package laba3;
import java.util.HashMap;
public class AStarState
{
    private Map2D map;
    HashMap<Location,Waypoint>OpenWp=new HashMap<>();
    // HashMap<Ключ(координата),Значение(вершина-(набор параметров))>открыт.вершина
    HashMap<Location,Waypoint>CloseWp=new HashMap<>();
    // HashMap<Ключ(координата),Значение(вершина-(набор параметров))>закрыт.вершина

    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }
    // Эта функция должна проверить все вершины в наборе открытых вершин,
    // и после этого она должна вернуть ссылку на вершину с наименьшей общей стоимостью.
    public Waypoint getMinOpenWaypoint()
    {
        if (OpenWp.size() == 0)
            return null;
        else
        {
            Waypoint point = null;
            float totalCost = 100000; // локальная переменная
            for (Location key: OpenWp.keySet()) // метод получения множества ключей
            {
                Waypoint point_cur = OpenWp.get(key);
                System.out.println("value=" + point_cur); // метод получения значения по ключу
                if (point_cur.getTotalCost() < totalCost)
                {
                    totalCost = point_cur.getTotalCost();
                    point = point_cur;
                }
            }
            return point;
        }
    }
    // Это функция либо добавляет новую точку, либо ищет наименьшую
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        if ((!OpenWp.containsKey(newWP.loc)))// если новой вершины нет - добавляем
            OpenWp.put(newWP.loc,newWP);
        else // если есть такая вершина
        {
            Waypoint point = OpenWp.get(newWP.loc);
            if(point.getPreviousCost() > newWP.getPreviousCost()) // если новая цена меньше - заменяем точку на новую
            {
                OpenWp.put(newWP.loc,newWP);
                return true;
            }
        }
        return false;
    }

    // Этот метод возвращает количество точек в наборе открытых вершин
    public int numOpenWaypoints()
    {
        return OpenWp.size();
    }
    // Эта функция перемещает вершину из набора «открытых вершин» в набор «закрытых вершин».
    public void closeWaypoint(Location loc)
    {
        Waypoint point = OpenWp.get(loc); // метод получения значения (вершина) по ключу (местоположение)
        OpenWp.remove(loc); // удаление элемента из коллекции
        CloseWp.put(loc,point); // добавление пары (ключ и значение) в коллекцию
    }
    // Эта функция должна возвращать значение true,
    // если указанное местоположение встречается в наборе закрытых вершин, и false в противном случае
    public boolean isLocationClosed(Location loc)
    {
        if (CloseWp.containsKey(loc)) // метод проверки наличия ключа в коллекции
            return true;
        else
            return false;
    }
}
