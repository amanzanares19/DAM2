def esPalindrom(num):
    """
    Given a number, return true if is palindrome, otherwise false.

    :param num: int
    :return: bool

    >>> esPalindrom(81)
    False

    >>> esPalindrom(5225)
    True

    >>> esPalindrom(133)
    False
    
    """
    return str(num) == str(num)[::-1]



def esPrimer(num):
    """
    Given a number, return true if is prime, otherwise false.

    :param num: int
    :return: bool

    >>> esPrimer(5)
    True

    >>> esPrimer(13)
    True

    >>> esPrimer(24)
    False

    """
    if num < 1:
        return False
    
    for i in range(2,int(num/2)+1):
        if (num % i) == 0:        
            return False
    return True


def writeFile(f, palindromos, primos):
    
    f.write("S'han trobat " + str(len(palindromos)) + " palindroms: " + str(palindromos))
    f.write("\nS'han trobat " + str(len(primos)) + " primers: " + str(primos))

#Pedir parámetros
entrada = input("Nombre del fichero de entrada: ")
salida = input("Nombre del fichero de salida: ")

fichero = open(entrada, "r")

arrayPrimos = []
arrayPalindromos = []

for line in fichero:
    line = line.replace("\n", "")
    for num in line.split(" "):

        if esPalindrom(num):
            arrayPalindromos.append(num) 
        if esPrimer(int(num)):
            arrayPrimos.append(num)

fichero.close()

outputFile = open(salida, 'w')

writeFile(outputFile, arrayPalindromos, arrayPrimos)
outputFile.close()


if __name__ == '__main__':
    import doctest
    doctest.testmod()