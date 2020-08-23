package edu.eci.cvds.tdd.registry;

import java.util.HashMap;

public class Registry {
    private HashMap<Integer,Person> voters;

    public Registry(){
        voters = new HashMap<Integer,Person>();
    }

    public RegisterResult registerVoter(Person p) {
        Integer id = p.getId();
        RegisterResult registerResult = RegisterResult.VALID;
        boolean isAlive = p.isAlive();
        int age = p.getAge();

        if (voters.containsKey(id) ){
            registerResult = RegisterResult.DUPLICATED;
        }
        else if( !isAlive ){
            registerResult = RegisterResult.DEAD;
        }
        else if (  age<= 0 ){
            registerResult = RegisterResult.INVALID_AGE;
        }
        else if (  age< 18 ){
            registerResult = RegisterResult.UNDERAGE;
        }
        else{
            voters.put(id,p);
        }

        // TODO Validate person and return real result.
        return registerResult;
    }
}