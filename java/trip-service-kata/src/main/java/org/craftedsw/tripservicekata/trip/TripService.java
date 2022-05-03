package org.craftedsw.tripservicekata.trip;

import java.util.List;
import java.util.stream.Collectors;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedUser = getUser();

        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
        return isLoggedFriend(user, loggedUser);
    }

    private List<Trip> isLoggedFriend(User user, User loggedUser) {
       boolean isFriend;
        List<Trip> trips;
        isFriend = isFriendMyFriend(user, loggedUser);
        trips=getTripList(user).stream().filter(trip -> isFriend).collect(Collectors.toList());
        return trips;
    }

    public boolean isFriendMyFriend(User user, User loggedUser) {
        return user.getFriends().contains(loggedUser);
    }

    public List<Trip> getTripList(User user) {
        return TripDAO.findTripsByUser(user);
    }

    public User getUser() {
        return UserSession.getInstance().getLoggedUser();
    }

}
