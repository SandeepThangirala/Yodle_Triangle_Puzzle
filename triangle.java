package com.problems;


import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * @author Sandeep Thangirala
 *
 *	Triangle
	By starting at the top of the triangle and moving to adjacent numbers on the row below, the maximum total from top to bottom is 27.

Initial:
	        5
	      9  6
	    4   6  8
	  0   7  1   5

Loop One:
	        5
	      9  6
	    11   6  8    // 4+0 or 4+7 - Which ever is greater take that value and replace 4
	  0   7  1   5

	        5
	      9  6
	    11   13  8    // 6+7 or 6+1 - Which ever is greater take that value and replace 6
	  0   7  1   5	  
	      
	        5
	      9  6
	    11   13  13    // 8+1 or 8+5 - Which ever is greater take that value and replace 8
	  0   7  1   5

Loop Two:
          5
	      22  6        // 9+11 or 9+13 - Which ever is greater take that value and replace 9
	    11   13  13    
	  0   7  1   5	

          5
	      22  19        // 6+11 or 6+13 - Which ever is greater take that value and replace 6
	    11   13  13    
	  0   7  1   5	

Loop Three:
          5         // 5+22 or 5+19 - Which ever is greater take that value and replace 5
	      22  19        
	    11   13  13    
	  0   7  1   5
	  
	  Answer is 27! 
	I.e. 5 + 9 + 6 + 7 = 27.


 */
public class triangle {
	private static Map<Integer,List<Integer>> triangle = new HashMap<Integer,List<Integer>>();
	public static void main(String args[])
	{
		try
		{
			File file =new File("C:/triangle.txt"); //Change this to wherever the text file is.
			if(file.exists())
			{
				String currentline;
				int linesCount=0;
				FileReader f = new FileReader(file);
				LineNumberReader linereader = new LineNumberReader(f);
				List<List<Integer>> tuples = new ArrayList<List<Integer>>();
				while ((currentline = linereader.readLine()) != null) {			       
					String[] stringArray = currentline.split(" ");
					int[] intArray = new int[stringArray.length];
					for (int i = 0; i < stringArray.length; i++) {
						String numberAsString = stringArray[i];
						intArray[i] = Integer.parseInt(numberAsString);
					}
					tuples.add(IntStream.of(intArray).boxed().collect(Collectors.toList()));
					linesCount++;
				}

				int counter=0;
				for(List<Integer> tuple : tuples)
				{
					triangle.put(counter++,tuple);
				}

				int sum = 0;
				if(triangle == null || triangle.isEmpty())
					sum=0;
				int size = triangle.size();
				if(size == 1)
					sum=triangle.get(0).get(0);
				int i=size-2,tmp,tempindex,tempindexnext;
				while(i>=0)
				{
					List<Integer> current_row = new ArrayList<Integer>();
					current_row = triangle.get(i);
					for(int index=0; index<current_row.size(); index++)
					{
						tmp = current_row.get(index);
						tempindex = tmp+triangle.get(i+1).get(index);
						tempindexnext = tmp+triangle.get(i+1).get(index+1);
						if(tempindex > tempindexnext)
							tempindexnext = tempindex;
						current_row.set(index,tempindexnext);
					}
					triangle.put(i,current_row);
					current_row = null;
					i--;
				}
				sum = triangle.get(0).get(0);
				//print
				for(Integer key : triangle.keySet())
				{
					System.out.println(triangle.get(key));
				}
				System.out.println("Final Answer is: "+sum);
			}
		}
		catch(Exception e){}
		finally{System.out.println("Done");}

	}
}
