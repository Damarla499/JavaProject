package com.cooksys.ftd.assignments.collections;

import java.util.Map;
import java.util.Set;

import com.cooksys.ftd.assignments.collections.model.Employee;
import com.cooksys.ftd.assignments.collections.model.Manager;
import com.cooksys.ftd.assignments.collections.model.OrgChart;
import com.cooksys.ftd.assignments.collections.model.Worker;

public class Main {

    /**
     * TODO [OPTIONAL]: Students may use this main method to manually test their code. They can instantiate Employees
     *  and an OrgChart here and test that the various methods they've implemented work as expected. This class and
     *  method are purely for scratch work, and will not be graded.
     */
    public static void main(String[] args) {
    	Manager managerResponse;
    	Manager managertest1= new Manager("Manager name 1");
    	System.out.println("Manager name:"+managertest1.getName());
    	System.out.println("Has Manager:"+managertest1.hasManager());
    	Manager managertest2= new Manager("Manager name 2", managertest1);
    	System.out.println("Manager name 2:"+managertest2.getName());
    	System.out.println("Has Manager:"+managertest2.hasManager());
    	managerResponse = managertest2.getManager();
    	System.out.println("Manager name in response:"+managerResponse.getName());
    	System.out.println("Manager chain of command");
    	Manager managertest3 = new Manager("Manager name 3", managertest2);
    	for(Manager test : managertest3.getChainOfCommand()) {
    		System.out.println(test.getName());
    	}
    	System.out.println("--------------------------------------------");
    	Manager workerResponse;
    	Worker workertest1= new Worker("Worker name 1", managertest1);
    	System.out.println("Worker name:"+workertest1.getName());
    	System.out.println("Has Manager:"+workertest1.hasManager());
    	Worker workertest2= new Worker("Worker name 2", managertest2);
    	System.out.println("Worker name 2:"+workertest2.getName());
    	System.out.println("Has Manager:"+workertest2.hasManager());
    	workerResponse = workertest2.getManager();
    	System.out.println("Manager name in response:"+workerResponse.getName());
    	System.out.println("Worker chain of command");
    	Worker workertest3 = new Worker("Worker name 3", managertest2);
    	for(Manager test : workertest3.getChainOfCommand()) {
    		System.out.println(test.getName());
    	}
    	System.out.println("--------------------------------------------");
    	OrgChart orgchart = new OrgChart();
    	System.out.println(orgchart.addEmployee(workertest1));
    	System.out.println(orgchart.addEmployee(workertest2));
    	System.out.println(orgchart.addEmployee(workertest3));
    	System.out.println(orgchart.addEmployee(managertest1));
    	System.out.println(orgchart.addEmployee(managertest2));
    	System.out.println(orgchart.addEmployee(managertest3));
    	System.out.println("Has employee:"+ orgchart.hasEmployee(workertest2));
    	System.out.println("All employees");
    	Set<Employee> allEmployees = orgchart.getAllEmployees();
    	for(Employee test : allEmployees) {
    		System.out.println(test.getName());
    	}
    	System.out.println("All Managers");
    	Set<Manager> allManagers = orgchart.getAllManagers();
    	for(Manager test : allManagers) {
    		System.out.println(test.getName());
    	}
    	System.out.println("Get direct subordinates for managertest1");
    	Set<Employee> allDirectSubs = orgchart.getDirectSubordinates(managertest1);
    	for(Employee test : allDirectSubs) {
    		System.out.println(test.getName());
    	}
    	System.out.println("Get Full hierarchy");
    	Map<Manager, Set<Employee>> fullHierarchy = orgchart.getFullHierarchy();
    	Set<Employee> emps;
    	for (Manager mgr : fullHierarchy.keySet())  
        { 
            // search  for value 
    		System.out.println(mgr.getName());
            emps = fullHierarchy.get(mgr);
            for(Employee test: emps) {
        		System.out.println(test.getName());
        	} 
            System.out.println();
        }
    	
    }
}
