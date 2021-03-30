grammar makina;

file
    : 'machine' ID ';' state* EOF
    ;

state
    : stateType id '{' (handler | state)* '}'
    ;

stateType
    : 'initial' 'state'?                        #initialType
    | initial='initial'? 'parallel' 'state'?    #parallelType
    | 'final' 'state'?                          #finalType
    | 'state'                                   #defaultType
    ;

id
    : root='.'? ID ('.' ID)*
    ;

handler
    : 'entry' action ';'                        #entryHandler
    | 'exit' action ';'                         #exitHandler
    | 'on' ID guard? action? target? ';'        #eventHandler
    ;

action
    : ID
    ;

guard
    : '(' ID ')'
    ;

target
    : '->' id       #defaultTransition
    | '-->' id      #externalTransition
    ;

ID  : ('_'|'a'..'z'|'A'..'Z') ('_'|'0'..'9'|'a'..'z'|'A'..'Z')*
    | '`' ~('`')+ '`'
    ;

WHITESPACE : (' '|'\t'|'\u000C'|'\n'|'\r') -> skip ;
COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' -> skip ;
