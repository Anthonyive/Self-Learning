# Return Kth to Last: Implement an algorithm to find the kth to last element
# of a singly linked list.

from linked_list import LinkedList


def kth_to_last(ll, k):
    """Idea: Offset runner at the begining, then iterate curr and runner at 
    the same time until runner hits the end."""

    curr = runner = ll.head
    for _ in range(k):
        runner = runner.next

    while runner:
        curr = curr.next
        runner = runner.next

    return curr


def kth_to_last_recursive(ll, k):
    pass


test_cases = (
    # list, k, expected
    ((10, 20, 30, 40, 50), 1, 50),
    ((10, 20, 30, 40, 50), 5, 10),
)


def test_kth_to_last():
    for linked_list_values, k, expected in test_cases:
        ll = LinkedList(linked_list_values)
        assert kth_to_last(ll, k).value == expected
        # assert kth_to_last_recursive(ll, k).value == expected


if __name__ == "__main__":
    test_kth_to_last()