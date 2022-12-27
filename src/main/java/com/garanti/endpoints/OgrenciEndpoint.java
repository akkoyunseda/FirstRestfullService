package com.garanti.endpoints;

import com.garanti.model.Ogrenci;
import com.garanti.model.Ogretmen;
import com.garanti.repo.OgrenciRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "/ogrenci")
public class OgrenciEndpoint {
    private OgrenciRepo repo;

    public OgrenciEndpoint(){
        this.repo = new OgrenciRepo();
    }

    //localhost:9090/FirstRestfulService/ogrenci/getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogrenci> getAll(){
        return repo.getAll();
    }

    //localhost:9090/FirstRestfulService/ogrenci/getById/1
    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        return repo.getById(id);
    }

    //localhost:9090/FirstRestfulService/ogrenci/save
    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogrenci ogrenci){
        repo.save(ogrenci);
        return "Başarılı";
    }



}
