import java.io.*;
import java.util.Scanner;
/**
 * An implentation of the ADT Directed Graph using an adjacency matrix.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class Digraph
{
    private int[][] weights;
    private City[] cities;
    private final int numOfCities = 20;     //number of cities in city.dat
    
    public Digraph() throws IOException
    {
        weights = new int[numOfCities][numOfCities];        //adjacency matrix
        cities = new City[numOfCities];     //array of cities
        
        File cityInfo = new File("city.dat");
        File roadInfo = new File("road.dat");
        Scanner cityParser = new Scanner(cityInfo);
        Scanner roadParser = new Scanner(roadInfo);

        for (int i=0; i<numOfCities; i++)       //read through city.dat and create City objects from the data in each line
        {
            int cityNum = cityParser.nextInt();
            String cityCode = cityParser.next();
            String cityName = cityParser.next();
            if (!cityParser.hasNextInt())
            {
                cityName = cityName + " " + cityParser.next();
            }
            int cityPopulation = cityParser.nextInt();
            int cityElevation = cityParser.nextInt();
            cities[i] = new City(cityNum, cityCode, cityName, cityPopulation, cityElevation);       //create new city with data
        }
        
        while (roadParser.hasNextLine())        //read through road.dat and update distances
        {
            int fromCity = roadParser.nextInt();
            int toCity = roadParser.nextInt();
            int distance = roadParser.nextInt();
            weights[fromCity-1][toCity-1] = distance;       //index = cityNum - 1
        }
    }
    
    /**
     * Returns the City object with the given city code.
     * @return  The City object with the given city code.
     */
    public City getCity(String cityCode)
    {
        City target = null;
        for (int i=0; i<cities.length; i++)
        {
            if (cities[i].getCityCode().contains(cityCode))
            {
                target = cities[i];
            }
        }
        return target;
    }
    
    /**
     * Inserts a road from one city to another with the given distance between them.
     * @param fromCity  The origin vertex for the edge.
     * @param toCity  The end vertex for the edge.
     */
    public void insertRoad(City fromCity, City toCity, int distance)
    {
        weights[fromCity.getCityNum()-1][toCity.getCityNum()-1] = distance;
    }
    
    /**
     * Removes a road from one city to another.
     * @param fromCity  The origin vertex for the edge.
     * @param toCity  The end vertex for the edge.
     */
    public boolean removeRoad(City fromCity, City toCity)
    {
        int weight = weights[fromCity.getCityNum()-1][toCity.getCityNum()-1];
        if (weight != 0)
        {
            weights[fromCity.getCityNum()-1][toCity.getCityNum()-1] = 0;
            return true;
        }
        else
        {
            return false;
        }
    }
    
}