# URLify: Write a method to replace all spaces in a string with '%20'. You may
# assume that the string has sufficient space at the end to hold the additional
# characters, and that you are given the "true" length of the string.
# (Note: If implementing in Java,please use a character array so that you can
# perform this operation in place.)
# EXAMPLE
# Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"

import unittest


def urlify(s, maxLen):
    return s[:maxLen].replace(' ', '%20')


class Test(unittest.TestCase):
    """Test Cases"""

    test_cases = {
        ("much ado about nothing      ", 22): "much%20ado%20about%20nothing",
        ("Mr John Smith       ", 13): "Mr%20John%20Smith",
        (" a b    ", 4): "%20a%20b",
        (" a b       ", 5): "%20a%20b%20",
    }
    testable_functions = [urlify]

    def test_urlify(self):
        for urlify in self.testable_functions:
            for args, expected in self.test_cases.items():
                actual = urlify(*args)
                assert actual == expected, f"Failed {urlify.__name__} for: {[*args]}"


if __name__ == "__main__":
    unittest.main()