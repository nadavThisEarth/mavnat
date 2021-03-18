#Following Code prints out the solution to CLRS problem 1-1

import math

### ----  CONSTANTS  ---- ###

ms = 10**-6   # microseconds constant (with relation to second)

times = [ 1, 60, 60*60, 24*(60*60), 30*(24*(60*60)), 365*(24*(60*60)), 100*(365*(24*(60*60)))] #time periods as multiples of 1 second (NOTICE - a year has 365 days which IS NOT 12*30)


### ----- FUNCTIONS ---- ###

def first_line():
    print('{:10s} {:25s} {:25s} {:25s} {:25s} {:25s} {:25s} {:25s}'.format(" " ,"1 second","1 minute","1 hour","1 day","1 month"," 1 year","1 century")) ## time periods
    
def lgn():  
    print("\n"+'{:10s}'.format("log(n)"),end =" ")
    for time in times:
        x = format((time/ms),".2e")
        print('{:25s}'.format("2** ( "+str(x) + " )"),end =" ")

def sqrt_n():
    print("\n\n"+'{:10s}'.format("sqrt(n)"),end =" ")
    for time in times:
        x = format(math.floor((time/ms)**2),".2e")
        print('{:25s}'.format(str(x)),end =" ")
def n():
    print("\n\n"+'{:10s}'.format("n"),end = " ")
    for time in times:
        x = format(math.floor((time/ms)),".2e")
        print('{:25s}'.format(str(x)),end = " ")
        
def nlogn():
    # using NEWTON - RAPHSON METHOD
    print("\n\n"+'{:10s}'.format("nlog(n)"),end = " ")
    sensitivity = 0
    func = lambda x: x * math.log(x,2) - time/ms
    deriv = lambda x: math.log(x,2) + 1/(math.log(2))
    for time in times:       
        x = 10 ** 2 #initial guess 
        y = func(x)
        while (abs(y) > sensitivity):
            x = x - func(x)/deriv(x)
            y = func(x)
        x = format(math.floor(x),".2e")
        print('{:25s}'.format(str(x)),end = " ")

def n_squared():
    print("\n\n"+'{:10s}'.format("n**2"),end = " ")
    for time in times:
        x = math.floor(math.sqrt(time/ms))
        print('{:25s}'.format(str(x)),end = " ")
        
def n_cubed():
    # using NEWTON - RAPHSON METHOD (because naive use of pow function causes floating-point representation issues)
    print("\n\n"+'{:10s}'.format("n**3"),end = " ")
    sensitivity = 1
    deriv = lambda x: 3*(x ** 2)
    func = lambda x: x ** 3 - time/ms
    for time in times:
        x = 10 ** 5 #initial guess 
        y = func(x)
        while (abs(y) > sensitivity):
            x = x - func(x)/deriv(x)
            y = func(x)
        x = math.floor(x)
        print('{:25s}'.format(str(x)),end = " ")

def two_power_n():
    print("\n\n"+'{:10s}'.format("2**n"),end = " ")
    for time in times:
        x = math.floor(math.log((time/ms),2))
        print('{:25s}'.format(str(x)),end = " ")

def n_fact():
    print("\n\n"+'{:10s}'.format("n!"),end = " ")
    for time in times:
        x = 1
        count = 1
        while(x <= time/ms):
            count += 1
            x *= count
        count -= 1 #reducing count by 1 to get last value smaller than a bound
        print('{:25s}'.format(str(count)),end = " ")

    
first_line()        
lgn()
sqrt_n()
n()
nlogn()
n_squared()
n_cubed()
two_power_n()
n_fact()
