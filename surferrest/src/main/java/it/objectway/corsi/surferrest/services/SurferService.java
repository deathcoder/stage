package it.objectway.corsi.surferrest.services;

import it.objectway.corsi.fssurfer.enums.FileType;
import it.objectway.corsi.fssurfer.impl.DataBaseManagerImpl;
import it.objectway.corsi.fssurfer.interfaces.DataBaseManager;
import it.objectway.corsi.fssurfer.models.FileModel;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;

/**
 * Created by stageusr2015 on 22/05/2015.
 */

@Path("/surfer")
public class SurferService {
    private DataBaseManager dbManager = new DataBaseManagerImpl();

    @Context
    UriInfo uriInfo;

    /* Create */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("file")
    public Response putFile(FileModel file) {
        if(dbManager.insertFile(file)) {
            return Response.created(uriInfo.getAbsolutePath()).build();
        }
        return Response.notModified(file.getAbsolutePath()).build();
    }

    /* Read */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("files/count")
    public JSONObject getFilesCount() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("count", dbManager.getCount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("files")
    public FileModel getFileList() {
        ArrayList<FileModel> list = new ArrayList<FileModel>();
        FileModel fm = new FileModel("test", FileType.DIR, "ext", "rwx", 10, "lol");
        list.add(fm);
        return fm;
    }

    /* Update */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("file")
    public Response updateFile(FileModel file) {
        if(dbManager.updateFile(file)) {
            return Response.seeOther(uriInfo.getAbsolutePath()).build();
        }
        return Response.notModified(file.getAbsolutePath()).build();
    }

    /* Delete */
    @DELETE
    @Path("file")
    public FileModel Delete(@QueryParam("abs") String abs) {
        return dbManager.deleteFile(abs);
    }

    public void setDbManager(DataBaseManager dbManager) {
        this.dbManager = dbManager;
    }
}


