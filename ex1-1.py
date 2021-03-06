#Following Code prints out the solution to CLRS problem 1-1

import math

### ----  CONSTANTS  ---- ###

micros = 10 ** -6   # microseconds constant (with relation to second)

times = [ 1, 60, 60*60, 24*(60*60), 30*(24*(60*60)), 365*(24*(60*60)), 100*(365*(24*(60*60)))] #time periods as multiples of 1 second
##  NOTICE - a year is calculated as 365 days which IS NOT 12 months * 30 days


### ----- FUNCTIONS ---- ###

def first_line():
    print('{:10s} {:25s} {:25s} {:25s} {:25s} {:25s} {:25s} {:25s}'.format(" ","1 second","1 minute","1 hour","1 day","1 month","1 year","1 century")) ## time periods
    
def lgn():  
    print("\n" + '{:10s}'.format("log(n)"), end = " ")
    for time in times:
        x = format((time/micros), ".3e")
        print('{:25s}'.format("2 ** ( " + str(x) + " )"), end = " ")

def sqrt_n():
    print("\n\n" + '{:10s}'.format("sqrt(n)"), end = " ")
    for time in times:
        x = format(math.floor( (time/micros)**2 ), ".3e")
        print('{:25s}'.format(str(x)), end = " ")
def n():
    print("\n\n" + '{:10s}'.format("n"), end = " ")
    for time in times:
        x = format(math.floor((time/micros)), ".2e")
        print('{:25s}'.format(str(x)), end = " ")
        
def nlogn():
    # using NEWTON - RAPHSON METHOD
    print("\n\n"+'{:10s}'.format("nlog(n)"), end = " ")
    func = lambda x: x * math.log(x,2) - time/micros     #the function whose root we wish to find
    deriv = lambda x: math.log(x,2) + 1/(math.log(2)) # derivative of the above function
    for time in times:
        x = newton_raphson(func, deriv, 0 , 10 ** 2)
        x = format(math.floor(x), ".2e") 
        print('{:25s}'.format(str(x)), end = " ")

def n_squared():
    print("\n\n"+'{:10s}'.format("n ** 2"), end = " ")
    for time in times:
        x = math.floor(math.sqrt(time/micros))
        print('{:25s}'.format(str(x)),end = " ")
        
def n_cubed():
    # using NEWTON - RAPHSON METHOD (since naive use of pow function causes floating-point representation issues)
    print("\n\n"+'{:10s}'.format("n ** 3"), end = " ")
    func = lambda x: x ** 3 - time/micros   #the function whose root we wish to find
    deriv = lambda x: 3 *(x ** 2)           # derivative of the above function
    for time in times: 
        x = newton_raphson(func, deriv, 1 , 10 ** 5)
        print('{:25s}'.format(str(x)), end = " ")

def two_power_n():
    print("\n\n"+'{:10s}'.format("2 ** n"), end = " ")
    for time in times:
        x = math.floor(math.log((time/micros),2))
        print('{:25s}'.format(str(x)), end = " ")

def n_fact():
    print("\n\n"+'{:10s}'.format("n!"), end = " ")
    for time in times:
        x = 1
        count = 1
        while(x <= time/micros):
            count += 1
            x *= count
        count -= 1 #reducing count by 1 to get last value smaller than a bound
        print('{:25s}'.format(str(count)), end = " ")

def newton_raphson(func, deriv, sensitivity , x0): #x0 - initial guess
    x = x0
    y = func(x)
    while (abs(y) > sensitivity):
            x = x - func(x)/deriv(x)
            y = func(x)
    return math.floor(x) # achieving natural number by flooring
    

    
first_line()        
lgn()
sqrt_n()
n()
nlogn()
n_squared()
n_cubed()
two_power_n()
n_fact()
