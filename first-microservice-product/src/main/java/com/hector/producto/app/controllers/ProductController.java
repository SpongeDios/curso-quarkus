package com.hector.producto.app.controllers;

import com.hector.producto.app.entity.Producto;
import com.hector.producto.app.repositories.ProductRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@ApplicationScoped
@Path("/api/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GET
    public List<Producto> listAll(){
        return productRepository.listAll();
    }

    @POST
    public Response add(Producto producto){
        productRepository.create(producto);
        return Response.created(URI.create("/api/products")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id){
        Long overrideId = Long.parseLong(id);
        productRepository.delete(overrideId);
        return Response.noContent().build();
    }


}
