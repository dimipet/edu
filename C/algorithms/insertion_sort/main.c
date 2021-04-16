/*
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

void insertion_sort(int A[], int n){
	int i, j, key;

	for (i=1; i<=n-1; i++) {
		key = A[i];
		j = i-1;
		while (j>=0 && A[j]>key) {
			A[j+1] = A[j];
			j = j-1;
		}
			A[j+1]=key;
	}
	print_array(A, n);
}

int main(int argc, char** argv) {
		int my_array[100];
		int i;
		for (i = 0; i < 100; i++) {
			my_array[i] = rand();
		}
		insertion_sort(my_array, 100);
		return (EXIT_SUCCESS);
}
