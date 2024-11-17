
# TC = (N)
# SC = O(N) -> stack space
def myPowBrute(x: float, n: int) -> float:
    if abs(n) == 0:
        return 1
    elif abs(n) == 1:
        return 1/x if n < 0 else x
    if n > 0:
        result = x * myPowBrute(x, n-1)
    else:
        result = myPowBrute(x, n+1)/x
    return result



# Tc = O(logN)
# SC = O(logN) --> stack space
def powerOptimized(x: int, n: int):

    if abs(n) == 0:
        return 1
    elif abs(n) == 1:
        return 1/x if n < 0 else x

    rem = n//2
    result = powerOptimized(x, rem)

    result *= result
    if n % 2 == 1:
        result *= x
    elif n % 2 == -1:
        result /= x
    return result


if __name__ == "__main__":

    [x, n] = list(map(int, input().split(' ')))
    print(powerOptimized(x, n))
