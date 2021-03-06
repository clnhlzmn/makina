
#include <stdio.h>
#include "out/test.h"

FILE *output;

int s1_s2_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_s2_entry\n");
    return 0;
}

int s1_s2_e1_guard(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s1_s2_e1_guard\n");
    return event->ctx.guard;
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

int s2_s3_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s2_s3_entry\n");
    return 0;
}

int s2_s3_exit(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s2_s3_exit\n");
    return 0;
}

int s2_s1_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s2_s1_entry\n");
    return 0;
}

int s2_s1_e1_action(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s2_s1_e1_action\n");
    return 0;
}

int s2_s1_exit(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s2_s1_exit\n");
    return 0;
}

int s2_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s2_entry\n");
    return 0;
}

int s2_exit(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    fprintf(output, "s2_exit\n");
    return 0;
}

int main (void) {
    output = fopen("out/test_output.txt", "w+");
    struct test instance;
    test_init(&instance);                                                      //s1_entry, s1_s2_entry
    test_process_event(&instance, &(struct test_event) {.id = test_event_e1, .ctx = (struct event_data){0}}); //s1_s2_e1_guard, s1_s2_exit, s1_exit, s2_entry, s2_s1_entry
    test_process_event(&instance, &(struct test_event) {.id = test_event_e2, .ctx = (struct event_data){0}}); //...
    test_process_event(&instance, &(struct test_event) {.id = test_event_e1, .ctx = (struct event_data){0}}); //s2_s1_exit, s2_exit, s2_s1_e1_action, s1_entry, s1_s2_entry
    test_process_event(&instance, &(struct test_event) {.id = test_event_e1, .ctx = (struct event_data){1}}); //s1_s2_e1_guard, s1_s2_e1_action
    test_process_event(&instance, &(struct test_event) {.id = test_event_e2, .ctx = (struct event_data){0}}); //s1_s2_exit, s1_exit, s2_entry, s2_s3_entry
    test_process_event(&instance, &(struct test_event) {.id = test_event_e2, .ctx = (struct event_data){0}}); //s2_s3_exit, s2_exit, s1_entry, s1_s2_entry
    fclose(output);
    return 0;
}