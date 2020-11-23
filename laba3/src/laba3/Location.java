package laba3;
public class Location
{
    public int xCoord;
    public int yCoord;

    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    public int hashCode() // генерация целочисленного кода объекта
    {
        //генерация методом Джошуа Блоха, используем свои члены класса
        int result = 17;
        result = 37 * result + xCoord;
        result = 37 * result + yCoord;
        return result;
    }

    public boolean equals (Object obj) //сравнение объектов или ссылки (если одинаковые - вернет true)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        Location loc = (Location)obj;
        return loc.xCoord == this.xCoord & loc.yCoord == this.yCoord;
    }
}