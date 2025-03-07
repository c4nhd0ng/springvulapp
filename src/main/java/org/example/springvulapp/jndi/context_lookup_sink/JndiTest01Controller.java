package org.example.springvulapp.jndi.context_lookup_sink;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

@RestController
@RequestMapping("/jndi/")

public class JndiTest01Controller {
    @GetMapping("/jnditest01")
    public String jnditest01(@RequestParam(name="name", required = false) String name) throws NamingException {
        if (name == null) {
            return "Name is null";
        }else {

            Context ctx = new InitialContext();
            Object obj = ctx.lookup(name);
            return obj.toString();
        }
    }
}
