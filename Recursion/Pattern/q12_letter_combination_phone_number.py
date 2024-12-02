from typing import List

no_letter_map = {
    '2': 'abc',
    '3': 'def',
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz'
}


def letterCombinations(digits: str) -> List[str]:
    if len(digits) == 0:
        return []
    
    if len(digits) == 1:
        return [ ch for ch in no_letter_map[digits[0]]]
    
    digit = digits[0]
    output = letterCombinations(digits[1:])
    new_combination = []
    for i in range(len(output)):
        for ch in no_letter_map[digit]:
            new_combination.append(ch + output[i])
    return new_combination

if __name__ == "__main__":

    s = input()
    print(letterCombinations(s))
