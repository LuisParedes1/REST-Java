package ar.uba.tdd.cliente_servidor;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static org.junit.gen5.api.Assertions.*;

public class ServidorTest {

    @Test
    void createCNonNullServer(){
        assertNotNull(new Server());
    }
}
