package br.com.will.literal;

import br.com.will.annotation.Selector;
import jakarta.enterprise.util.AnnotationLiteral;

public class SelectorLiteral extends AnnotationLiteral<Selector> implements Selector {

    private final String value;

    public SelectorLiteral(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        SelectorLiteral other = (SelectorLiteral) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
