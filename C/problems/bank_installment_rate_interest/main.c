/*
 *
 * Created on 28 May 2011, 2:30 am
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
 * Στην τοκοχρεολυτική μηνιαία απόσβεση ενός δανείου με σταθερό επιτόκιο, η
 * σχέση που χρησιμοποιείται για τον υπολογισμό της μηνιαίας δόσης Δ για την
 * αποπληρωμή αρχικού κεφαλαίου Κ, με σταθερό επιτόκιο Ε, σε αριθμό μηνιαίων
 * δόσεων Ν είναι η εξής:
 *
 * Δ=( Κ*(1+Ε)^Ν ) / ( (((1+Ε)^Ν)-1) / (Ε) )
 *
 * Να γραφεί πρόγραμμα που να διαβάζει από το πληκτρολόγιο τα Κ, Ε και Ν.
 * Με βάση τα παραπάνω να:
 *
 * (α) υπολογίζει τη μηνιαία δόση Δ την οποία και εκτυπώνει στην οθόνη με
 * το ανάλογο μήνυμα.
 *
 * (β) υπολογίζει το συνολικό ποσό Π = Ν * Δ που απαιτείται για την αποπληρωμή
 * του δανείου.
 *
 * (γ) με βάση το προηγούμενο, υπολογίζει το επιπλέον ποσό Τ = Π – Κ που θα
 * καταβληθεί συνολικά ως τόκος για την αποπληρωμή του δανείου.
 *
 * (δ) υπολογίζει ως ποσοστό τον τόκο Τ επί του κεφαλαίου Κ από τη σχέση:
 * Φ=(Τ/Κ)*100%
 *
 * compile using : gcc ./main.c -o main -lm
 */
int main(int argc, char** argv) {
    int N;
    float K, E, D, P, T, F;

    /* Eisagogi dedomenon apo to pliktrologio */
    printf("\n Dose arithmo doseon N: ");
    scanf("%d", &N);
    printf("\n Dose arxiko kefalaio K: ");
    scanf("%f", &K);
    printf("\n Dose epitokio E (0<E<1) :");
    scanf("%f", &E);

    /* Ypologismos dosis */
    D = (K * pow((1 + E), N)) / ((pow((1 + E), N) - 1) / E);
    printf("\n H Dosi einai: %f", D);

    /* Ypologismos sinolikoy posoy */
    P = N*D;
    printf("\n To synoliko poso einai %f", P);

    /* Ypologismos epilpeon posoy */
    T = P - K;
    printf("\n To epipleon poso einai: %f", T);

    /* Ypologismos posostoy */
    F = (T / K)*100;
    printf("\n To pososto einai: %f%%", F);
    printf("\n");

    return (EXIT_SUCCESS);
}
