#include <stdio.h>

// 用指针交换:接收两个变量的地址,直接改动内存里的值
void swap(int *a, int *b) {
    int temp = *a;   // *a 表示"a 指向的那个值"
    *a = *b;
    *b = temp;
}

// 坏版本:接收的是值的拷贝,改动只影响函数内部的副本
// 因为函数拿到的是 copies(拷贝),不是 addresses(地址),所以外面的变量不变
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main(void) {
    int x = 10, y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);              // 传地址,真的能交换
    printf("After swap:  x = %d, y = %d\n", x, y);

    // 演示对比:重置后用坏版本
    x = 10;
    y = 20;
    printf("\nBefore broken_swap: x = %d, y = %d\n", x, y);
    broken_swap(x, y);         // 传值,交换不了
    printf("After broken_swap:  x = %d, y = %d\n", x, y);

    return 0;
}