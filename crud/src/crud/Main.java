package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args)
	{
		List<String> cities1 = new ArrayList<String>();
		cities1.add("hyderabad");
		cities1.add("mumbai");
	Employee e1 = new Employee(1,"pravalika",cities1);
	
	List<String> cities2 = new ArrayList<String>();
	cities2.add("chennai");
	cities2.add("banglore");
	cities2.add("hyderabad");
	Employee e2 = new Employee(2,"radhakrishna",cities2);
	
	List<String> cities3 = new ArrayList<String>();
	cities3.add("chennai");
	Employee e3 = new Employee(3,"ramya",cities3);
	
	
	List<Employee> employeesList = new ArrayList<Employee>();
	employeesList.add(e1);
	employeesList.add(e2);
	employeesList.add(e3);
	System.out.println(employeesList);
	
	 List<Integer> ids = employeesList.stream().map(emp ->emp.getId()).collect(Collectors.toList());
	 System.out.println(ids);
	 List<String> names = employeesList.stream().map(emp ->emp.getName()).collect(Collectors.toList());
	 System.out.println(names);
	 Set<List<String>> citiesworked = employeesList.stream().map(emp ->emp.getCities()).collect(Collectors.toSet());
     System.out.println(citiesworked);
     Set<String> citiesWork = employeesList.stream().flatMap(emp ->emp.getCities().stream()).collect(Collectors.toSet());
     System.out.println(citiesWork);
     Long count = employeesList.stream().collect(Collectors.counting());
     System.out.println(count);
     Set<String> empcities = employeesList.stream().flatMap(emp -> emp.getCities().stream()).map(city ->city.substring(0, 3)).collect(Collectors.toSet());
     System.out.println(empcities);
   Map<Integer,Long> grouping = employeesList.stream().collect(Collectors.groupingBy(emp -> emp.getName().length(),Collectors.counting()));
  System.out.println(grouping);


   

}

}
