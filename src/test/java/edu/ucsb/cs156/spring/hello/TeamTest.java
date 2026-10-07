package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }
    //Test for name fetching
    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    //Test for string fetching/validation
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    //Test for group validation, same team (true case)
    @Test 
    public void equals_returns_true_for_same_team() {
        assertEquals(true, team.equals(team));
    }
    //Test for group validation (false case)
    @Test
    public void equals_returns_false_for_wrong_team() {
        assertEquals(false, team.equals("not a team"));
    }
    //Test for other group validation (true case)
    @Test
    public void equals_returns_true_for_equivalent_team() {
        Team other = new Team("test-team");
        assertEquals(true, team.equals(other));
    }
    //Test for other group validation (false case)
    @Test
    public void equals_returns_false_for_non_equivalent_teams() {
        Team other = new Team("non-equivalent-team");
        assertEquals(false, team.equals(other));
    }
    //Hash test presented by Professor Conrad
    @Test
    public void hashCode_returns_correct_value_for_equal_teams(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    //Hash test presented by Professor Conrad
    @Test
    public void hashCode_equivalent_mutation_solver() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
