package com.garanti.endpoints;

import com.garanti.model.Ders_Ogrenci;
import com.garanti.model.Ogretmen;
import com.garanti.repo.Ders_OgrenciRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "ders_ogrenci")
public class Ders_OgrenciEndpoint {

    private Ders_OgrenciRepo repo;

    public Ders_OgrenciEndpoint() {
        this.repo = new Ders_OgrenciRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders_Ogrenci> getAll(){
        return repo.getAll();
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        return repo.getById(id);
    }


    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders_Ogrenci ders_ogrenci){
        repo.save(ders_ogrenci);
        return "Başarılı";
    }

}
