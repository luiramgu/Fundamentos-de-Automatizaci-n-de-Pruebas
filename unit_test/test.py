import unittest
from main import isPalindromo
import TestRunner

class TestPalindromo(unittest.TestCase):

    def test_isPalindromo(self):
        testPalabra = 'CACHETETEHCAC'
        self.assertTrue(isPalindromo(testPalabra))

    def test_isNotPalindromo(self):
        testPalabra = 'NOTPAL'
        self.assertFalse(isPalindromo(testPalabra))

    def test_badInput(self):
        s = 1
        with self.assertRaises(TypeError):
            isPalindromo(s)

if __name__ == '__main__':
    # unittest.main()
    TestRunner.main()