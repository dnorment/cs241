import java.io.*;
import java.util.Scanner;
/**
 * An implementation of the ADT Directed Graph using an adjacency matrix.
 *
 * @author Daniel J. Norment
 * @version 1.1
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
     * Returns the City object with the given city number.
     * @return  The City object with the given city number.
     */
    public City getCity(int cityNum)
    {
        City target = null;
        for (int i=0; i<cities.length; i++)
        {
            if (cities[i].getCityNum() == cityNum)
            {
                target = cities[i];
            }
        }
        return target;
    }    
    
    /**
     * Finds the shortest path from one city to another.
     * @param fromCity  The source vertex for the search.
     * @param toCity  The destination vertex for the search.
     * @return  The TableNode with the destination city. The city contains the path and distance.
     */
    public TableNode getShortestPath(City fromCity, City toCity)
    {
        PriorityQueueSingleLinked<TableNode> priQueue = new PriorityQueueSingleLinked<TableNode>();
        //step 1, 2 - set distance estimates to infinity (0 for source), mark all nodes unvisited and set source as current
        for (int i=0; i<cities.length; i++)
        {
           cities[i].setDistEstimate(Integer.MAX_VALUE);
           cities[i].setVisited(false);
        }
        fromCity.setPath(fromCity.getCityCode());
        fromCity.setDistEstimate(0);
        
        TableNode front = new TableNode(fromCity, 0, null);
        priQueue.add(front, 0);
        
        while (!priQueue.isEmpty() && front.getLeft() != toCity)       //step 3 - consider all unvisited neighbors and calculate their distance from source, then relax
        {
            front = priQueue.remove();
            City frontCity = front.getLeft();
            if (!frontCity.visited())
            {
                int i = frontCity.getCityNum() - 1;
                for (int j=0; j<weights.length; j++)
                {
                    if (weights[i][j] != 0) //if neighbor and not visited
                    {
                        City neighbor = getCity(j+1);

                        if (neighbor.getDistEstimate() > frontCity.getDistEstimate() + weights[i][j])
                        {
                            neighbor.setDistEstimate(frontCity.getDistEstimate() + weights[i][j]);  //relax edge
                            neighbor.setPath(frontCity.getPath() + ", " + neighbor.getCityCode());  //add neighbor to each path
                        }
                        priQueue.add(new TableNode(neighbor, neighbor.getDistEstimate(), frontCity), neighbor.getDistEstimate());
                    }
                }
            }
            frontCity.setVisited(true);     //step 4 - when done considering all neighbors, mark current node as visited
            //step 5 - set unvisited node with smallest distance from source as next current and repeat from step 3
        }
        //here, front is either target or last (both are destination)
        priQueue.clear();
        return front;
    }
    
    /**
     * Returns the distance from one city to another (single edge).
     * @param fromCity  The origin vertex for the edge.
     * @param toCity  The end vertex for the edge.
     * @return  The distance along the given road.
     */
    public int getDistance(City fromCity, City toCity)
    {
        return weights[fromCity.getCityNum()-1][toCity.getCityNum()-1];
    }
    
    /**
     * Inserts a road from one city to another with the given distance between them.
     * @param fromCity  The origin vertex for the edge.
     * @param toCity  The end vertex for the edge.
     */
    public void setDistance(City fromCity, City toCity, int distance)
    {
        weights[fromCity.getCityNum()-1][toCity.getCityNum()-1] = distance;
    }
    
    /**
     * Removes a road from one city to another.
     * @param fromCity  The origin vertex for the edge.
     * @param toCity  The end vertex for the edge.
     * @return  True if the road was removed, false if the road doesn't exist.
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