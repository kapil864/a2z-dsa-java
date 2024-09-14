
def reverse_words(s : str):
    words_list = s.split(" ")
    words_list = [ words for words in words_list if words != ""]
    words_list.reverse()
    return " ".join(words_list)


def reverse_words2(s : str):
    ans = ""
    temp = ""
    for ch in s:
        if ch != " ":
            temp +=ch
        else:
            if temp != "":
                ans = temp+" "+ans
                temp = ""
    if temp != "":
         ans = temp+" "+ans
    return ans[:-1]

if __name__ == "__main__":

    string = input()
    print(reverse_words(string))
    print(reverse_words2(string))