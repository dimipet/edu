/* 
 *
 * Created on 28 May 2011, 2:35 am
 */

#include <stdio.h>
#include <stdlib.h>

void merge_mix(int arrayA[], int temp[], int left, int mid, int right) {
    int i;
    int numOfElements;
    int tmpPosition;
    int leftEnd = mid - 1;
    tmpPosition = left;
    numOfElements = right - left + 1;
    while ((left <= leftEnd) && (mid <= right)) {
        if (arrayA[left] <= arrayA[mid]) {
            temp[tmpPosition] = arrayA[left];
            tmpPosition = tmpPosition + 1;
            left = left + 1;
        } else {
            temp[tmpPosition] = arrayA[mid];
            tmpPosition = tmpPosition + 1;
            mid = mid + 1;
        }
    }
    while (left <= leftEnd) {
        temp[tmpPosition] = arrayA[left];
        tmpPosition = tmpPosition + 1;
        left = left + 1;
    }
    while (mid <= right) {
        temp[tmpPosition] = arrayA[mid];
        tmpPosition = tmpPosition + 1;
        mid = mid + 1;
    }

    //step 5
    for (i = 0; i <= numOfElements; i++) {
        arrayA[right] = temp[right];
        right = right - 1;
    }
}

void merge_sort(int numbers[], int temp[], int left, int right) {
    int mid;
    if (right > left) {
        mid = (right + left) / 2;
        merge_sort(numbers, temp, left, mid);
        merge_sort(numbers, temp, mid + 1, right);
        merge_mix(numbers, temp, left, mid + 1, right);
    }
}

int main(int argc, char** argv) {

    return (EXIT_SUCCESS);
}
