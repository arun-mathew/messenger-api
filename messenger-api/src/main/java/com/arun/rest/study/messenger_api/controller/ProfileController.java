package com.arun.rest.study.messenger_api.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.arun.rest.study.messenger_api.model.Profile;
import com.arun.rest.study.messenger_api.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileController {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profileService.getAllProfiles());
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfileById(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileId}")
	public Profile updateProfile(Profile profile,@PathParam("profileId") long profileId) {
		profile.setId(profileId);
		return profileService.updateProfile(profile);
	}
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName")String profileName) {
		profileService.deleteProfile(profileName);
	}
}
