/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.mensagerapi;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilmario
 */
public class MensagemTest {

    public MensagemTest() {
    }

//    @Test
    public void testSomeMethod() {
        List<Sala> lista = new ArrayList<>();
        Sala s = new Sala(1, "Teste");
        lista.add(s);
        String expected = "{\n"
                + "  \"tipo\": \"LOGIN\",\n"
                + "  \"conteudo\": \"Conteudo do arquivo\"\n"
                + "}";
        XStream stream = new XStream(new JsonHierarchicalStreamDriver() {
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }
        });
//        stream.alias("conteudo", String.class);

        stream.toXML(lista);
        System.out.println(stream.toXML(lista));
        assertEquals(stream.toXML(lista), expected);

    }

}
