package com.garanti.endpoints;

import com.garanti.model.Ogretmen;
import com.garanti.repo.OgretmenRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "/ogretmen")
public class OgretmenEndpoint
{
    private OgretmenRepo repo;

    public OgretmenEndpoint() {
        this.repo = new OgretmenRepo();
    }
    //localhost:9090/FirstRestfulService/ogretmen/getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogretmen> getAll(){
        return repo.getAll();
    }



    //localhost:9090/FirstRestfulService/ogretmen/getById?id=1
    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdQueryParam(@QueryParam(value = "id") Integer id)
    {
        return repo.getById(id);
    }

    //localhost:9090/FirstRestfulService/ogretmen/getById/1
    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        return repo.getById(id);
    }
    //localhost:9090/FirstRestfulService/ogretmen/save
    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogretmen ogretmen){
        repo.save(ogretmen);
        return "Başarılı";
    }
    //localhost:9090/FirstRestfulService/ogretmen/deleteById
}
