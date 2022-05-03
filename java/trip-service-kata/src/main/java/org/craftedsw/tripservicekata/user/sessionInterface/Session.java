package org.craftedsw.tripservicekata.user.sessionInterface;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public interface Session {
    public User getLoggedUser();
    public static UserSession getInstance(){return null;};
}
