# simple idea is if length of number is 5 then  _ _ _ _ _
# available choices for repeated even indices = [0,2,4,6,8] = 5
# available choices for odd indices i.e prime digits = [2,3,5,7] = 4
# then total numbers for length 5 can be  5*4*5*4*5
def powerOptimized(x: int, n: int):

    if n == 0:
        return 1
    elif n == 1:
        return x

    rem = n//2
    result = powerOptimized(x, rem)

    result *= result
    if n % 2 == 1:
        result *= x
    return result % (1000000007)


def countGoodNumbers(n: int) -> int:

    even_powers = (n//2 + n % 2)
    odd_powers = n//2
    return int(powerOptimized(5, even_powers)*powerOptimized(4, odd_powers)) % (1000000007)


if __name__ == "__main__":

    n = int(input())
    print(countGoodNumbers(n))
