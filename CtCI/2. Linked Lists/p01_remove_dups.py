# Remove Dups: Write code to remove duplicates from an unsorted linked list.
# FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?

from linked_list import LinkedList
import time


def remove_dups(ll):
    visited = set()
    prev = None
    curr = ll.head

    while curr:
        if curr.value not in visited:
            visited.add(curr.value)
            prev = curr
            curr = curr.next
        else:
            prev.next = curr.next
            curr = curr.next
    ll.tail = prev
    return ll


def remove_dups_followup(ll):
    """Idea: For each curr node, run a runner node for the rest and delete 
    all future nodes with the same value compared to the curr node. All values 
    will be unique since the duplicates were deleted at each step.
    """
    curr = runner = ll.head

    while curr:
        runner = curr
        while runner.next:
            if runner.next.value == curr.value:
                runner.next = runner.next.next
            else:
                runner = runner.next
        curr = curr.next

    ll.tail = runner
    return ll


testable_functions = [remove_dups, remove_dups_followup]
test_cases = (
    ([], []),
    ([1, 1, 1, 1, 1, 1], [1]),
    ([1, 2, 3, 2], [1, 2, 3]),
    ([1, 2, 2, 3], [1, 2, 3]),
    ([1, 1, 2, 3], [1, 2, 3]),
    ([1, 2, 3], [1, 2, 3]),
)


def test_remove_dupes():
    for f in testable_functions:
        start = time.perf_counter()
        for _ in range(100):
            for values, expected in test_cases:
                expected = expected.copy()
                deduped = f(LinkedList(values))
                # print(deduped.values(), expected)
                assert deduped.values() == expected

                deduped.add(5)
                expected.append(5)
                # print(deduped.values(), expected)
                assert deduped.values() == expected

        duration = time.perf_counter() - start
        print(f"{f.__name__} {duration * 1000:.1f}ms")


def example():
    ll = LinkedList.generate(100, 0, 9)
    print(ll)
    remove_dups(ll)
    print(ll)

    ll = LinkedList.generate(100, 0, 9)
    print(ll)
    remove_dups_followup(ll)
    print(ll)


if __name__ == "__main__":
    test_remove_dupes()
    example()