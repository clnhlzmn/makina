
#include <stdio.h>
#include <assert.h>
#include <string.h>
#include "out/test.h"

static const char *expected_output[] = {
    "s1_entry",
    "s1_s2_entry",
    "s1_s2_exit",
    "f_entry"
};

#define N_EVENTS (sizeof(expected_output) / sizeof(const char *))

static const char *actual_output[N_EVENTS];

static size_t output_index = 0;

#define PUSH_EVENT(e) do {              \
    assert(output_index < N_EVENTS);    \
    actual_output[output_index++] = e;  \
} while (0)

int s1_s2_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    PUSH_EVENT("s1_s2_entry");
    return 0;
}

int s1_s2_exit(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    PUSH_EVENT("s1_s2_exit");
    return 0;
}

int f_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    PUSH_EVENT("f_entry");
    return 0;
}

int s1_e1_action(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    PUSH_EVENT("s1_e1_action");
    return 0;
}

int s1_entry(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    PUSH_EVENT("s1_entry");
    return 0;
}

int s1_exit(struct test *self, struct test_event *event) {
    (void)self; (void)event;
    PUSH_EVENT("s1_exit");
    return 0;
}

int main (void) {
    struct test instance;
    test_init(&instance);
    test_process_event(&instance, &(struct test_event){.id = test_event_e1});
    test_process_event(&instance, &(struct test_event){.id = test_event_e1});
    for (size_t i = 0; i < N_EVENTS; ++i) {
        assert(strcmp(expected_output[i], actual_output[i]) == 0);
    }
    return 0;
}