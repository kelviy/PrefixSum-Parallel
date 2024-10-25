# Prefix Sum Parallel Algorithm
Simple implementation of the parallel prefix sum algorithm in java using the fork-join framework.

Original algorithm from R. Ladner and M. Fischer at the University of Washington in 1977. Credits to Prof. Michelle Kuttel (UCT) for introducing the algorithm in lectures

## Introduction
The prefix sum problem can be solved intuitively in the serial programming context.
However, the algorithm at first glance seems to have a dependence on previous results, hence, at first glance
a naive programmer by assume the problem to be not parallelizable.

The parallel prefix sum algorithm, however, showcases that with some extra resources (namely the memory and multiple CPU cores)
it is possible to solve the problem in parallel. The algorithm take advantage of the fork-join framework to parallelize and additionally memory is
managed conceptually as a binary tree data structure as an overhead to coordinate the parallelism.

## How it works (very roughly simplified)
Node would need to store the following pieces of information.
1. array index range
2. sum of elements in index range
3. left half sum
4. links to left and right children nodes

The algorithm initializes the binary tree bottom up. Then traverses from top down the binary tree to compute the necessary summations. Both bottom up and top down traversals can be parallelized.

Root nodes contain the desired information for the output array after the algorithm finishes running.
