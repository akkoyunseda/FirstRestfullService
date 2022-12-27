package com.garanti.endpoints;

import com.garanti.model.Konu;
import com.garanti.repo.KonuRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "konu")
public class KonuEndpoint {

    private KonuRepo repo;

    public KonuEndpoint(){
        this.repo = new KonuRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Konu> getAll(){
        return repo.getALl();
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getById(@PathParam(value = "id")Integer id){
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Konu konu)
    {
        repo.save(konu);
        return "başarılı";
    }


}
