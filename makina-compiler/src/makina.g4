grammar makina;

file
    : 'machine' ID ';' state*
    ;

state
    : initial='initial'? 'state' id '{' (handler | state)* '}'
    ;

id
    : ID ('.' ID)*
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
    : '->' ID
    ;

ID  : ('_'|'a'..'z'|'A'..'Z') ('_'|'0'..'9'|'a'..'z'|'A'..'Z')*
    | '`' ~('`')+ '`'
    ;

WHITESPACE : (' '|'\t'|'\u000C'|'\n'|'\r') -> skip ;
COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' -> skip ;
