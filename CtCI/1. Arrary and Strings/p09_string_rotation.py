# String Rotation: Assume you have a method isSubstring which checks if one word
# is a substring of another. Given two strings, sl and s2, write code to check
# if s2 is a rotation of sl using only one call to isSubstring
# (e.g.,"waterbottle" is a rotation of "erbottlewat").

import unittest


def isSubstring(s1, s2):
    return True if s1 in s2 else False


def string_rotation(s1, s2):
    if len(s1) == len(s2):
        return isSubstring(s1, s2 * 2)
    return False


class Test(unittest.TestCase):

    test_cases = [
        ("waterbottle", "erbottlewat", True),
        ("foo", "bar", False),
        ("foo", "foofoo", False),
    ]

    def test_string_rotation(self):
        for [s1, s2, expected] in self.test_cases:
            actual = string_rotation(s1, s2)
            assert actual == expected


if __name__ == "__main__":
    unittest.main()