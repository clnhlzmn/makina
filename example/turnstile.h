/*Do not modify. This file is generated by makina.*/

#ifndef TURNSTILE_H
#define TURNSTILE_H

struct Turnstile;
struct Turnstile_event;

/*User defined actions and guards. These functions must be defined by the user.*/
int Closed_apply_latch(struct Turnstile *, struct Turnstile_event *);
int Closed_valid_ticket(struct Turnstile *, struct Turnstile_event *);
int Closed_notify_invalid_ticket(struct Turnstile *, struct Turnstile_event *);
int Closed_alarm(struct Turnstile *, struct Turnstile_event *);
int Open_release_latch(struct Turnstile *, struct Turnstile_event *);
int Open_return_ticket(struct Turnstile *, struct Turnstile_event *);

enum Turnstile_event_id {
    Turnstile_event_ticket,
    Turnstile_event_pass,
};

struct Turnstile_event {
    enum Turnstile_event_id id;
    void *ctx;
};

struct Turnstile {
    int (*state)(struct Turnstile *, struct Turnstile_event *);
    void *ctx;
};

int Turnstile_init(struct Turnstile *);

int Turnstile_process_event(struct Turnstile *, struct Turnstile_event *);

#endif /**/
