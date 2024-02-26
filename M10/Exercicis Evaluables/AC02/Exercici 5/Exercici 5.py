import pyperclip, sys, unidecode

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
        if word in unidecode.unidecode(copiedText.lower()):

            sizeWord = len(word)
            decodedText = unidecode.unidecode(copiedText.lower())
            pos = decodedText.index(word)
            copiedText = copiedText.replace(copiedText[pos:(pos+sizeWord)],changeWord(copiedText[pos:(pos+sizeWord)]))    

pyperclip.copy("")
forbiddenWords(sys.argv[1])
