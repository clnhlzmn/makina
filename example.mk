machine Turnstile;

initial state Closed {
    entry Closed_apply_latch;
    on ticket -> Open;
    on pass Closed_alarm;
}

state Open {
    entry Open_release_latch;
    on pass -> Closed;
    on ticket Open_return_ticket;
}
