/*
 *
 * Created on 28 May 2011, 2:30 am
 */


#include <stdio.h>
#include <stdlib.h>

/*
 * Να υλοποιηθεί  C πρόγραμμα το οποίο:
 * (α) διαβάζει δύο μη αρνητικούς αριθμούς x και y που βρίσκονται στο διάστημα
 * τιμών 0 έως 255 (δηλαδή αριθμούς τύπου unsigned short). Σε περίπτωση που δοθεί
 * σαν είσοδος αρνητικός αριθμός, ή αριθμός μεγαλύτερος του 255 η εκτέλεση του
 * προγράμματος να τερματίζεται με εμφάνιση ανάλογου μηνύματος λάθους.

 * (β) εμφανίζει με χρήση της έκφρασης (x>>i)&01 ένα προς ένα τα δυαδικά ψηφία
 * της δυαδικής αναπαράστασης της μεταβλητής x (θεωρείστε ότι για την δυαδική
 * αναπαράσταση των τιμών των μεταβλητών x και y απαιτείται από ένα byte,
 * δηλαδή 8 bits για την κάθε μεταβλητή).

 * (γ) εμφανίζει το αποτέλεσμα της εφαρμογής του τελεστή bitwise AND (&)
 * στα αντίστοιχα δυαδικά ψηφία των αριθμών x και y.

 * (δ) εμφανίζει το αποτέλεσμα της εφαρμογής του τελεστή bitwise OR (|)
 * στα αντίστοιχα δυαδικά ψηφία των αριθμών x και y.

Τυπική έξοδος του προγράμματος:
Enter first number: 6
Enter second number: 11

Binary expression of  first number: 00000110
Binary expression of second number: 00001011

Binary  AND (&) of the two numbers: 00000010
Binary  OR (|)  of the two numbers: 00001111

Σημείωση: Τονίζεται ότι η δυνατότητα χειρισμού ξεχωριστών δυαδικών ψηφίων από τη γλώσσα c με τη χρήση των τελεστών bitwise, δίνει την δυνατότητα ανάπτυξης πιο αποτελεσματικού κώδικα.

 */
int main(int argc, char** argv) {
    unsigned x, y;

    printf("Enter first number "); /* Eisagogi dedomenon apo to pliktrologio */
    scanf("%u", &x);
    if (x < 0 || x > 255) { /* Amintikos programmatismos */
        printf("Error in the first number");
        exit(0);
    }

    printf("Enter second number ");
    scanf("%u", &y);
    if (y < 0 || y > 255) { /* Amintikos programmatismos */
        printf("Error in the second number");
        exit(0);
    }

    int i;

    printf("\nBinary expression of first number "); /* Ypologismoi b erotimatos */
    for (i = 0; i < 8; i++) {
        printf(" %d", (x >> i)&01);
    }

    printf("\nBinary expression of second number ");
    for (i = 0; i < 8; i++) {
        printf(" %d", (y >> i)&01);
    }

    printf("\n\nBinary AND (&) of the two numbers"); /* Ypologismoi c erotimatos */
    for (i = 0; i < 8; i++) {
        printf(" %d", ((x >> i)&01) & ((y >> i)&01));
    }

    printf("\nBinary OR (|) of the two numbers"); /* Ypologismoi d erotimatos */
    for (i = 0; i < 8; i++) {
        printf(" %d", ((x >> i)&01) | ((y >> i)&01));
    }

    printf("\n");
    return (EXIT_SUCCESS);
}
