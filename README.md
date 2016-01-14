# Yodle_Triangle_Puzzle
This repository has the solution to the problem mentioned in the link: http://www.yodlecareers.com/puzzles/triangle.html

```
By starting at the bottom of the triangle and moving to up the rows, the maximum total from top to bottom is 27.
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
	
```
