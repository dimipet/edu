/*
 *
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * Να υλοποιηθεί πρόγραμμα το οποίο διαβάζει ένα ακέραιο αριθμό μεγαλύτερο του 1
 * και στη συνέχεια γίνονται τα ακόλουθα:
 *   •	Αν ο αριθμός είναι άρτιος τότε υποδιπλασιάζεται
 *   •	Αν ο αριθμός είναι περιττός τότε πολλαπλασιάζεται με το 3 και το
 *      εξαγόμενο αυξάνεται κατά 1.
 *
 * Το πρόγραμμα να επαναλαμβάνει συνεχώς τη διαδικασία στον εκάστοτε αριθμό που
 * προκύπτει από τα παραπάνω μέχρι να καταλήξει στην τιμή 1, οπότε τερματίζει.
 *
 * Αν ο αρχικός αριθμός είναι μικρότερος ή ίσος του 1 το πρόγραμμα να εμφανίζει
 * το αντίστοιχο μήνυμα λάθους και να ζητά την εισαγωγή νέου αριθμού.
 *
 * Διαφορετικά να εμφανίζονται τα εξής:
 *
 * Ο αρχικός αριθμός που δόθηκε από τον χρήστη με το κατάλληλο μήνυμα.
 *
 * Κατά την διάρκεια της επαναληπτικής διαδικασίας, ο αύξων αριθμός του
 * επαναληπτικού βήματος και ο αριθμός που προκύπτει για επεξεργασία στο επόμενο
 * βήμα.

 * Με τον τερματισμό της επαναληπτικής διαδικασίας ένα μήνυμα ότι η διαδικασία
 * ολοκληρώθηκε και ο αριθμός των βημάτων που απαιτήθηκαν.

 * Τυπικό δείγμα εξόδου του προγράμματος είναι το παρακάτω:
 * Initial Value 9
 * Step          Value
 *   1             28
 *   2             14
 *   3              7
 *   4             22
 *   5             11
 *   6             34
 *   7             17
 *   8             52
 *   9             26
 *  10             13
 *  11             40
 *  12             20
 *  13             10
 *  14              5
 *  15             16
 *  16              8
 *  17              4
 *  18              2
 *  19              1

 *  Program terminated after 19 steps
 */

int main(int argc, char** argv) {
    int x, step = 0;

    do {
      printf("Dose arithmo : ");
      scanf("%d", &x); /* Eisagogi arithmoy apo to plikrologio */
      if(x<=1) printf(" lathos, o arithmos einai <= 1\n");
    } while(x <= 1);

    printf("Initial Value %d\n", x); /* Ektiposi epikefalidon */
    printf("Step   Value\n");

    do {
        step++;
        if (x % 2) {
            x = 3 * x + 1; /* ypologismoi gia x peritto */
            printf(" %4d   %5d\n", step, x);
        } else {
            x /= 2; /* ypologismoi gia x artio */
            printf(" %4d   %5d\n", step, x);
        }
    } while (x > 1);

    printf("Program terminated after %d steps", step);
    printf("\n");

    return (EXIT_SUCCESS);
}