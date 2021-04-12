
#include <stdio.h>
#include <assert.h>
#include <string.h>
#include "out/test.h"

static const char *expected_output[] = {
    "s1_entry",
    "s11_entry",
    "s12_entry",
    "s111_entry",
    "s121_entry",
    "s121_exit",
    "s111_exit",
    "s112_entry",
    "s122_entry"
};

#define N_EVENTS (sizeof(expected_output) / sizeof(const char *))

static const char *actual_output[N_EVENTS];

static size_t output_index = 0;

#define PUSH_EVENT(e) do {              \
    assert(output_index < N_EVENTS);    \
    actual_output[output_index++] = e;  \
} while (0)

int s111_entry(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s111_entry");
    return 0;
}
int s111_exit(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s111_exit");
    return 0;
}
int s112_entry(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s112_entry");
    return 0;
}
int s11_entry(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s11_entry");
    return 0;
}
int s121_entry(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s121_entry");
    return 0;
}
int s121_exit(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s121_exit");
    return 0;
}
int s122_entry(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s122_entry");
    return 0;
}
int s12_entry(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s12_entry");
    return 0;
}
int s1_entry(struct test *self, struct test_event *event) {
    (void)self;(void)event;
    PUSH_EVENT("s1_entry");
    return 0;
}

int main (void) {
    struct test instance;
    test_init(&instance);
    test_process_event(&instance, &(struct test_event){.id = test_event_e});
    for (size_t i = 0; i < N_EVENTS; ++i) {
        assert(strcmp(expected_output[i], actual_output[i]) == 0);
    }
    return 0;
}
