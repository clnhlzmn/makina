grammar makina;

file
    : 'machine' ID ';' state*
    ;

state
    : 'initial'? 'state' ID parent? '{' handler* '}'
    ;

parent
    : ':' ID
    ;

handler
    : 'entry' ID ';'
    | 'exit' ID ';'
    | 'on' ID guard? action? transition? ';'
    ;

action
    : ID
    ;

guard
    : '(' ID ')'
    ;

transition
    : '->' ID
    ;

ID  : ('_'|'a'..'z'|'A'..'Z') ('_'|'0'..'9'|'a'..'z'|'A'..'Z')*
    | '`' ~('`')+ '`'
    ;

WHITESPACE : (' '|'\t'|'\u000C'|'\n'|'\r') -> skip ;
COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' -> skip ;
