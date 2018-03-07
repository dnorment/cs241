/**
 * A class to store the information of each city.
 *
 * @author Daniel J. Norment
 * @version 1.1
 */
public class City implements Comparable<City>
{
    private int cityNum;
    private String cityCode;
    private String cityName;
    private int cityPopulation;
    private int cityElevation;
    private int distanceEstimate;
    private boolean visited;
    private String path;
    
    public City()
    {
        throw new IllegalArgumentException("Constructor requires city information to initialize object");
    }
    
    public City(int cityNum, String cityCode, String cityName, int cityPopulation, int cityElevation)
    {
        this.cityNum = cityNum;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.cityPopulation = cityPopulation;
        this.cityElevation = cityElevation;
        path = "";
    }
    
    /**
     * Returns the city's number in the given data.
     * @return  The city's number.
     */
    public int getCityNum()
    {
        return cityNum;
    }
    
    /**
     * Returns the city's code in the given data.
     * @return  The city's code.
     */
    public String getCityCode()
    {
        return cityCode;
    }
    
    /**
     * Returns the city's name in the given data.
     * @return  The city's name.
     */
    public String getCityName()
    {
        return cityName;
    }
    
    /**
     * Returns the city's population in the given data.
     * @return  The city's population.
     */
    public int getCityPopulation()
    {
        return cityPopulation;
    }
    
    /**
     * Returns the city's elevation in the given data.
     * @return  The city's elevation.
     */
    public int getCityElevation()
    {
        return cityElevation;
    }
    
    /**
     * Returns the city's distance estimate to the source.
     * @return  The city's distance estimate.
     */
    public int getDistEstimate()
    {
        return distanceEstimate;
    }
    
    /**
     * Sets the city's distance estimate to the given value.
     * @param dist  The city's new distance estimate.
     */
    public void setDistEstimate(int dist)
    {
        distanceEstimate = dist;
    }
    
    /**
     * Returns whether the city has been visited or not.
     * @return  True if the city has been visited, false if not.
     */
    public boolean visited()
    {
        return visited;
    }
    
    /**
     * Updates the city's visited boolean.
     * @param visited  True if the city is now visited, false otherwise
     */
    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }
    
    /**
     * Overrides the toString() method from Object to print the city record.
     * @return  The formatted string of the city record.
     */
    public String toString()
    {
        return String.format("%d %s %s %d %d", cityNum, cityCode, cityName, cityPopulation, cityElevation);
    }
    
    /** Compares distance estimate between two cities.
     *  @param other  The city to which to compare this one.
     *  @return -1, 0, or 1 if the distance estimate of this city is less than, equal to, or greater than the distance estimate of the other city. */
    public int compareTo(City other)
    {
        if (distanceEstimate < other.getDistEstimate())
        {
            return -1;
        }
        else if (distanceEstimate == other.getDistEstimate())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    
}