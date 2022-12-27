package com.garanti.endpoints;


import com.garanti.model.Ders;
import com.garanti.model.Ogretmen;
import com.garanti.repo.DersRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "ders")
public class DersEndpoint {
    private DersRepo repo;

    public DersEndpoint() {
        this.repo = new DersRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders> getAll(){
        return repo.getAll();
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getById(@PathParam(value = "id") Integer id){
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders ders)
    {
        // localhost:9090/FirstRestfulService/ogretmen/save
        repo.save(ders);
        return "Başarı ile kaydedildi";
    }


}
