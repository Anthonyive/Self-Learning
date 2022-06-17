# About Search Trees

- Binary Search Trees
    - Can be unbalanced, resulting bad complexities.
- B Trees (2-3 Trees, 3-4 Trees)
    - Idea: several items in one node. 
    - Invariants
        - All leaves must be the same distance from the source
        - A non-leaf node with k items must have exactly k+1 children.
    - Balanced by contruction, but hard to implement.
- Red Black Trees
    - Idea: "glue" multi-item nodes with red links. Other linkages are black. Example, [Left-leaning Red Black Binary Search Tree (LLRB)](https://docs.google.com/presentation/d/1S27xlCPX0Up8WAHZPBqmbcrcKo4FNbyG6eTHamOxzgA/edit#slide=id.g5240c8ba42_0_273)
    - Properties (LLRB 2-3 tree)
        - No node has two red links [otherwise it’d be analogous to a 4 node, which are disallowed in 2-3 trees].
        - Every path from root to a leaf has same number of black links [because 2-3 trees have the same number of links to every leaf]. LLRBs are therefore balanced.

In conclusion, B tree is an improvement over binary search tree while Red Black tree is an implementation of B tree. So Red Black trees is the same as B trees regarding the worst case runtime compared to binary search trees.