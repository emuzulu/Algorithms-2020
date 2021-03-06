## Introduction

This is Actually a **Dynamic Programming** problem rather than a **Greedy** problem. The key to solve this problem is to form a **DAG** (Directed Acyclic Graph) base on the nested relationship between each ractangle.

Assume there is a graph G with n vertices(n is the number of rectangles) and 0 edge. If rectangle A can nest in rectange B, we can put a edge a -> b in the graph G. Because a rectangle cannot nest in itself and A in B is different from B in A, the graph G we finally form is actually a **DAG**. Thus the deepest stack we want to get is actually the longest length in G(think about it).

Then the question is: How to get the maximum length with **unknown start point**? To solve this question, let d(i) be the maximum length at a start vertex i. Then, because we are only able to reach the adjacent vertices(i.e. j), there will be a formula that:

 - **d(i) = max{ d(j)+1 | (i, j) in E(Set of edges) }** or
 
 
 - **d(i) = max(d(j)+1, d(i))**
 
 Because we want to get the maximum for all situation, it is reasonable to make comparison with the current maximum and other maximum length we can get from its adjacent vertices.

 (p.s. You do not have to fully understand this :P)

## To See More
[Longest Path on DAG(Dynamic Programming)](https://www.geeksforgeeks.org/longest-path-in-a-directed-acyclic-graph-dynamic-programming/)
