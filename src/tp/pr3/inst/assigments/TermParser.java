package tp.pr3.inst.assigments;

public class TermParser {

    private final static Term[] terms = {new Variable(), new Number()};

    /**
     * Convierte un texto a un objeto de tipo <code>instruction</code>.
     *
     * @param linea cadena de texto
     * @return <code>term</code> correspondiente al texto, si es incorrecto
     *         devuelve <code>null</code>
     */
    public static Term parse(String linea) {
        for (Term termParser : terms) {
            Term term = termParser.parse(linea);
            if (term != null) {
                return term;
            }
        }
        return null;
    }
}
