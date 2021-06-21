# mavnat
code solutions for tasks in "introduction to data structures and algorithms"


## ex 1-1.py details
   This file outputs the solution for CLRS problem 1-1
   
   - **WIDEN YOUR OUTPUT CONSOLE** as much as possible to allow proper display of the data
   - **a year** is calculated as **365 days** which **doesn't equal** 12 months * 60 days ( =360 days)
   - **nlogn()** uses _Newton-Raphson Method_ to quicken time complexity
   - **n_cubed()** uses _Newton-Raphson Method_   **instead of pow function** , which causes inaccuracies due to floating-point arithmetic 
### n_cubed() - floating-point arithmetic issue explanation:
 **math.pow** (10 ** 6, 1 / 3) gives **99.99999999999997** whereas **math.pow** (60 *(10 ** 6), 1 / 3) gives **391.4867641168862** .   
   Ceiling 99.99999999999997 gives a **correct** answer (100)  for time period of **1 second** while 
   ceiling 391.4867641168862 gives a **wrong** answer (392) instead of 391 for time period of **1 minute**.
   
   In the same manner, we would get **one correct answer and one wrong answer** for the above time periods when **flooring** the **math.pow** result.
   That is why **_Newton-Raphson method_** is more accurate for this particualr problem.
   
   ## UniquenessComparison details
   This folder contains Java code that **compares run-times of** 
  **different approaches that solve the following problem**:
         
   #### Given a list of integers , write an algorithm that outputs the number of unique elements in input
                         
   ### Approaches within the code include:
   - **originalAlg** - _the original algorithm_ (code solution to a previous Open Univeristy assignment)
   - **ByInsertionSort** - _implementation that utilizes **Insertion Sort**_
   - **ByMergeSort** - _implementation that utilizes **Merge Sort**_
   - **ByCountingsort** - _implementation that utilizes **Counting Sort**_
   - **ByHashTable**- _implementation that utilizes **HashTable (Java.util HashMap)**_
   ### Code Flow (main procedure):
   - First , a user input sets the list length (labeled **N**) .
   - Then , **_randomFill_** creates a list with **N** randomly generated integers 
   whose values vary between 1 - 100 (maximum value is determined by  static variable **RANGE**) 
   - Static counters for number of assigments (labeled **_assigns_**) and number of comparisons (labeled **_comps_**)
   accompany each approach of the solution , and give a numerical measure to the difference of time complexity between approaches
   - In case of need to print the actual number of unique integers in the list , simply **uncomment the last line** of each approach
