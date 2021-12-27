# Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
# its entire row and column are set to 0.

import unittest
from copy import deepcopy


def zero_matrix(matrix):
    indices = []
    for m in range(len(matrix)):
        for n in range(len(matrix[0])):
            if matrix[m][n] == 0:
                indices.append((m, n))
    rows, cols = [idx for idx in zip(*indices)]
    rows, cols = set(rows), set(cols)

    result = [[0 for _ in matrix[0]] for _ in matrix]

    for m in range(len(result)):
        for n in range(len(result[0])):
            if m not in rows and n not in cols:
                result[m][n] = matrix[m][n]

    return result


class Test(unittest.TestCase):

    test_cases = [(
        [
            [1, 2, 3, 4, 0],
            [6, 0, 8, 9, 10],
            [11, 12, 13, 14, 15],
            [16, 0, 18, 19, 20],
            [21, 22, 23, 24, 25],
        ],
        [
            [0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0],
            [11, 0, 13, 14, 0],
            [0, 0, 0, 0, 0],
            [21, 0, 23, 24, 0],
        ],
    )]
    testable_functions = [zero_matrix]

    def test_zero_matrix(self):
        for f in self.testable_functions:
            for [test_matrix, expected] in self.test_cases:
                test_matrix = deepcopy(test_matrix)
                assert f(test_matrix) == expected


if __name__ == "__main__":
    unittest.main()
