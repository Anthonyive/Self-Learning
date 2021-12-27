# String Compression: Implement a method to perform basic string compression
# using the counts of repeated characters. For example, the string aabcccccaaa
# would become a2blc5a3. If the "compressed" string would not become smaller
# than the original string, your method should return the original string.
# You can assume the string has only uppercase and lowercase letters (a - z).

import unittest
from collections import Counter
import time


def string_compression(s):
    c = []
    for i, ch in enumerate(s):
        if i == 0:
            c.append([ch, 1])
        else:
            if ch == c[-1][0]:
                c[-1][1] += 1
            else:
                c.append([ch, 1])

    compressed_s = ''
    for ch, count in c:
        compressed_s += ch
        compressed_s += str(count)

    return compressed_s if len(compressed_s) < len(s) else s


class Test(unittest.TestCase):
    test_cases = [
        ("aabcccccaaa", "a2b1c5a3"),
        ("abcdef", "abcdef"),
        ("aabb", "aabb"),
        ("aaa", "a3"),
        ("a", "a"),
        ("", ""),
    ]
    testable_functions = [
        string_compression,
    ]

    def test_string_compression(self):
        for f in self.testable_functions:
            start = time.perf_counter()
            for _ in range(1000):
                for test_string, expected in self.test_cases:
                    assert f(test_string) == expected
            duration = time.perf_counter() - start
            print(f"{f.__name__} {duration * 1000:.1f}ms")


if __name__ == "__main__":
    unittest.main()