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
 * αποπληρωμή αρχικού κεφαλαίου Κ, με σταθερό μηνιαιο επιτόκιο Ε, σε αριθμό
 * μηνιαίων δόσεων Ν είναι η εξής:
 *
 * Δ=( Κ*(1+Ε)^Ν ) / ( (((1+Ε)^Ν)-1) / (Ε) )
 *
 * όπου Ε = Ε/12 για μηνιαιο
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

    printf("\n Δωσε αριθμο μηνιαιων δωσεων N : ");
    scanf("%d", &N);
    printf("\n Δωσε αρχικο κεφαλαιο K : ");
    scanf("%f", &K);
    printf("\n Δωσε επιτοκιο E (π.χ. 4.5): ");
    scanf("%f", &E);
    E=E/12;

    D = K*(E/100*pow((1+E/100),N)) / (pow((1+E/100),N)-1);
    printf("\n Η μηνιαια δοση ειναι : %f ", D);

    P = N*D;
    printf("\n Το συνολικό ποσό αποπληρωμης ειναι : %f  ", P);

    T = P - K;
    printf("\n Το επιπλεον ποσο ειναι : %f ", T);

    F = (T / K)*100;
    printf("\n Ποσοστο τοκου επι του κεφαλαιου : %f%% ", F);
    printf("\n");

    return (EXIT_SUCCESS);
}
