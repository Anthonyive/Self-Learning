# One Away: There are three types of edits that can be performed on strings:
# insert a character, remove a character, or replace a character. Given two
# strings, write a function to check if they are one edit (or zero edits) away.
# EXAMPLE
# pale, ple -> true
# pales, pale -> true
# pale, bale -> true
# pale, bake -> false

import unittest
import time


def one_away(s1, s2):
    if len(s1) == len(s2):
        return one_away_replace(s1, s2)
    elif len(s1) + 1 == len(s2):
        return one_away_insert(s1, s2)
    elif len(s2) + 1 == len(s1):
        return one_away_insert(s2, s1)
    else:
        return False


def one_away_replace(s1, s2):
    diff = 0
    for ch1, ch2 in zip(s1, s2):
        if ch1 != ch2:
            diff += 1
    return True if diff <= 1 else False


def one_away_insert(s1, s2):
    i, j = 0, 0
    edited = False
    while i in range(len(s1)) and j in range(len(s2)):
        if s1[i] != s2[j]:
            if edited:
                return False
            edited = True
            j += 1
        else:
            i += 1
            j += 1

    return True


class Test(unittest.TestCase):
    test_cases = [
        # no changes
        ("pale", "pale", True),
        ("", "", True),
        # one insert
        ("pale", "ple", True),
        ("ple", "pale", True),
        ("pales", "pale", True),
        ("ples", "pales", True),
        ("pale", "pkle", True),
        ("paleabc", "pleabc", True),
        ("", "d", True),
        ("d", "de", True),
        # one replace
        ("pale", "bale", True),
        ("a", "b", True),
        ("pale", "ble", False),
        # multiple replace
        ("pale", "bake", False),
        # insert and replace
        ("pale", "pse", False),
        ("pale", "pas", False),
        ("pas", "pale", False),
        ("pkle", "pable", False),
        ("pal", "palks", False),
        ("palks", "pal", False),
        # permutation with insert shouldn't match
        ("ale", "elas", False),
    ]

    testable_functions = [one_away]

    def test_one_away(self):

        for f in self.testable_functions:
            start = time.perf_counter()
            for _ in range(100):
                for [text_a, text_b, expected] in self.test_cases:
                    assert f(text_a, text_b) == expected
            duration = time.perf_counter() - start
            print(f"{f.__name__} {duration * 1000:.1f}ms")


if __name__ == "__main__":
    unittest.main()
