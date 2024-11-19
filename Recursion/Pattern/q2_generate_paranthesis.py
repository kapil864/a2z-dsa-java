from typing import List


def helper(opening: int, closing: int, output : str, ans : List[str]):
    if closing == 0 and opening == 0:
        ans.append(output)
        return
    
    if opening:
        output1 = output + '('
        helper(opening-1, closing, output1, ans)
    
    if closing > opening:
        output2 = output +')'
        helper(opening, closing-1, output2, ans)

def generateParenthesis( n: int) -> List[str]:
    opening = n
    closing = n
    output = ''
    ans = []
    helper(opening, closing, output, ans)
    return ans


if __name__ == "__main__":

    n = int(input())
    print(generateParenthesis(n))