/*
 *
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>

int A[10]; //έστω πίνακας Α

void print_array(int A[], int n){
  int i;
  for (i = 0; i < n; i++) {
    printf("%d\n", A[i]);
  }
}


//συνάρτηση quick_sort
void quick_sort(int a, int b) {

    //τοπικές μεταβλητές

    //όσο και το μέγεθος του Α
    int leftarr[10]; //νέος πίνακας (δεξιός)
    int rtarr[10]; //νέος πίνακας (αριστερός)
    int ltidx = 0; //δείκτης δεξιού πίνακα leftarr[]
    int rtidx = 0; //δείκτης αριστερού πίνακα rtarr[]
    int k = a;
    int l = 0;

    //δημιουργία και αρχικοποίηση pivot (βλ.Θεωρία)
    int pivot = A[a];

    if (a == b) return; //συνθήκη τερματισμού αναδρομής

    while (k < b) {
        ++k;
        //εάν στοιχείο Α[k] μικρότερο A[a]
        if (A[k] < A[a]) {
            //πρόσθεσε στον αριστερό πίνακα leftarr το A[k]
            leftarr[ltidx] = A[k];
            //αύξηση δείκτη πίνακα leftarr
            ltidx++;
        }   //αλλιώς αν μεγαλύτερο ή ίσο
        else {
            //πρόσθεσε στον δεξί πίνακα rtarr το A[k]
            rtarr[rtidx] = A[k];
            //αύξηση δείκτη πίνακα leftarr
            rtidx++;
        }//τέλος if else
    }//τέλος while

    k = a;
    for (l = 0; l < ltidx; ++l)A[k++] = leftarr[l]; //τέλος for
    A[k++] = pivot;
    for (l = 0; l < rtidx; ++l)A[k++] = rtarr[l]; //τέλος for

    //αναδρομή για επιμέρους πίνακες που δημιουργήθηκαν
    if (ltidx > 0)quick_sort(a, a + ltidx - 1);
    if (rtidx > 0)quick_sort(b - rtidx + 1, b);

}//τέλος quick_sort συνάρτησης

int main(int argc, char** argv) {
  int i;
  for (i = 0; i < 10; i++) {
    A[i] = rand();
  }
  quick_sort(0, 10);
  print_array(A, 10);
  return (EXIT_SUCCESS);
}
