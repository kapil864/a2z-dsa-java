# generate all binary string of size k without consecutive 1's

# intuition is that we can add 1 if only if string is not ending with 1.
# i.e for k =1, string ending with 0 = 1, string ending with 1 = 1
#     for k =2, string ending with 0 = (string ending with 0 +  string ending with 1) in previous case
#               string ending with 1 = (string ending with 0) in previous case
def generate_strings( k : int):
    if k == 1:
        return ['0', '1']
    
    binary_strings = generate_strings(k-1)
    ans = []
    for str in binary_strings:
        ans.append(str + '0')
        if str.endswith('0'):
            ans.append(str+'1')
    return ans

if __name__ == "__main__":

    n = int(input())
    print(generate_strings(n))