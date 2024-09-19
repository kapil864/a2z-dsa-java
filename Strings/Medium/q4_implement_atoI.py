def myAtoi(s: str):
    num = "0123456789"
    result = ""
    for ch in s:

        # remove leading space
        if ch == " " and len(result) == 0:
            continue
        # check for staring 
        elif ch != " " and (ch in '+-' or ch in num) and len(result) == 0:
            result += ch
        elif ch in num:
            result += ch
        else:
            break

    if result == "" or result in "+-":
        return 0
    else:
        if int(result) < -(2**31):
            return -(2**31)
        elif int(result) > (2**31 - 1):
            return (2**31 - 1)
        else:
            return int(result)


            


if __name__ == "__main__":
    string = input()
    print(myAtoi(string))