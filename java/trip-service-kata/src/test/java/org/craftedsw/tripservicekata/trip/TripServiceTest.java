package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.TestStub.TripDaoMock;
import org.craftedsw.tripservicekata.TestStub.TripServiceMock;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TripServiceTest {

    @Test
    public void ShouldOneTripForUserWhenUserOrderOneTrip(){
        User user=new User();
        Trip trip=new Trip();
        user.addTrip(trip);

        //List<Trip> listUser=new TripService().getTripsByUser(user);
        assertThat(user.trips().size()).isEqualTo(1);
    }
    @Test
    public void ShouldOneFriendForUserWhenUserAddOneFriend(){
        User user=new User();
        User user2=new User();
        user.addFriend(user2);

        //List<Trip> listUser=new TripService().getTripsByUser(user);
        assertThat(user.getFriends().size()).isEqualTo(1);
    }

    @Test
    public void ShoulReturnListVideWhenUserHasNoTrip(){
        User user=new User();
        User user2=new User();
        user.addFriend(user2);

        TripService tripService=new TripServiceMock();
        //List<Trip> listUser=new TripService().getTripsByUser(user);
        assertThat(tripService.getTripsByUser(user).size()).isEqualTo(0);
    }

    @Test
    public void ShoulReturnListOneWhenUserHasATrip(){
        User user=new User();

        user.addTrip(new Trip());

        TripDaoMock tripDaoMock=new TripDaoMock();
        TripService tripService=new TripServiceMock();
        //List<Trip> listUser=new TripService().getTripsByUser(user);
        assertThat(tripService.getTripList(user).size()).isEqualTo(2);
    }

    @Test
    public void ShoulReturnTrueWhenUserFriendIsUser(){
        User user=new User();
        User user2=new User();
        user.addFriend(user2);

        TripDaoMock tripDaoMock=new TripDaoMock();
        TripService tripService=new TripServiceMock();
        assertThat(tripService.isFriendMyFriend(user,user2,false)).isEqualTo(true);
    }

    @Test
    public void ShoulReturnFalseWhenUserFriendIsNotTheUser(){
        User user=new User();
        User user2=new User();
        User user3=new User();
        user.addFriend(user3);

        TripService tripService=new TripServiceMock();
        assertThat(tripService.isFriendMyFriend(user,user2,false)).isEqualTo(false);
    }


}
