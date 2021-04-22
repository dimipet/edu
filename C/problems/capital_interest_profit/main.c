/*
 *
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * Να γραφεί πρόγραμμα το οποίο διαβάζει τρεις αριθμούς: ένα πραγματικό αριθμό Κ
 * που αναπαριστά το κεφάλαιο σε ευρώ, ένα πραγματικό αριθμό Ε που αναπαριστά
 * το ετήσιο επιτόκιο και έναν ακέραιο αριθμό N που αναπαριστά το χρόνο τοκισμού
 * του κεφαλαίου σε έτη.

 * Για κάθε έτος, το πρόγραμμα να υπολογίζει τον παραγόμενο τόκο και να εκτυπώνει
 * τον τόκο και το άθροισμα τόκου και κεφαλαίου. Ο υπολογισμός του τόκου να γίνει
 * με βάση τη σχέση:
 * Τ = Κ*Ε/100

 * λαμβάνοντας υπόψη ότι συμβαίνει ανατοκισμός, δηλαδή ότι ο παραγόμενος τόκος
 * κάθε χρόνο προστίθεται στο κεφάλαιο που θα τοκισθεί τον επόμενο χρόνο.
 * Το πρόγραμμα να εμφανίζει στην οθόνη έξοδο ως εξής:

Arxiko kefalaio 30000.00, epitokio 12.5%, diarkeia 10 eti

Etos Tokos    Neo kefalaio
  1  3750.00    33750.00
  2  4218.75    37968.75
  3  4746.09    42714.84
  4  5339.35    48054.19
  5  6006.77    54060.96
  6  6757.62    60818.58
  7  7602.32    68420.90
  8  8552.61    76973.51
  9  9621.68    86595.19
 10 10824.39    97419.58

 */
int main(int argc, char** argv) {
    float capital, interest, profit;
    int years;

    /* Eisagogi dedomenon */

    printf(" Enter Capital, Interest, Years [e.g. 100 3.2 15] \n");
    scanf("%f %f %d", &capital, &interest, &years);
    printf(" Initial capital %8.2f, interest %4.2f, years %d\n ", capital, interest, years);
    printf(" Year   Profit     Capital\n");

    /* Ypologismoi kai ektiposi */
    int i;
    for (i = 1; i <= years; i++) {
        profit = capital * interest / 100;
        capital += profit;
        printf("%3d %10.2f  %10.2f\n", i, profit, capital);
    }
    return (EXIT_SUCCESS);
}
