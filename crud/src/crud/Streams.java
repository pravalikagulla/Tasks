package crud;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args)
	{
		//counting logic using streams
		List<String> words = Arrays.asList("apple","banana");
		Long count = words.stream().collect(Collectors.counting());
		System.out.println(count);
		//summary of count,max,min,sum of numbers
		List<Integer> summary = Arrays.asList(1,4,5,6,8);
		IntSummaryStatistics total = summary.stream().collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(total.getSum()+","+total.getAverage()+","+total.getCount());
		//String:: length
		//collectors.mapping(words1 ->words1.substring(0,3))
		//Collectors.mapping(words1 -> words1.substring +"("+words1.length+")",
		List<String> words1 = Arrays.asList("apple","orange");
		List<String> upperCaseWords = words1.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
		System.out.println(upperCaseWords);
		
		List<String> fruits = Arrays.asList("apple","banana","apple");
		Map<Integer,Long> groupelements = fruits.stream().collect(Collectors.groupingBy((String:: length),Collectors.counting()));
		System.out.println(groupelements);
		
		
		
	}

}
