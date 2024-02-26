import pyperclip, sys

def changeWord(word):
    for c in word:
        word = word.replace(c, "*")
        print(word)
    return word

def forbiddenWords(file):
    copiedText = pyperclip.waitForPaste()
    
    fichero = open(file, "r")

    lista = []
    for word in fichero: 

        word = word.replace("\n", "")
        lista.append(word)
        if word in copiedText.lower():

            sizeWord = len(word)
            pos = copiedText.lower().index(word)

            copiedText = copiedText.replace(copiedText[pos:(pos+sizeWord)],changeWord(copiedText[pos:(pos+sizeWord)]))    
    print(copiedText)

pyperclip.copy("")
forbiddenWords(sys.argv[1])