# Palindrome Permutation: Given a string, write a function to check if it is a
# permutation of a palin­ drome. A palindrome is a word or phrase that is the
# same forwards and backwards. A permutation is a rearrangement of letters.
# The palindrome does not need to be limited to just dictionary words.
# EXAMPLE
# Input: Tact Coa
# Output: True (permutations: "taco cat", "atco eta", etc.)

import unittest
from collections import Counter


def is_palindrome(s):
    c = Counter(s.replace(' ', '').lower())
    for k, v in c.items():
        c[k] = v % 2

    r = {k: v for k, v in c.items() if v > 0}
    if len(r) == 0 or len(r) == 1:
        return True
    else:
        return False


class Test(unittest.TestCase):
    test_cases = [
        ("aba", True),
        ("aab", True),
        ("abba", True),
        ("aabb", True),
        ("a-bba", True),
        ("Tact Coa", True),
        ("jhsabckuj ahjsbckj", True),
        ("Able was I ere I saw Elba", True),
        ("So patient a nurse to nurse a patient so", False),
        ("Random Words", False),
        ("Not a Palindrome", False),
        ("no x in nixon", True),
        ("azAZ", True),
    ]
    testable_functions = [is_palindrome]

    def test_pal_perm(self):
        for f in self.testable_functions:
            for [test_string, expected] in self.test_cases:
                assert f(test_string) == expected


if __name__ == "__main__":
    unittest.main()