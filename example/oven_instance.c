#include <stdio.h>
#include "oven.h"

int enable_heater(struct oven *self, struct oven_event *event) {
    printf("heater enabled\r\n");
}
int disable_heater(struct oven *self, struct oven_event *event) {
    printf("heater disabled\r\n");
}
int error(struct oven *self, struct oven_event *event) {
    printf("error\r\n");
}

int main(void) {
    struct oven instance;
    oven_init(&instance);
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_start});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_open});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_start});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_close});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_timeout});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_start});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_open});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_close});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_start});
    oven_process_event(&instance, &(struct oven_event){.id = oven_event_timeout});
}
