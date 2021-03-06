/*This file was generated by Makina. Do not modify.*/
#include <stddef.h>
#include "oven.h"

static int oven_closed_idle(struct oven *, struct oven_event *);
static int oven_closed_cooking(struct oven *, struct oven_event *);
static int oven_open(struct oven *, struct oven_event *);

static int oven_closed_idle(struct oven *self, struct oven_event *event) {
	if (!self || !event) return -1;
	switch (event->id) {
	case oven_event_start:
		if (1) {
			self->state = NULL;
			self->state = oven_closed_cooking;
			enable_heater(self, event);
			break;
		}
		break;
	case oven_event_open:
		if (1) {
			self->state = NULL;
			self->state = oven_open;
			break;
		}
		break;
	default: break;
	}
	return 0;
}

static int oven_closed_cooking(struct oven *self, struct oven_event *event) {
	if (!self || !event) return -1;
	switch (event->id) {
	case oven_event_timeout:
		if (1) {
			disable_heater(self, event);
			self->state = NULL;
			self->state = oven_closed_idle;
			break;
		}
		break;
	case oven_event_open:
		if (1) {
			disable_heater(self, event);
			self->state = NULL;
			self->state = oven_open;
			break;
		}
		break;
	default: break;
	}
	return 0;
}

static int oven_open(struct oven *self, struct oven_event *event) {
	if (!self || !event) return -1;
	switch (event->id) {
	case oven_event_close:
		if (1) {
			self->state = NULL;
			self->state = oven_closed_idle;
			break;
		}
		break;
	case oven_event_start:
		if (1) {
			error(self, event);
			break;
		}
		break;
	default: break;
	}
	return 0;
}

int oven_init(struct oven *self) {
	if (!self) return -1;
	self->state = oven_closed_idle;
	return 0;
}

int oven_process_event(struct oven *self, struct oven_event *event) {
	if (!self || !event) return -1;
	if (!self->state) return -1;
	self->state(self, event);
	return 0;
}
