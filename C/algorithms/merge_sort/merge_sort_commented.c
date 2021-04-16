/**
   www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/mergeSort.htm
   www.algorithm-code.com/wiki/Merge_sort#Pseudocode
   www.youtube.com/watch?v=GCae1WNvnZM
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/**
 * mergeMix
 * Step 1: Έστω βοηθητικός πίνακας temp[] που ορίζεται σε κάθε κλήση mergeMix
 *          δηλαδή για κάθε υποπίνακα
 * Step 2: επανέλαβε το step 3 ενόσω και οι δύο υπό-πίνακες
 *             i) [first ως mid]
 *            ii) [mid+1 ως last]
 *         έχουν στοιχεία.
 * Step 3: ΕΑΝ (first array τιμή μικρότερη απο second array τιμή)
 *              [οι τιμές υποδεικνύονται απο τους ανάλογους δείκτες]
 *              ΤΟΤΕ βάλε την τιμή του πρώτου πίνακα στον temp
 *        ΑΛΛΙΩΣ βάλε την τιμή του δεύτερου πίνακα στο temp
 * Step 4: αντίγραψε τις υπόλοιπες τιμές απο τον πρώτο στον δεύτερο πίνακα
 *              (αν υπάρχουν)
 * Step 5: αντίγραψε όλα τα στοιχεία του temp στον πίνακα.
 * Step 6: Τέλος.
 */

void mergeMix(int arrayA[], int temp[], int left, int mid, int right) {
//η mergeΜix τρέχει για διάφορα μεγέθη numberOfElements
//η παράμετρος arrayA είναι ο υπο-πίνακας ή ο πίνακας που θα ταξινομηθεί
//η παράμετρος temp είναι ένας βοηθητικός υποπίνακας
//το left είναι δείκτης και δείχνει στο πρώτο στοιχείο του arrayA
//το mid είναι δείκτης και δείχνει (περίπου) στο μεσαίο στοιχείο του arrayA
//το mid σε πίνακες με 2 στοιχεία πχ Α[11,68] είναι το 1
//το right είναι δείκτης και δείχνει στο τελευταίο στοιχείο του arrayA

        //δείκτης επαναλήψεων
        int i;
        //αριθμός στοιχείων υποπίνακα ή πίνακα
        int numOfElements;

        //βρίσκω δείκτη τέλους αριστερού υποπίνακα = μέση - 1
        //πχ στο Α[51, 3, 44, 8, 9, 10, 1] το mid είναι το Α[3]
        //άρα ο αριστερός υποπίνακας τελειώνει στο Α[2]
        int leftEnd = mid - 1;

        //δείκτης προσωρινής θέσης για τον πίνακα temp[]
        int tmpPosition;
        //αρχικά ο δείκτης προσωρινής θέσης είναι οσο και ο δείκτης left
        tmpPosition = left;

        //υπολογισμός αριθμού στοιχείων  ...
        //πχ αν μου έρθει ο υποπίνακας Α[99,34] με right = 1 και left = 0
        //τότε τα στοιχεία θα είναι 2, αφού 1 - 0 + 1 = 2
        numOfElements = right - left + 1;

        //Step 2
        while ((left <= leftEnd) && (mid <= right)) {

                //Step 3
                if (arrayA[left] <= arrayA[mid]) {
                        temp[tmpPosition] = arrayA[left];
                        //αυξάνω τους κατάλληλους δείκτες
                        tmpPosition = tmpPosition + 1;
                        left = left + 1;
                } else {
                        temp[tmpPosition] = arrayA[mid];
                        //αυξάνω τους κατάλληλους δείκτες
                        tmpPosition = tmpPosition + 1;
                        mid = mid + 1;
                }
        }

        //Step 4
        while (left <= leftEnd) {
                temp[tmpPosition] = arrayA[left];
                //αυξάνω τους κατάλληλους δείκτες
                tmpPosition = tmpPosition + 1;
                left = left + 1;
        }
        while (mid <= right) {
                temp[tmpPosition] = arrayA[mid];
                //αυξάνω τους κατάλληλους δείκτες
                tmpPosition = tmpPosition + 1;
                mid = mid + 1;

        }

        //step 5
        for (i = 0; i <= numOfElements; i++) {
                arrayA[right] = temp[right];
                right = right - 1;
        }
}

void mergeSort(int numbers[], int temp[], int left, int right) {
        int mid;

        if (right > left) {
                mid = (right + left) / 2;
                mergeSort(numbers, temp, left, mid);
                mergeSort(numbers, temp, mid + 1, right);

                mergeMix(numbers, temp, left, mid + 1, right);
        }
}

int A[10]={101, 89, 11, 45, 67, 89, 18, 15, 34, 23}; //έστω πίνακας Α

//συνάρτηση quicksort
void quicksort(int a, int b){

//τοπικές μεταβλητές

//όσο και το μέγεθος του Α
        int leftarr[10]; //νέος πίνακας (δεξιός)
        int rtarr[10]; //νέος πίνακας (αριστερός)
        int ltidx=0; //δείκτης δεξιού πίνακα leftarr[]
        int rtidx=0; //δείκτης αριστερού πίνακα rtarr[]
        int k=a;
        int l=0;
//δημιουργία και αρχικοποίηση pivot (βλ.Θεωρία)
        int pivot=A[a];

        if(a==b) return; //συνθήκη τερματισμού αναδρομής

        while(k<b) {
                ++k;
                //εάν στοιχείο Α[k] μικρότερο A[a]
                if(A[k]<A[a]) {
                        //πρόσθεσε στον αριστερό πίνακα leftarr το A[k]
                        leftarr[ltidx]=A[k];
                        //αύξηση δείκτη πίνακα leftarr
                        ltidx++;
                }
                //αλλιώς αν μεγαλύτερο ή ίσο
                else{
                        //πρόσθεσε στον δεξί πίνακα rtarr το A[k]
                        rtarr[rtidx]=A[k];
                        //αύξηση δείκτη πίνακα leftarr
                        rtidx++;
                }//τέλος if else
        }//τέλος while

        k=a;
        for(l=0; l<ltidx; ++l) A[k++]=leftarr[l]; //τέλος for
        A[k++]=pivot;
        for(l=0; l<rtidx; ++l) A[k++]=rtarr[l]; //τέλος for

//αναδρομή για επιμέρους πίνακες που δημιουργήθηκαν
        if(ltidx>0) quicksort(a,a+ltidx-1);
        if(rtidx>0) quicksort(b-rtidx+1,b);

}//τέλος quicksort συνάρτησης




int main(int argc, char** argv) {
        int i;
        int arrayTest[10] = {11, 56, 3, 6, 32, 69, 34, 74, 99, 1};
        int temp[10];
        clock_t start, stop;
        double t = 0.0;

        start = clock();

        for (i = 0; i < 10; i++) {
                //printf("%d ", arrayTest[i]);
                printf("%d ", A[i]);

        }
        printf("\n");

        //δίνουμε τον πίνακα, τον προσωρινό πίνακα,
        //το δείκτη πρώτου στοιχείου, το δείκτη τελευταίου στοιχείου
        //mergeSort(arrayTest, temp, 0, 9);


        quicksort(0, 9);

        for (i = 0; i < 10; i++) {
                //printf("%d ", arrayTest[i]);
                printf("%d ", A[1]);

        }


        printf("\n");

        stop = clock();

        t =((double) (stop - start)) / CLOCKS_PER_SEC;
        printf("%f seconds to execute \n", t);

        return (EXIT_SUCCESS);
}
