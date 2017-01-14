package tp.pr3.inst.assigments;

import tp.pr3.bc.ByteCode;
import tp.pr3.elements.Compiler;

public interface Term {
    Term parse(String term);
    ByteCode compile(Compiler compiler);
}
