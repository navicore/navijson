lexer grammar NavijsonLexer;

WS: [ \t\n]+ -> skip ;

NUMBER: ('0' .. '9') + ('.' ('0' .. '9') +)?;

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
