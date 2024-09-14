# The intution is if there is an outer "(" or outer ")" then the balace should be zero
# we increase the balace when we encounter a "(" and decrease balance when ")" is encountered
def remove_outer_paranthesis(string : str):
    n = len(string)
    ans = ""
    balance = 0
    for i in range(n):
        if string[i] == "(":
            if balance > 0:
                ans += string[i]
            balance += 1
        if string[i] == ")":
            balance -= 1
            if balance > 0:
                ans += string[i]
    return ans



if __name__ == "__main__":

    string = input()
    print(remove_outer_paranthesis(string))