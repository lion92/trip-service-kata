package org.craftedsw.tripservicekata.TestStub;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripService;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.sessionInterface.Session;

import java.util.List;

public class TripServiceMock extends TripService implements Session {
private final User user=new User();



    @Override
    public User getUser() {
        return user;
    }

    @Override
    public User getLoggedUser() {
        return user;
    }

    @Override
    public List<Trip> getTripList(User user) {

        return List.of(new Trip(), new Trip());
    }

    public User getThisUser(){
        return this.user;
}
}
