parser grammar NavijsonParser;

options { tokenVocab=NavijsonLexer; }

expr: NUMBER operation NUMBER;

operation: (ADD | SUB | MUL | DIV);
