# Makina

**Makina is a work in progress. Use at your own risk.**

Makina is a hierarchical state machine source-to-source translator. It takes state machine descriptions as input and produces C language implementations of those state machines.

## [Demo](https://clnhlzmn.github.io/Makina-demo/)

## Syntax

Each file given as input to the Makina compiler represents a single state machine. At the top of the file the name of the machine is specified with a `machine` statement:

### Machines

```
machine Oven;
```

Here the machine is called `Oven`.

### States

States are defined below that with `state` definitions:

```
machine Oven;
state closed {
    
}
```

Now the state machine `Oven` has one state called `closed`.

Of course state machines usually have more than one state. As many states as are required can be added to a single machine:

```
machine Oven;
state closed {
    
}
state open {
    
}
```

Now `Oven` has two states: `closed` and `open`.

### Event Handlers

In addition to states, state machines also define events. Events are triggers that cause the state machine to take action. In order to assign an action to an event a `state` must include an event handler that could look like this:

```
machine Oven;
state closed {
    on open -> open;
}
state open {
    
}
```

The state `closed` now has an handler for the event named `open`. The handler causes the machine `Oven` to transition from `closed` to `open`. The full syntax for an event handler looks like this:

```
on <event-id> [(<guard>)] [<action>] [->|--> <target>];
```

The things in angle brackets can be arbitrary identifiers that conform to the C language concept of an identifier. Things in square brackets are optional. In the case above the handler includes an optional transition target, but not a guard or action.

Guards and actions can be used to create complex behavior. If a state includes a guarded handler then the user defined function that implements the guard must return a true value for the handler to be triggered. For example:

```
on foo (some_guard) guarded_action;
on foo default_action;
```

If a state has the previous two handlers defined and is processing the event `foo` first the user defined (C language) function `some_guard` will be called. If its return value is true then the function `guarded_action` will be called. If `some_guard` returned 0 then the machine will continue checking for handlers for event `foo`. The next defined handler is not guarded, so the function `default_action` will be called.

All actions and guards are implemented by the user as C language functions with the following prototype:

```
int <function-name>(struct <machine-name> *, struct <machine_name>_event *);
```

Transition targets can be default  (`-> <target>`) or external (`--> <target>`). Default transitions behave like a [local transition](https://statecharts.github.io/glossary/local-transition.html) (they don't exit the source state) when the target state is a descendant of the source state and like an external transition otherwise. External transitions always cause the source state to exit.

### Hierarchical States

To avoid duplicating event handlers for similar states Makina allows you to define sub states that defer unhandled events to their parent states. The `closed` state of the oven machine might have a few sub states:

```
machine Oven;
initial state closed {
    on open -> open;
    initial state idle {
        on start -> cooking;
    }
    state cooking {
        entry enable_heater;
        on timeout -> idle;
        exit disable_heater; 
    }
}
state open {
    on close -> closed;
    on start error;
}
```

Now state `closed` has two sub states: `idle` and `cooking`. Additionally the states `closed` and `closed.idle` have been designated as `initial`. This isn't strictly necessary in this case, because default initial states are those appearing first in document order, but has been added to show the syntax. Initial states are the states that are first entered when the machine is initialized.

Since neither sub state of `closed` defines a handler for the `open` event if the `Oven` machine is in either of those states when an `open` event is processed the parent state's handler, and any associated actions or transitions, will be triggered. In this case the `open` event will cause a transition to the `open` state regardless of which sub state was active.

### Entry and Exit Actions

Entry and exit actions are similar to event handlers except they are triggered when a state is entered or exited. For example: the entry handler `entry enable_heater;` in state `closed.cooking` causes the function `enable_heater` to be called when that state is entered. Similarly, `exit disable_heater;` causes `disable_heater` to be called when state `closed.cooking` is exited. Exit handlers will be triggered event if the event that causes the transition is defined in a parent state as is the case with the `open` event in the example above.

## Invoking Makina

### Get the jar

Clone the repo and build the makina-compiler project using Intellij. Or download the latest jar from [here](https://github.com/clnhlzmn/makina/raw/master/makina-compiler/out/artifacts/makina_compiler_jar/makina-compiler.jar).

### Run the compiler

```
java -jar <path>/<to>/makina-compiler.jar <input-file> [<input-file-2>] [<other-options>]
```

### Output

Two files, `<machine-name>.h` and `<machine-name>.c` will be created (or overwritten!) in the same directory as `<input-file>` or in the specified output directory.

### Command line options

`-o <path>`  or `--output <path>`: Specify the output path for generated files.

`-m <type>`  or `--machine-data <type>`: Specify the type of the `ctx` member of the generated machine type. The default type is `void *`. May occur zero or one times.

`-e <type>`  or `--event-data <type>`: Specify the type of the `ctx` member of the generated event type. The default type is `void *`. May occur zero or one times.

`-i <file>`  or `--include <file>`: Specify files to include in the generated C header. This can be used to provide definitions of custom types specified with `-e` or `-m`. May occur zero or more times.
