
#include <stdio.h>
#include "out/test.h"

FILE *output;

int s1_s2_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_s2_entry\n");
    return 0;
}

static int guard = 0;

int s1_s2_e1_guard(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_s2_e1_guard\n");
    return guard;
}

int s1_s2_e2_guard(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_s2_e2_guard\n");
    return guard;
}

int s1_s2_e1_action(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_s2_e1_action\n");
    return 0;
}

int s1_s2_exit(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_s2_exit\n");
    return 0;
}

int s1_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_entry\n");
    return 0;
}

int s1_exit(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_exit\n");
    return 0;
}

int main (void) {
    output = fopen("out/test_output.txt", "w+");
    struct test instance;
    test_init(&instance);                                                       /*s1_entry, s1_s2_entry*/
    test_process_event(&instance, &(struct test_event){.id = test_event_e1});   /*s1_s2_e1_guard, s1_s2_exit, s1_exit, s1_entry, s1_s2_entry*/
    guard = 1;
    test_process_event(&instance, &(struct test_event){.id = test_event_e1});   /*s1_s2_e1_guard, s1_s2_exit, s1_exit, s1_entry, s1_s2_entry*/
    guard = 0;
    test_process_event(&instance, &(struct test_event){.id = test_event_e2});   /*s1_s2_e2_guard, s1_s2_exit, s1_s2_entry*/
    guard = 1;
    test_process_event(&instance, &(struct test_event){.id = test_event_e2});   /*s1_s2_e2_guard, s1_s2_exit, s1_s2_entry*/
    fclose(output);
    return 0;
}