/*
 *
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>

const int ARR_LENGTH = 100;

void print_array(int arr[], int n){
  int i;
  for (i = 0; i < n; i++) {
    printf("%d\n", arr[i]);
  }
}


//συνάρτηση quick_sort
void quick_sort(int my_array[], int a, int b) {
    //τοπικές μεταβλητές

    //όσο και το μέγεθος του my_array
    int leftarr[ARR_LENGTH]; //νέος πίνακας (δεξιός)
    int rtarr[ARR_LENGTH]; //νέος πίνακας (αριστερός)
    int ltidx = 0; //δείκτης δεξιού πίνακα leftarr[]
    int rtidx = 0; //δείκτης αριστερού πίνακα rtarr[]
    int k = a;
    int l = 0;

    //δημιουργία και αρχικοποίηση pivot (βλ.Θεωρία)
    int pivot = my_array[a];

    if (a == b) return; //συνθήκη τερματισμού αναδρομής

    while (k < b) {
        ++k;
        //εάν στοιχείο my_array[k] μικρότερο my_array[a]
        if (my_array[k] < my_array[a]) {
            //πρόσθεσε στον αριστερό πίνακα leftarr το my_array[k]
            leftarr[ltidx] = my_array[k];
            //αύξηση δείκτη πίνακα leftarr
            ltidx++;
        }   //αλλιώς αν μεγαλύτερο ή ίσο
        else {
            //πρόσθεσε στον δεξί πίνακα rtarr το my_array[k]
            rtarr[rtidx] = my_array[k];
            //αύξηση δείκτη πίνακα leftarr
            rtidx++;
        }//τέλος if else
    }//τέλος while

    k = a;
    for (l = 0; l < ltidx; ++l) my_array[k++] = leftarr[l]; //τέλος for
    my_array[k++] = pivot;
    for (l = 0; l < rtidx; ++l) my_array[k++] = rtarr[l]; //τέλος for

    //αναδρομή για επιμέρους πίνακες που δημιουργήθηκαν
    if (ltidx > 0) quick_sort(my_array, a, a + ltidx - 1);
    if (rtidx > 0) quick_sort(my_array, b - rtidx + 1, b);

}//τέλος quick_sort συνάρτησης

int main(int argc, char** argv) {

  int arr[ARR_LENGTH];
  int i;
  for (i = 0; i < ARR_LENGTH; i++) {
    arr[i] = rand();
  }
  quick_sort(arr, 0, ARR_LENGTH-1);
  print_array(arr, ARR_LENGTH);
  return (EXIT_SUCCESS);
}
