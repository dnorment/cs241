
/**
 * An object that stores two references to cities and one integer for the distance estimate.
 *
 * @author Daniel Norment
 * @version 1.0
 */
public class TableNode
{
    private City from;
    private City to;
    private int dist;
    
    public TableNode()
    {
        from = null;
        to = null;
        dist = 0;
    }
    
    public TableNode(City to, int dist, City from)
    {
        this.from = from;
        this.dist = dist;
        this.to = to;
    }
    
    /**
     * Returns the TableNode's fromCity.
     * @return  The TableNode's fromCity.
     */
    public City getRight()
    {
        return from;
    }
    
    /**
     * Returns the TableNode's toCity.
     * @return  The TableNode's toCity.
     */
    public City getLeft()
    {
        return to;
    }
    
    /**
     * Returns the TableNode's distance estimate.
     * @return  The TableNode's distance estimate.
     */
    public int getDistEstimate()
    {
        return dist;
    }
}
