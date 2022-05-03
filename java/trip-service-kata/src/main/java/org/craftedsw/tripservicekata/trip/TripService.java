package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = getUser();
        boolean isFriend = false;
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
        return isLoggedFriend(user, loggedUser, isFriend);
    }

    private List<Trip> isLoggedFriend(User user, User loggedUser, boolean isFriend) {
        List<Trip> trips=new ArrayList<>();
        isFriend = isFriendMyFriend(user, loggedUser, isFriend);
        if (isFriend) {
            trips = getTripList(user);
        }
        return trips;
    }

    public boolean isFriendMyFriend(User user, User loggedUser, boolean isFriend) {
        for (User friend : user.getFriends()) {
            if (friend.equals(loggedUser)) {
                isFriend = true;
                break;
            }
        }
        return isFriend;
    }

    public List<Trip> getTripList(User user) {
        return TripDAO.findTripsByUser(user);
    }

    public User getUser() {
        return UserSession.getInstance().getLoggedUser();
    }

}
