#include "turnstile.h"

static int Turnstile_Closed(struct Turnstile *, struct Turnstile_event *);
static int Turnstile_Open(struct Turnstile *, struct Turnstile_event *);

static int Turnstile_Closed(struct Turnstile *self, struct Turnstile_event *evt) {
    if (!self || !evt) return -1;
    /*find matching event id and passing guard*/
    if (evt->id == Turnstile_event_ticket && Closed_valid_ticket(self, evt)) {
        /*do exit actions*/
        /*do handler action*/
        /*assign new state*/
        self->state = Turnstile_Open;
        /*do entry actions*/
        Open_release_latch(self, NULL);
    } else if (evt->id == Turnstile_event_ticket) {
        /*do handler action*/
        Closed_notify_invalid_ticket(self, evt);
    } else if (evt->id == Turnstile_event_pass) {
        /*do handler action*/
        Closed_alarm(self, evt);
    }
}

static int Turnstile_Open(struct Turnstile *self, struct Turnstile_event *evt) {
    if (!self || !evt) return -1;
    if (evt->id == Turnstile_event_pass) {
        self->state = Turnstile_Closed;
        Closed_apply_latch(self, NULL);
    } else if (evt->id == Turnstile_event_ticket) {
        Open_return_ticket(self, evt);
    }
}

int Turnstile_init(struct Turnstile *self) {
    if (!self) return -1;
    self->state = Turnstile_Closed;
    Closed_apply_latch(self, NULL);
}

int Turnstile_process_event(struct Turnstile *self, struct Turnstile_event *evt) {
    if (!self || !evt) return -1;
    self->state(self, evt);
}
