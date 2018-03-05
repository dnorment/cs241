/**
 * A class to store the information of each city.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class City
{
    private int cityNum;
    private String cityCode;
    private String cityName;
    private int cityPopulation;
    private int cityElevation;
    
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
     * Overrides the toString() method from Object to print the city record.
     * @return  The formatted string of the city record.
     */
    public String toString()
    {
        return String.format("%d %s %s %d %d", cityNum, cityCode, cityName, cityPopulation, cityElevation);
    }
}