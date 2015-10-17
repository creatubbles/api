package com.creatubbles.api;

import com.creatubbles.api.core.Gallery;
import com.creatubbles.api.request.auth.SignInRequest;
import com.creatubbles.api.response.auth.SignInResponse;
import com.creatubbles.api.response.auth.SignUpResponse;
import com.creatubbles.api.response.creator.CreateCreatorResponse;
import com.creatubbles.api.response.gallery.CreateUserGalleryResponse;
import com.creatubbles.api.response.user.UserProfileResponse;
import com.creatubbles.api.util.EndPoints;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.core.Response;

public class CreatubblesAPI {
    public final static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(SignUpResponse.class, new SignUpResponse())
            .registerTypeAdapter(UserProfileResponse.class, new UserProfileResponse())
            .registerTypeAdapter(CreateCreatorResponse.class, new CreateCreatorResponse())
            .registerTypeAdapter(CreateUserGalleryResponse.class, new CreateUserGalleryResponse())
            .registerTypeAdapter(Gallery.class, new Gallery())
            .create();

    public final static JerseyClient CLIENT = JerseyClientBuilder
            .createClient()
            .register(SignUpResponse.class)
            .property(ClientProperties.CONNECT_TIMEOUT, 5000)
            .property(ClientProperties.READ_TIMEOUT, 5000);

    public static String buildURL(final String endPoint) {
        return EndPoints.URL_BASE + endPoint;
    }

    public static void main(String[] args) {
        Response response = new SignInRequest("pahimar@gmail.com", "Spr0ck3t").execute();
        SignInResponse signInResponse = GSON.fromJson(response.readEntity(String.class), SignInResponse.class);
        System.out.println(signInResponse.access_token);
        System.exit(0);
    }
}