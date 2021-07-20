
def isPalindromo(value):
    return value == value[::-1]

def retorno(var):
    if isPalindromo(var):
        print('La palabra SI es un palindromo')
    else:
        print('La palabra NO es un palindromo')

if __name__ == '__main__':
    print('Ingrese una palabra:')
    var = raw_input()
    retorno(var)
    