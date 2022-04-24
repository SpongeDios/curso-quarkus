package com.hector.quarkus.app;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    /**

    Si una propiedad es package-private, Quarkus puede inyectarla directamente sin requerir ninguna reflexión.
    Por ello, Quarkus recomienda los miembros package-private para la inyección, ya que trata de evitar la reflexión en la medida de lo posible (la razón de esto es que menos reflexión significa un mejor rendimiento, que es algo que Quarkus se esfuerza por conseguir).
    Ver la sección 2 de esta guía para más detalles. Por lo tanto, cuando inyectamos propiedades con un @ConfigProperty, que es equivalente a @Value es mejor
    NO PONER LA VARIABLE COMO PRIVATE.

     */

    @ConfigProperty(name = "greeting.message")
    String greeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{nombre}")
    public String customHello(@PathParam("nombre") String nombre){
        return  greeting.concat(" "+nombre).concat(" como has estado? aca existe el hot reload tambien");
    }
}