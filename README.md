# mavnat
code solutions for tasks in "introduction to data structures and algorithms"


## ex 1-1.py details
   This file outputs the solution for CLRS problem 1-1
   ###### important notifications
   - **WIDEN YOUR OUTPUT CONSOLE** as much as possible to allow proper display of the data
   - **a year** is calculated as **365 days** which is **doesn't equal** 12 months * 60 days ( =360 days)
   - **nlogn()** uses _Newton-Raphson Method_ to quicken time complexity
   - **n_cubed()** uses _Newton-Raphson Method_   **instead of pow function** , which causes inaccuracies due to floating-point arithmetic 
### n_cubed() - floating-point arithmetic issue explanation:
 **math.pow** (10 ** 6, 1 / 3) gives **99.99999999999997** whereas **math.pow** (60 *(10 ** 6), 1 / 3) gives **391.4867641168862** .   
   Ceiling 99.99999999999997 gives a **correct** answer (100)  for time period of **1 second** while 
   ceiling 391.4867641168862 gives a **wrong** answer (392) instead of 391 for time period of **1 minute**.
   
   In the same manner, we would get **one correct answer and one wrong answer** for the above time periods when **flooring** the **math.pow** result.
   That is why **_Newton-Raphson method_** is more accurate for this particualr problem.
