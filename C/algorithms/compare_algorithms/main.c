/*
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Voithitikes Sinartiseis
int smaller_element(int a[], int nl, int nu, unsigned long *syg) {
    int i, x, min;

    x = nl;
    min = a[nl];
    for (i = nl + 1; i <= nu; i++) {
        (*syg)++;
        if (min > a[i]) {
            x = i;
            min = a[i];
        }
    }
    return x;
}

void swap(int *i, int *j) {
   int t = *i;
   *i = *j;
   *j = t;
}

void print_result(char *head, long start, long end, unsigned long perasma, unsigned long sygriseis, unsigned long enallages){
    printf("%s | start %ld | end %ld | time %ld | perasma %lu | sygriseis %lu | enallages %lu \n", head, start, end, end-start, perasma, sygriseis, enallages);
}

void insertion_sort(int p[], int n) {
    int el, cur, k, i;
    long start, end;
    unsigned long perasma = 0, sygriseis = 0, enallages = 0;

    /*	Αφαιρέστε τα σχόλια από τις for εντολές για να δείτε τα στοιχεία των πινάκων που δημιουργούνται πριν και μετά την ταξινόμηση. Να χρησιμοποιήσετε μικρό πλήθος στοιχείων έτσι ώστε να χωράνε στην οθόνη. */

    // for(i=1; i<n; i++) printf("Array[%d]:%d\n", i, p[i]);

    start = clock();
    p[0] = -1;
    for (k = 1; k < n; k++) {
        perasma++;
        el = p[k];
        cur = k;
        sygriseis++;
        while (p[cur - 1] > el) {
            enallages++;
            p[cur] = p[cur - 1];
            cur = cur - 1;
            sygriseis++;
        }
        p[cur] = el;
        enallages++;
    }
    end = clock();
    print_result("insertion_sort ", start, end, perasma, sygriseis, enallages);

    // for(i=1; i<n; i++) printf("Sorted Array[%d]:%d\n", i, p[i]);
}

void bubble_sort(int p[], int n) {
    int i, k;
    long start, end;
    unsigned long perasma = 0, sygriseis = 0, enallages = 0;

    // for(i=0; i<n; i++) printf("Array[%d]:%d\n", i, p[i]);

    start = clock();
    for (i = 0; i < n - 1; i++) {
        perasma++;
        for (k = n - 1; k >= i + 1; k--) {
            sygriseis++;
            if (p[k] < p[k - 1]) {
                swap(&p[k], &p[k - 1]); // Θα μπορούσατε να παρουσιάσετε αναλυτικά την
                enallages++; // εναλλαγή όπως φαίνεται στο βιβλίο σας
            }
        }
    }
    end = clock();

    print_result("bubble_sort    ", start, end, perasma, sygriseis, enallages);

    // for(i=0; i<n; i++) printf("Sorted array[%d]:%d\n", i, p[i]);
}

void selection_sort(int a[], int n) {
    int k, x, i;
    long start, end;
    unsigned long perasma = 0, sygriseis = 0, enallages = 0;

    // for(i=0; i<n; i++) printf("Array[%d]:%d\n", i, a[i]);

    start = clock();
    for (k = 0; k < n - 1; k++) {
        perasma++;
        x = smaller_element(a, k, n - 1, &sygriseis);
        swap(&a[k], &a[x]);
        enallages++;
    }
    end = clock();
    print_result("selection_sort ", start, end, perasma, sygriseis, enallages);

    // for(i=0; i<n; i++) printf("Sorted array[%d]:%d\n", i, a[i]);
}


int main(int argc, char** argv) {
  const int ARR_LENGTH = 100000;

  int my_array[ARR_LENGTH];
  int i;
  for (i = 0; i < ARR_LENGTH; i++) {
    my_array[i] = rand();
  }
  insertion_sort(my_array, ARR_LENGTH);
  bubble_sort(my_array, ARR_LENGTH);
  selection_sort(my_array, ARR_LENGTH);

  return (EXIT_SUCCESS);
}
