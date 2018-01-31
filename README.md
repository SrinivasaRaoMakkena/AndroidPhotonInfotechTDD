# AndroidPhotonInfotechTDD
Android project to find out the shortest path in matrix from  left to right in 2-D matrix with Graphical User Interface(GUI) to enter matrix elements with the help of Test Driven Development(TDD) approach. (Assuming First and Last rows are also adjacent)


Test Cases:
-----------------------
After you complete the code, please check it for the below inputs. we need correct output for all the cases. You can include them as part of your test cases. 

Sample 1: (6X5 matrix normal flow)

Input:

3 4 1 2 8 6

6 1 8 2 7 4

5 9 3 9 9 5

8 4 1 3 2 6

3 7 2 8 6 4

Solution:

![alt text](https://github.com/SrinivasaRaoMakkena/AndroidPhotonInfotechTDD/blob/master/ShortestPathPhotonTDD.PNG)
 

Output:

Yes

16

[1 2 3 4 4 5] (1st row, 2nd row, 3rd row,4th row, 4th row,5th row)

 

Sample 2: (6X5 matrix normal flow)

Input:

3 4 1 2 8 6

6 1 8 2 7 4

5 9 3 9 9 5

8 4 1 3 2 6

3 7 2 1 2 3

 

Output:

Yes

11

[1 2 1 5 4 5]

 

Sample 3: (5X3 matrix with no path <50)

Input:

19 10 19 10 19

21 23 20 19 12

20 12 20 11 10

 

Output:

No

48

[1 1 1]

 

Sample 4: (1X5 matrix)

Input:

5 8 5 3 5

 

Output:

Yes

26

[1 1 1 1 1]

 

Sample 5: (5X1 matrix)

Input:

5

8

5

3

5

 

Output:

Yes

3

[4]

 

Sample 6: (Non numeric input, Optional)

Input:

5 4 H

8 M 7

5 7 5

 

Output:

Invalid matrix

 

Sample 7: (No input - Optional)

Input:

 

Output:

Invalid matrix

 

Sample 8: (Starting with >50)

Input:

69 10 19 10 19

51 23 20 19 12

60 12 20 11 10

 

Output:

No

0

[]

 

Sample 9: (One value >50)

Input:

60 3 3 6

6 3 7 9

5 6 8 3

 

Output:

Yes

14

[3,2 1 3]

 

Sample 10: (Negative values)

Input:

6,3,-5,9

-5,2,4,10

3,-2,6,10

6,-1,-2,10

 

Output:

Yes

0

[2,3 4 1]

 

 

Sample 11: Complete path vs. lower cost incomplete path

 

Input:

 

51 51
0 51
51 51
5 5

Expected output:

 

Yes
10
4 4

Sample 12: Longer incomplete path vs. shorter lower cost incomplete path

 

Input:

 

51 51 51
0 51 51
51 51 51
5 5 51

Expected output:

 

No

10
4 4

Sample 13: Large number of columns

 

Input:


1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2

Expected output:   

 

Yes
20
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
