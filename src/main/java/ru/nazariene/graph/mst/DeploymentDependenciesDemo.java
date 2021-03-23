package ru.nazariene.graph.mst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * We have a list of microservices and their dependencies
 * Find out which microservices must be deployed before a given one
 */
public class DeploymentDependenciesDemo {

    private Map<String, List<String>> dependenciesMap;

    public static void main(String[] args) {

        String serviceNameToDeploy = "A";
        DeploymentDependenciesDemo deploymentDependenciesDemo = new DeploymentDependenciesDemo();
        deploymentDependenciesDemo.performSearch(serviceNameToDeploy);

    }

    private void performSearch(String serviceName) {
        init();
        Set<String> visited = new HashSet<>();
        Queue<String> toLookAt = new ArrayDeque<>();
        //Uncomment me to switch to DFS
        //toLookAt = Collections.asLifoQueue((Deque) toLookAt);
        toLookAt.add(serviceName);
        while(!toLookAt.isEmpty()) {
            String curElem = toLookAt.remove();
            System.out.println("Current elem is " + curElem);
            List<String> serviceDependencies = dependenciesMap.get(curElem);
            System.out.println("Checking " + serviceDependencies);
            for (String child : serviceDependencies) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    toLookAt.add(child);
                    System.out.println("Adding " + child);
                }
                else {
                    System.out.println("Skipping " + child);
                }
            }
        }
    }

    private void init() {
        dependenciesMap = new HashMap<>();
        List<String> serviceDependencies = new ArrayList<>();
        serviceDependencies.add("B");
        serviceDependencies.add("D");
        serviceDependencies.add("E");
        dependenciesMap.put("A", serviceDependencies);

        serviceDependencies = new ArrayList<>();
        serviceDependencies.add("C");
        dependenciesMap.put("B", serviceDependencies);

        serviceDependencies = new ArrayList<>();
        serviceDependencies.add("E");
        dependenciesMap.put("C", serviceDependencies);

        serviceDependencies = new ArrayList<>();
        dependenciesMap.put("D", serviceDependencies);

        serviceDependencies = new ArrayList<>();
        serviceDependencies.add("F");
        dependenciesMap.put("E", serviceDependencies);

        serviceDependencies = new ArrayList<>();
        dependenciesMap.put("F", serviceDependencies);


        //Backward dependency (A is NOT dependent on this)
        serviceDependencies = new ArrayList<>();
        serviceDependencies.add("C");
        dependenciesMap.put("G", serviceDependencies);
    }
}
