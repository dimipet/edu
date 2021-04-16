/*
 *
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>

void print_array(int A[], int n){
  int i;
  for (i = 0; i < n; i++) {
    printf("%d\n", A[i]);
  }
}

void selection_sort(int A[], int n) {
  int i, j, pos_min, temp;

  for (i = 0; i <= n - 2; i++) {
    pos_min = i;
    for (j = i + 1; j <= n - 1; j++)
      if (A[j] < A[pos_min])
        pos_min = j;
      temp = A[i];
      A[i] = A[pos_min];
      A[pos_min] = temp;
  }
  print_array(A, n);
}

int main(int argc, char** argv) {
  int my_array[100];
  int i;
  for (i = 0; i < 100; i++) {
    my_array[i] = rand();
  }
  selection_sort(my_array, 100);
  return (EXIT_SUCCESS);
}
