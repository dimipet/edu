/*
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>

#define M 5

/*
 * Να γραφεί C πρόγραμμα το οποίο:
 * (α) Ορίζει μια σταθερά Μ ως ακέραιο αριθμό ο οποίος είναι το μέγεθος δύο
 * μονοδιάστατων πινάκων

 * (β) Ορίζει και διαβάζει από την οθόνη τα στοιχεία δυο μονοδιάστατων πινάκων
 * Α και Β, μεγέθους Μ ο καθένας.

 * (γ) Καλεί τη συνάρτηση matrix_sum η οποία λαμβάνει ως ορίσματα δυο πίνακες
 * και το μέγεθός τους Μ και υπολογίζει και εμφανίζει το άθροισμα των ομολόγων
 * στοιχείων των πινάκων Α και Β (δηλαδή το άθροισμα Α + Β).

 * (δ) Καλεί τη συνάρτηση matrix_subtract η οποία λαμβάνει ως ορίσματα δυο πίνακες
 * και το μέγεθός τους Μ και υπολογίζει και εμφανίζει τη διαφορά των ομολόγων
 * στοιχείων των πινάκων Α και Β (δηλαδή τη διαφορά Α – Β).

 * (ε) Καλεί τη συνάρτηση matrix_reverse η οποία δέχεται ως ορίσματα ένα
 * μονοδιάστατο πίνακα και το μέγεθος του πίνακα και θέτει τα στοιχεία του πίνακα
 * στις αντίστροφες θέσεις (δηλαδή το πρώτο στοιχείο του πίνακα τοποθετείται
 * στην τελευταία θέση του πίνακα, το δεύτερο στοιχείο του πίνακα τοποθετείται
 * στην προτελευταία θέση του πίνακα, κλπ). Μετά από αυτή τη μεταβολή η
 * συνάρτηση εμφανίζει τα στοιχεία του πίνακα όπως αυτά προέκυψαν.
 *
 * Η συνάρτηση αυτή καλείται δυο φορές, μια για καθένα από τους πίνακες Α και Β.
 *
 * Παρατήρηση: Ο κώδικας των συναρτήσεων να αναπτυχθεί με την χρήση δεικτών.
 *
 * Τυπική έξοδος του προγράμματος:
 *
 * Αν είναι Μ = 5 και:
 * Α = (6, 8, 3, 5, 7)
 * Β = (4, 1, 6, 2, 9)
 *
 * Τότε η συνάρτηση matrix_sum εμφανίζει ως έξοδο:
 * 10, 9, 9, 7, 16
 *
 * η συνάρτηση matrix_subtract εμφανίζει ως έξοδο:
 * 2, 7, -3, 3, -2

 * Τέλος η συνάρτηση matrix_reverse όταν καλείται με τον πίνακα Α εμφανίζει ως έξοδο:
 * 7, 5, 3, 8, 6
 *
 * ενώ όταν καλείται για τον πίνακα Β, εμφανίζει ως έξοδο:
9, 2, 6, 1, 4
 *
  */

/* Synartisi matrix_sum */

void matrix_sum(int *p, int *q, int matrix_size) {
    int k;

    printf("\n adding matrices\n");
    for (k = 0; k < matrix_size; k++)
        printf("%dth element = %d\n", k, *(p + k) + *(q + k));
}

/* Synartisi matrix_subtract */

void matrix_subtract(int *p, int *q, int matrix_size) {
    int k;

    printf("\n substacting matrices\n");
    for (k = 0; k < matrix_size; k++)
        printf("%dth element = %d\n", k, *(p + k) - *(q + k));
}

/* Synartisi matrix_reverse */

void matrix_reverse(int *p, int matrix_size) {
    int k;
    int tmp;

    for (k = 0; k < matrix_size / 2; k++) {
        tmp = *(p + k);
        *(p + k) = *(p + matrix_size - 1 - k);
        *(p + matrix_size - 1 - k) = tmp;
    }

    printf("\n matrix reversed\n");
    for (k = 0; k < matrix_size; k++)
        printf("%dth element = %d\n", k, *(p + k));

    printf("\n");

}

/* Synartisi main */

int main(int argc, char** argv) {
    int a[M], b[M];
    int i;

    for (i = 0; i < M; i++) /* Eisagogi stoixeion protoy pinaka */ {
        printf("Input a[%d]\n", i);
        scanf("%d", a + i);
    }

    for (i = 0; i < M; i++) /* Eisagogi stoixeion deyteroy pinaka */ {
        printf("Input b[%d]\n", i);
        scanf("%d", b + i);
    }

    /* Klisi synartiseon */

    matrix_sum(a, b, M);
    matrix_subtract(a, b, M);

    matrix_reverse(a, M);
    matrix_reverse(b, M);
    printf("\n");
    return (EXIT_SUCCESS);
}
